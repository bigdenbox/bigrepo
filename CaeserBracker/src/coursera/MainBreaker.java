package coursera;

import edu.duke.FileResource;

public class MainBreaker {

	public static void main(String[] args) {
		CaesarBreaker breaker = new CaesarBreaker();
/*		int [] countLetters = breaker.countLetters("src\\coursera\\wordsLotsOfEs.txt");
		
		System.out.println(breaker.maxIndex(countLetters));*/
		
//		breaker.testDecrypt("src\\coursera\\encrypted.txt");
	//	breaker.testDecrypt("src\\coursera\\romeo.txt");

	//	System.out.println(breaker.halfOfString("Qbkm Zgis", 8));
		
		FileResource file =new FileResource ("src\\coursera\\mysteryTwoKeysQuiz.txt");
		System.out.println(breaker.decryptTwoKeys(file.asString()));

		
//**    System.out.println(breaker.decryptTwoKeys(file.asString()));
		
//**		System.out.println(breaker.decryptTwoKnownKeys("Hfs cpwewloj loks cd Hoto kyg Cyy.", 14, 24));
		
//**		System.out.println(breaker.decryptTwoKeys("Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!"));
	}

}
