package coursera;

import edu.duke.*;

public class CaesarBreaker {

	public int[] countLettersFromFile(String fileName) {
//		System.out.println("countLetters");
		FileResource file = new FileResource(fileName);
		return countLetters(file.asString());
	}

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
//		System.out.println("maxIndex");
		int result = c[0];
		for (int i = 0; i < c.length; i++) {
			if (result < c[i]) {
				result = c[i];
			}
		}
		return result;
	}

	public String decrypt(String encrypted, int key) {
//		System.out.println("decrypt");
		CaesarCipher cc = new CaesarCipher();
		String message = cc.encrypt(encrypted, 26 - key);
		return message;
	}

	public void testDecrypt(String fileName) {
//		System.out.println("testDecrypt");
		int[] count = countLettersFromFile(fileName);
		int max = maxIndex(count);
		int maxI;
		for (maxI = 0; maxI < count.length;) {
			if (max == count[maxI]) {
//				System.out.println("i = " + maxI);
				break;
			} else {
				maxI++;
			}
		}
//		System.out.println("test Decrypt maxIndex = " + maxI);
		int key = maxI - 4;
		if (maxI < 4) {
			key = 26 - (4 - maxI);
		}

		FileResource file = new FileResource(fileName);
		String encrypted = file.asString();
		System.out
				.println("################encrypted String is:######################");
		System.out.println(decrypt(encrypted, key));
	}

	public String halfOfString(String message, int start) {
		StringBuilder sb = new StringBuilder(message);
		StringBuilder sbTemp = new StringBuilder();
//		System.out.println(sb);
		if (start <= sb.length()) {
			for (int i = start; i < sb.length();) {
				sbTemp.append(sb.charAt(i));
				i += 2;
			}
		} else {
			sb = null;
		}
		return sbTemp.toString();
	}

	public int getKey(String s) {
		int maxIndex = maxIndex(countLetters(s));

		int i;
		for (i = 0; i < countLetters(s).length;) {
			if (maxIndex == countLetters(s)[i]) {
	//			System.out.println("i = " + i);
				break;
			} else {
				i++;
			}
		}
		int key = i - 4;
		if (i < 4) {
			key = 26 - (4 - i);
		}
//		System.out.println("maxIndex = " + i);
		return key;
	}

	public String decryptTwoKeys(String encrypted) {
		String firstHalfString = halfOfString(encrypted, 0);
		String secondHalfString = halfOfString(encrypted, 1);
		int key1 = getKey(firstHalfString);
		int key2 = getKey(secondHalfString);
		System.out.println("key1= " + key1);
		System.out.println("key2= " + key2);
		StringBuilder sb1 = new StringBuilder(decrypt(firstHalfString, key1));
		StringBuilder sb2 = new StringBuilder(decrypt(secondHalfString, key2));
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < sb2.length(); i++) {
			result.append(sb1.charAt(i));
			result.append(sb2.charAt(i));
		}
		return result.toString();
	}
	
	public String decryptTwoKnownKeys (String encrypted, int key1, int key2){
		String firstHalfString = halfOfString(encrypted, 0);
		String secondHalfString = halfOfString(encrypted, 1);
//		int key1 = getKey(firstHalfString);
//		int key2 = getKey(secondHalfString);
		System.out.println("key1= " + key1);
		System.out.println("key2= " + key2);
		StringBuilder sb1 = new StringBuilder(decrypt(firstHalfString, key1));
		StringBuilder sb2 = new StringBuilder(decrypt(secondHalfString, key2));
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < sb2.length(); i++) {
			result.append(sb1.charAt(i));
			result.append(sb2.charAt(i));
		}
		return result.toString();
	}
}
