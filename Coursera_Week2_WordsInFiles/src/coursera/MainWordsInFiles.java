package coursera;

import java.io.File;
import java.io.FileNotFoundException;

import edu.duke.FileResource;

public class MainWordsInFiles {

	public static void main(String[] args) throws FileNotFoundException {
		WordsInFiles wif = new WordsInFiles();
/*		File f1 = new File("src\\brief1.txt");
		wif.addWordsFromFile(f1);
		
		File f2 = new File("src\\brief2.txt");
		wif.addWordsFromFile(f2);
		
		File f3 = new File("src\\brief3.txt");
		wif.addWordsFromFile(f3);
		
		File f4 = new File("src\\brief4.txt");
		wif.addWordsFromFile(f4);
*/
		
		wif.buildWordFileMap();
		System.out.println("MaxNumber = " + wif.maxNumber());
//		wif.printWordsInNumFiles(5);
		
//		System.out.println(wif.hashWords.toString());
		
		wif.printFilesIn("red");
		

	}

}
