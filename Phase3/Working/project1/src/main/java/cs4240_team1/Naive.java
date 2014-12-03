package cs4240_team1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import cs4240_team1.SymbolTable;
import cs4240_team1.SymTableWalker;

public class Naive {
    
    private SymbolTable globalSymbolTable, tempSymbolTable;
    private List<SymbolTable> childrenSymbolTables;

    public Naive(SymbolTable globalSymbolTable, SymbolTable tempSymbolTable) {
	this.globalSymbolTable = globalSymbolTable;
	this.childrenSymbolTables = globalSymbolTable.getChildren();
	this.tempSymbolTable = tempSymbolTable;
    }
    
    private void assign(String op, String zero, String one, String two){
        int i = 0;
        if(two.equals("")){
            if(!(one.matches("\\d+"))){
		System.out.println("[DEBUG] operand being assigned is: " + one);
		SymbolTableEntry operandType = null;
		System.out.println("[DEBUG] first looking up the global symbol table's children tables...");
		for (SymbolTable child : childrenSymbolTables) {
		    operandType = child.lookup(one);
		}
		if (operandType == null) {
		    System.out.println("[DEBUG] operand not found in chidlren tables...now looking up tempSymbolTable");
		    operandType = tempSymbolTable.lookup(one);
		}
		System.out.println("[DEBUG] operandType is: " + operandType);
		if (operandType instanceof VarEntry) {
		    System.out.println("[DEBUG] operandType is an instance of VarEntry!");
		    System.out.println("[DEBUG] operandType's typeId is: " + ((VarEntry)operandType).typeId);
		    if (((VarEntry)operandType).typeId.equals("int")) {
			System.out.println("Load " + one + ", " + "t" + i);
			one = "t" + i;
		    }
		    else if (((VarEntry)operandType).typeId.equals("fixedpt")) {
			System.out.println("Load " + one + ", " + "f" + i);
			one = "f" + i;
		    }
		    i++;
		}
            }
            System.out.println("Store " + one + ", " + zero);
        }
        
        //need to be implemented : assign, arr_2D__#6, _t11, 1
        //is it possible to have temp value for last argument?
        else{
            if(!(one.matches("\\d+"))){
                System.out.println("Load " + one + ", " + "temp#" + i);
                one = "temp#" + i;
                i++;
            }
            if(!(two.matches("\\d+"))){
                System.out.println("Load " + two + ", " + "temp#" + i);
                two = "temp#" + i;
                i++;
            }
        }
    }
    
    private void binaryOp (String op, String zero, String one, String two){
        int i = 0;
        if(!(zero.matches("\\d+"))){
	    SymbolTableEntry operandType = null;
	    for (SymbolTable child : childrenSymbolTables) {
		operandType = child.lookup(zero);
	    }
	    if (operandType == null) {
		operandType = tempSymbolTable.lookup(zero);
	    }
	    if (operandType instanceof VarEntry) {
		if (((VarEntry)operandType).typeId.equals("int")) {
		    System.out.println("Load " + zero + ", " + "t" + i);
		    zero = "t" + i;
		}
		else if (((VarEntry)operandType).typeId.equals("fixedpt")) {
		    System.out.println("Load " + zero + ", " + "f" + i);
		    zero = "f" + i;
		}
		i++;
	    }
        }
        if(!(one.matches("\\d+"))){
	    SymbolTableEntry operandType = null;
	    for (SymbolTable child : childrenSymbolTables) {
		operandType = child.lookup(one);
	    }
	    if (operandType == null) {
		operandType = tempSymbolTable.lookup(one);
	    }
	    if (operandType instanceof VarEntry) {
		if (((VarEntry)operandType).typeId.equals("int")) {
		    System.out.println("Load " + one + ", " + "t" + i);
		    one = "t" + i;
		}
		else if (((VarEntry)operandType).typeId.equals("fixedpt")) {
		    System.out.println("Load " + one + ", " + "f" + i);
		    one = "f" + i;
		}
		i++;
	    }
        }
        switch (op) {
            case "add"   : System.out.println("ADD " + zero + ", " + one + ", " + "temp#" + i);
                break;
            case "sub"   : System.out.println("SUB " + zero + ", " + one + ", " + "temp#" + i);
                break;
            case "mult"  : System.out.println("MUL " + zero + ", " + one + ", " + "temp#" + i);
                break;
            case "div"   : System.out.println("DIV " + zero + ", " + one + ", " + "temp#" + i);
                break;
            case "and"   : System.out.println("AND " + zero + ", " + one + ", " + "temp#" + i);
                break;
            case "or"  : System.out.println("OR " + zero + ", " + one + ", " + "temp#" + i);
                break;
            default    : System.out.println("Wrong command");
                break;
        }
        
        System.out.println("Store " + "temp#" + i + ", " + two);
        
    }
    
    
    private void branch (String op, String zero, String one, String two){
        int i = 0;
        
        if(!(zero.matches("\\d+"))){
            System.out.println("Load " + zero + ", " + "temp#" + i);
            zero = "temp#" + i;
            i++;
        }
        
        if(!(one.matches("\\d+"))){
            System.out.println("Load " + one + ", " + "temp#" + i);
            one = "temp#" + i;
            i++;
        }
        
        switch (op) {
            case "breq"   : System.out.println("breq " + zero + ", " + one + ", " + two);
                break;
            case "brneq"   : System.out.println("brneq " + zero + ", " + one + ", " + two);
                break;
            case "brlt"  : System.out.println("brlt " + zero + ", " + one + ", " + two);
                break;
            case "brgt"   : System.out.println("brgt " + zero + ", " + one + ", " + two);
                break;
            case "and"   : System.out.println("brgeq " + zero + ", " + one + ", " + two);
                break;
            case "brgeq"  : System.out.println("brleq " + zero + ", " + one + ", " + two);
                break;
            default    : System.out.println("Wrong command");
                break;
        }
        
    }
    
