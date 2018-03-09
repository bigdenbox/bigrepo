package coursera;

import edu.duke.FileResource;

public class TestCaesarCipher {
	private static int KEY = 18;

	public int[] countLetters(String s) {
		int[] result = new int[26];
		String letters = "abcdefghijklmnopqrstuvwxyz";
		for (int i = 0; i < s.length(); i++) {
			int index = letters.indexOf(Character.toLowerCase(s.charAt(i)));
			if (index != -1) {
				result[index]++;
			}
		}
		for (int i = 0; i < result.length; i++) {
		}
		return result;
	}

	public int maxIndex(int[] c) {
		// System.out.println("maxIndex");
		int result = c[0];
		for (int i = 0; i < c.length; i++) {
			if (result < c[i]) {
				result = c[i];
			}
		}
		return result;
	}
	
	public void simpleTests (){
		FileResource file = new FileResource("src\\romeo.txt");
		CaesarCipher cc = new CaesarCipher(KEY);
		String encryptedText = cc.encrypt(file.asString());
	//**	System.out.println(encryptedText);
	//**	String decryptedText = cc.decrypt(encryptedText);
	//**	System.out.println(decryptedText);
		
		breakCaesarCipher(encryptedText);
	}
	
	public void breakCaesarCipher(String input){
		
		int[] count = countLetters(input);
		int max = maxIndex(count);
		int maxI;
		for (maxI = 0; maxI < count.length;) {
			if (max == count[maxI]) {
				break;
			} else {
				maxI++;
			}
		}
		int key = maxI - 4;
		if (maxI < 4) {
			key = 26 - (4 - maxI);
		}
		CaesarCipher cc = new CaesarCipher(key);
		System.out.println(cc.decrypt(input));
	}

}
