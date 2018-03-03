package coursera;

public class MainBreaker {

	public static void main(String[] args) {
		CaesarBreaker breaker = new CaesarBreaker();
/*		int [] countLetters = breaker.countLetters("src\\coursera\\wordsLotsOfEs.txt");
		
		System.out.println(breaker.maxIndex(countLetters));*/
		
		breaker.testDecrypt("src\\coursera\\encrypted.txt");
	//	breaker.testDecrypt("src\\coursera\\romeo.txt");

		

	}

}
