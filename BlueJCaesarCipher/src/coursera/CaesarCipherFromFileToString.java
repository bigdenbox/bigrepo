package coursera;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CaesarCipherFromFileToString {
	String stringFromFile;
	{
		try {
			File file = new File("src\\coursera\\File.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			try {
				stringFromFile = br.readLine();
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		
	}
}