    private void arrayCall(String op, String zero, String one, String two){
        int i = 0;
        if(op.equals("array_load")){
            if(!(two.matches("\\d+"))){
                System.out.println("Load " + two + ", " + "temp#" + i);
                two = "temp#" + i;
                i++;
            }
            
            //dont i need to know the size of array? int.. 4 fixed point 4..
            System.out.println("Load " + one +"[" + two + "]" + ", " + "temp#" + i);
            System.out.println("Store " + "temp#" + i + ", " +  zero);
            
        }
        else{
            if(!(one.matches("\\d+"))){
                System.out.println("Load " + one + ", " + "temp#" + i);
                one = "temp#" + i;
                i++;
            }
            
            if(!(two.matches("\\d+"))){
                System.out.println("Load " + two + ", " + "temp#" + i);
                two = "temp#" + i;
                i++;
            }
            
            //dont i need to know the size of array? int.. 4 fixed point 8..
            System.out.println("Store " + zero +"[" + one + "]" + ", " + two);

        }
    }


    public void generateAssembly() throws IOException {

        try(BufferedReader br = new BufferedReader(new FileReader("IR.txt"))) {
            String sCurrentLine = "";
            while(!sCurrentLine.contains("END")){
                sCurrentLine = br.readLine();

                    if(!(sCurrentLine.contains("END"))){
                        String op = sCurrentLine.substring(0, (sCurrentLine.indexOf(",")));
                        sCurrentLine =  sCurrentLine.substring((sCurrentLine.indexOf(",")));

                        String[] argArr = new String[3];
                        if( (!(op.equals("call"))) && (!(op.equals("callr"))) && (!(op.equals("return"))) && (!(op.equals("goto")))){
                            for(int i = 0; i < 3; i++){
                                if(sCurrentLine.startsWith(",")){
                                    sCurrentLine = sCurrentLine.substring(1);
                                }
                
                                sCurrentLine = sCurrentLine.trim();
                                if(sCurrentLine.contains(",")){
                                    argArr[i] = sCurrentLine.substring(0, (sCurrentLine.indexOf(",")));
                                    sCurrentLine =  sCurrentLine.substring((sCurrentLine.indexOf(",")));
                                }
                                
                                else{
                                    argArr[i] = sCurrentLine.trim();
                                }
                            }
                            

                            if(op.equals("assign"))assign (op, argArr[0], argArr[1], argArr[2]);
                            
                            else if((op.equals("add")) || (op.equals("sub")) || (op.equals("mult")) || (op.equals("div")) || (op.equals("and")) || (op.equals("or")))
                                binaryOp (op, argArr[0], argArr[1], argArr[2]);
                            
                            else if((op.equals("breq")) || (op.equals("brneq")) || (op.equals("brlt")) || (op.equals("brgt")) || (op.equals("brgeq")) || (op.equals("brleq")))
                                branch(op, argArr[0], argArr[1], argArr[2]);
                            
                            
                            
                            else if((op.equals("array_store")) || (op.equals("array_load")))
                                arrayCall (op, argArr[0], argArr[1], argArr[2]);
                            
                            else{
                                System.out.println("unknown op");
                            }
                            
                        }
                        
                        else{
                            System.out.println(op + sCurrentLine);
                        }
                    }
                }
            }catch (IOException e) {
            e.printStackTrace();
            }
    
    }
}
