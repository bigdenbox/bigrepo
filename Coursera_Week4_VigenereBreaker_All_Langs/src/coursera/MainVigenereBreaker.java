package coursera;

import java.io.FileNotFoundException;

public class MainVigenereBreaker {

	public static void main(String[] args) throws FileNotFoundException {

		TesterVigenereBreaker test = new TesterVigenereBreaker();
	//	test.testencrypt(5);
	//	test.testdecryptKnowKey(17);
	//	test.testdecryptDontKnowKey();
	//	test.testdecryptDontKnowKeyNotEnglish('a');
	//	int[] arr = {17, 14, 12, 4};
	//	test.testdecryptVigenereCipherEncrypt(arr);
	//	test.testencryptVigenereCipherEncrypt(arr);
	//	test.testVigenereBreakerSliceString("abcdefghijklm", 0, 3);
	//	test.testVigenereBreakertryKeyLength(4, 'e');
	//	test.testbreakVigenere(5, 'e');
	//	test.testbreakForLanguage(100, 'e');
	//	test.testkey();
		
		test.testAllLang();
	}

}
