
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SymbolTableGenerator{
    public static void main(String[] args) throws IOException {
        
        int i = 0;
        try(BufferedReader br = new BufferedReader(new FileReader("terminal_result.txt"))) {
            String sCurrentLine = br.readLine();
            while(!sCurrentLine.contains("Building symbol table and performing semantic checks..."))  {
                sCurrentLine = br.readLine();
                
            }
            while(!sCurrentLine.contains("Ended symbol table and giving you IR Code...")){
                sCurrentLine = br.readLine();
                
                if(!sCurrentLine.contains("Ended symbol table and giving you IR Code...") &&
                   !sCurrentLine.contains("Successfully finished semantic checks")){
                    System.out.println(sCurrentLine);
                }
            }
            //System.out.println("<<<<<<<<End Flag>>>>>>>>>");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
    }
}


