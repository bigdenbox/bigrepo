package coursera;

public class MainCaesarKnownKeyLength {

	public static void main(String[] args) {

		TesterKnownKeyLength test = new TesterKnownKeyLength();
	//	test.testencrypt(5);
	//	test.testdecryptKnowKey(17);
	//	test.testdecryptDontKnowKey();
	//	test.testdecryptDontKnowKeyNotEnglish('a');
	//	int[] arr = {17, 14, 12, 4};
	//	test.testdecryptVigenereCipherEncrypt(arr);
	//	test.testencryptVigenereCipherEncrypt(arr);
	//	test.testVigenereBreakerSliceString("abcdefghijklm", 0, 3);
	//	test.testVigenereBreakertryKeyLength(4, 'e');
		test.testbreakVigenere(4, 'e');
	}

}
