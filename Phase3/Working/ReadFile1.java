
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile1{
	public static void main(String[] args) throws IOException {

	int i = 0;
		try(BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
		String sCurrentLine = "";
		while(i < 8)  {
			br.readLine();
			i++;
		}
		i = 0;
		do{
			sCurrentLine = br.readLine();
			if (!sCurrentLine.contains("END IR CODE")) {
				if(sCurrentLine.contains(":")) 
					System.out.println(sCurrentLine);
				else 
					System.out.println(++i + ") "+sCurrentLine);
			}
		
		} while(!sCurrentLine.contains("END IR CODE"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}


