
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class IRGenerator{
    public static void main(String[] args) throws IOException {
        
        int i = 0;
        try(BufferedReader br = new BufferedReader(new FileReader("terminal_result.txt"))) {
            String sCurrentLine = br.readLine();
            while(!sCurrentLine.contains("================= IR CODE ================"))  {
                sCurrentLine = br.readLine();
                
            }
            while(!sCurrentLine.contains("=============== END IR CODE ==============")){
                sCurrentLine = br.readLine();
                
                if(!sCurrentLine.contains("=============== END IR CODE ==============")){
                    System.out.println(sCurrentLine);
                }
            }
            //System.out.println("===========END===========");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
    }
}


