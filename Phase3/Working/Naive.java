
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Naive{
    public static void main(String[] args) throws IOException{
        int i = 0;
        try(BufferedReader br = new BufferedReader(new FileReader("IR.txt"))) {
            String sCurrentLine = "";
            while(!sCurrentLine.contains("END")){
                sCurrentLine = br.readLine();
        
                if((!sCurrentLine.contains(":"))&&(!sCurrentLine.contains("END"))){
                    System.out.println(sCurrentLine);
                }
            }
            
    
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}