
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile{
	public static void main(String[] args) throws IOException {

	int i = 0;
		try(BufferedReader br = new BufferedReader(new FileReader("result.txt"))) {
		String sCurrentLine = "";
		while(i < 8)  {
			br.readLine();
			i++;
		}
		do{
			sCurrentLine = br.readLine();
			if (!sCurrentLine.contains("END IR CODE")) {
				System.out.println(sCurrentLine);
			}
		
		} while(!sCurrentLine.contains("END IR CODE"));
        System.out.println("===========END===========");

		} catch (IOException e) {
			e.printStackTrace();
		}
        

	}
}


