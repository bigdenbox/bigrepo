package coursera;

import edu.duke.*;

public class CaesarBreaker {

	public int[] countLetters(String fileName) {
		System.out.println("countLetters");
		FileResource file = new FileResource(fileName);
		int[] result = new int[26];
		String letters = "abcdefghijklmnopqrstuvwxyz";
		String fileToString = file.asString();
		for (int i = 0; i < fileToString.length(); i++) {
			int index = letters.indexOf(Character.toLowerCase(fileToString
					.charAt(i)));
			if (index != -1) {
				result[index]++;
			}
		}
		for (int i = 0; i < result.length; i++) {
			System.out
					.println("Letter: " + letters.charAt(i) + " " + result[i]);
		}
		return result;
	}

	public int maxIndex(int[] c) {
		System.out.println("maxIndex");
		int result = c[0];
		for (int i = 0; i < c.length; i++) {
			if (result < c[i]) {
				result = c[i];
			}
		}
		// System.out.println(result);
		return result;
	}

	public String decrypt(String encrypted, int key) {
		System.out.println("decrypt");
		CaesarCipher cc = new CaesarCipher();
		String message = cc.encrypt(encrypted, 26 - key);
		return message;
	}

	public void testDecrypt(String fileName) {
		System.out.println("testDecrypt");
		// String letters = "abcdefghijklmnopqrstuvwxyz";
		// int key = countLetters(fileName).(maxIndex(countLetters(fileName)));

		int[] count = countLetters(fileName);
		int max = maxIndex(count);
		int maxIndex;
		for (maxIndex = 0; maxIndex < count.length;) {
			if (max == count[maxIndex]) {
				System.out.println("i = " + maxIndex);
				break;
			} else {
				maxIndex++;
			}
		}
		int key = maxIndex - 4;
		if (maxIndex < 4) {
			key = 26 - (4 - maxIndex);
		}

		FileResource file = new FileResource(fileName);
		String encrypted = file.asString();
		System.out
				.println("################encrypted String is:######################");
		// System.out.println(encrypted);
		System.out.println(decrypt(encrypted, key));
	}

}
