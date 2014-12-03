

/////////////////
////////////////
/////////////////
///////////////////
////////////

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class NaiveAssemblyGenerator{
    
    public static String newLine = "\n";
    public static String he = " ";

    public static String empty = "	";
    public static String temp = "$t";
    public static String w = ".word";
    public static String s = ".space";
    public static String f = ".float";
    
    
    public static String dataSegment = "	.data\n";
    public static String textSegment = empty + ".text\n" + empty + empty +  ".globl main\nmain:	";
    
    public static boolean dataSegmentContains(String check){
        return dataSegment.contains(he +check + ":");
    }
    

    public static void assign (String op, String zero, String one, String two){
        int i = 0;
        if(two.equals("")){
            if(!(dataSegmentContains(zero))){
                //when zero is int
                dataSegment += he + zero + ":" + empty + w + "   0" + newLine;
                //when zero is float
                //    dataSegment += zero + ":" + empty + f + "   0" + newLine;
            }
            if(!(one.matches("\\d+"))){

                if(!(dataSegmentContains(one))){
                    //when zero is int
                    dataSegment += he + one + ":" + empty + w + "   0" + newLine;
                    //when zero is float
                    //    dataSegment += one + ":" + empty + f + "   0" + newLine;
                }
                textSegment += "lw, " + temp + i + ", " + one + newLine;
                one = temp + i;
            }
            textSegment += "sw, " + one + ", " + zero + newLine;
            System.out.println(dataSegment + textSegment);
        }
        
        //need to be implemented
        else{
            if(!(one.matches("\\d+"))){
                System.out.println("Load, " + one + ", " + "temp#" + i);
                one = "temp#" + i;
                i++;
            }
            if(!(two.matches("\\d+"))){
                System.out.println("Load, " + two + ", " + "temp#" + i);
                two = "temp#" + i;
                i++;
            }
        }
    }
    
    
    public static void binaryOp (String op, String zero, String one, String two){
        int i = 0;
        boolean flag = false;
        if(!(two.matches("\\d+"))){
            if(!(dataSegmentContains(two))){
                dataSegment += he + two + ":" + empty + w + "   0" + newLine;   //    or dataSegment += zero + ":" + empty + f + "   0" + newLine;
            }
        }
        
        
        if(!(zero.matches("\\d+"))){
            if(!(dataSegmentContains(zero))){
                dataSegment += he + zero + ":" + empty + w + "   0" + newLine;   //    or dataSegment += zero + ":" + empty + f + "   0" + newLine;
            }
            textSegment += "lw, " + temp + i + ", " + zero + newLine;
            zero = temp + i;
            i++;
            flag = true;
        }
        
        if(!(one.matches("\\d+"))){
            if(!(dataSegmentContains(one))){
                dataSegment += he + one + ":" + empty + w + "   0" + newLine;   //    or dataSegment += zero + ":" + empty + f + "   0" + newLine;
            }
            textSegment += "lw, " + temp + i + ", " + one + newLine;
            one = temp + i;
            i++;
            flag = true;
        }
        
        
        switch (op) {
            case "add"   :
                if(!flag)   textSegment += "add, " + temp + i + ", " + zero + ", " + one + newLine;
                else    textSegment += "addi, " + temp + i + ", " + zero + ", " + one + newLine;
                break;
            
            case "sub"   :  textSegment += "sub, " + temp + i + ", " + zero + ", " + one + newLine;
                break;
                
            case "mult"  :  textSegment += "mul, " + temp + i + ", " + zero + ", " + one + newLine;
                break;
                
            case "div"   :  textSegment += "div, " + temp + i + ", " + zero + ", " + one + newLine;
                break;
                
            case "and"   :  textSegment += "and, " + temp + i + ", " + zero + ", " + one + newLine;
                break;
                
            case "or"  : textSegment += "or, " + temp + i + ", " + zero + ", " + one + newLine;
                break;
                
            default    : System.out.println("Wrong command");
                break;
        }
        
        textSegment += "sw, " + temp + i + ", " + two + newLine;
        //System.out.println("Store, " + "temp#" + i + ", " + two);
        
    }
    public static void branch (String op, String zero, String one, String two){
        int i = 0;
        
        if(!(zero.matches("\\d+"))){
            if(!(dataSegmentContains(zero))){
                dataSegment += he + zero + ":" + empty + w + "   0" + newLine;   //    or dataSegment += zero + ":" + empty + f + "   0" + newLine;
            }
            textSegment += "lw, " + temp + i + ", " + zero + newLine;
            zero = temp + i;
            i++;
        }
        
        if(!(one.matches("\\d+"))){
            if(!(dataSegmentContains(one))){
                dataSegment += he + one + ":" + empty + w + "   0" + newLine;   //    or dataSegment += zero + ":" + empty + f + "   0" + newLine;
            }
            textSegment += "lw, " + temp + i + ", " + one + newLine;
            one = temp + i;
            i++;
        }
        
        switch (op) {
                
            case "breq"   :
                textSegment += "beq, " + zero + ", " + one + ", " + two + newLine;
                break;
            case "brneq"   :
                textSegment += "bne, " + zero + ", " + one + ", " + two + newLine;
                break;
            case "brlt"  :
                textSegment += "bge, " + zero + ", " + one + ", " + two + newLine;
                break;
            case "brgt"   :
                textSegment += "ble, " + zero + ", " + one + ", " + two + newLine;
                break;
            case "brgeq"   :
                textSegment += "blt, " + zero + ", " + one + ", " + two + newLine;
                break;
            case "brleq"  :
                textSegment += "bgt, " + zero + ", " + one + ", " + two + newLine;
                break;
            default    : System.out.println("Wrong command");
                break;
        }
        
    }

    
    public static void main(String[] args) throws IOException{
        
        
        try(BufferedReader br = new BufferedReader(new FileReader("IR.txt"))) {
            String sCurrentLine = "";
            while(!sCurrentLine.contains("END")){
                sCurrentLine = br.readLine();
                
                if((!sCurrentLine.contains(":")) && !(sCurrentLine.contains("END"))){
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
                        
                        else if((op.equals("array_store")) || (op.equals("array_load"))){}
                        //    arrayCall (op, argArr[0], argArr[1], argArr[2]);
                        
                        
                    }
                    else{
                        textSegment += op + sCurrentLine + newLine;
                    }
                    
                }
                
                else if (sCurrentLine.contains(":")){
                    textSegment += sCurrentLine + newLine;
                }
                
            }
            System.out.println(dataSegment + textSegment);

            System.out.println("===========END===========");
            
        }catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
