import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class InstructionSelection{
    public static void main(String[] args) throws IOException{
        
        try(BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
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
                    
                    //when function calls, return, goto 
                    else{
                        System.out.println(op + sCurrentLine);
                    }
                }
            }
            System.out.println("===========END===========");
            
        }catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
