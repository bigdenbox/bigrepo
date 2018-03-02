package BlueJ;

public class CaesarCipher {
	public String encrypt(String inString, int key) {
		System.out.println("Key = " + key);
		System.out.println("inString = " + inString);
		String alphabetUpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String alphabetLowCase = "abcdefghijklmnopqrstuvwxyz";
		String shiftedAlphabetUpperCase = alphabetUpperCase.substring(key)
				+ alphabetUpperCase.substring(0, key);
		String shiftedAlphabetLowCase = alphabetLowCase.substring(key)
				+ alphabetLowCase.substring(0, key);
		StringBuilder sb = new StringBuilder(inString);
		int index = 0;
		for (int i = 0; i < inString.length(); i++) {
			char ch = inString.charAt(i);
			if (Character.isUpperCase(ch)) {
				index = alphabetUpperCase.indexOf(ch);
				if (index != -1) {
					sb.setCharAt(i, shiftedAlphabetUpperCase.charAt(index));
				}
			} else {
				index = alphabetLowCase.indexOf(ch);
				if (index != -1) {
					sb.setCharAt(i, shiftedAlphabetLowCase.charAt(index));
				}
			}
		}
		return sb.toString();
	}

	public String encryptTwoKeys(String inString, int key1, int key2) {
		System.out.println("Key = " + key1);
		System.out.println("Key = " + key1);
		System.out.println("inString = " + inString);
		String alphabetUpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String alphabetLowCase = "abcdefghijklmnopqrstuvwxyz";

		String shiftedAlphabetUpperCaseKey1 = alphabetUpperCase.substring(key1)
				+ alphabetUpperCase.substring(0, key1);
		String shiftedAlphabetLowCaseKey1 = alphabetLowCase.substring(key1)
				+ alphabetLowCase.substring(0, key1);

		String shiftedAlphabetUpperCaseKey2 = alphabetUpperCase.substring(key2)
				+ alphabetUpperCase.substring(0, key2);
		String shiftedAlphabetLowCaseKey2 = alphabetLowCase.substring(key2)
				+ alphabetLowCase.substring(0, key2);

		StringBuilder sb = new StringBuilder(inString);
		int index = 0;
		for (int i = 0; i < inString.length(); i++) {
			char ch = inString.charAt(i);
			if (Character.isUpperCase(ch)) {
				index = alphabetUpperCase.indexOf(ch);
				if (index != -1) {
					if (!isOdd(i)) {
						sb.setCharAt(i,
								shiftedAlphabetUpperCaseKey1.charAt(index));
					} else {
						sb.setCharAt(i,
								shiftedAlphabetUpperCaseKey2.charAt(index));
					}
				}
			} else {
				index = alphabetLowCase.indexOf(ch);
				if (index != -1) {
					if (!isOdd(i)) {
						sb.setCharAt(i,
								shiftedAlphabetLowCaseKey1.charAt(index));
					} else {
						sb.setCharAt(i,
								shiftedAlphabetLowCaseKey2.charAt(index));
					}
				}
			}
		}
		return sb.toString();
	}

	public boolean isOdd(int in) {
		if (in % 2 > 0) {
			return true;
		}
		return false;

	}
}
