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
		
		FileResource file =new FileResource ("src\\coursera\\mysteryTwoKeysPractice.txt");
//		System.out.println(breaker.decryptTwoKeys(file.asString()));

		
//**    System.out.println(breaker.decryptTwoKeys(file.asString()));
		
//**    System.out.println(breaker.decryptTwoKnownKeys("Top ncmy qkff vi vguv vbg ycpx", 2, 20));
		
        System.out.println(breaker.decryptTwoKeys("Akag tjw Xibhr awoa aoee xakex znxag xwko"));
	}

}
