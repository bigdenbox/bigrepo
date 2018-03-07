import edu.duke.FileResource;

public class TestCaesarCipherTwo {

	public String halfOfString(String message, int start) {
		StringBuilder sb = new StringBuilder(message);
		StringBuilder sbTemp = new StringBuilder();
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

	public int[] countLetters(String s) {
		int[] result = new int[26];
		String letters = "abcdefghijklmnopqrstuvwxyz";
		for (int i = 0; i < s.length(); i++) {
			int index = letters.indexOf(Character.toLowerCase(s.charAt(i)));
			if (index != -1) {
				result[index]++;
			}
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

	public void simpleTests() {
		FileResource file = new FileResource("src\\romeoSmall.txt");
		CaesarCipherTwo cctwo = new CaesarCipherTwo(17, 3);
		String encryptedMessage = cctwo.encrypt(file.asString());
		System.out.println(encryptedMessage);
		System.out
				.println("########################################################################################");
		System.out.println(cctwo.decrypt(encryptedMessage));
		System.out
		.println("########################################################################################");
		System.out.println(breakCaesarCipher(encryptedMessage));
		
	}

	public int getKey(String s) {
		int maxIndex = maxIndex(countLetters(s));

		int i;
		for (i = 0; i < countLetters(s).length;) {
			if (maxIndex == countLetters(s)[i]) {
				// System.out.println("i = " + i);
				break;
			} else {
				i++;
			}
		}
		int key = i - 4;
		if (i < 4) {
			key = 26 - (4 - i);
		}
		return key;
	}

	public String breakCaesarCipher(String input) {
		String firstHalfString = halfOfString(input, 0);
		String secondHalfString = halfOfString(input, 1);
		int key1 = getKey(firstHalfString);
		int key2 = getKey(secondHalfString);
		System.out.println("key1= " + key1);
		System.out.println("key2= " + key2);
		CaesarCipherTwo cctwo = new CaesarCipherTwo(key1, key2);
		return cctwo.decrypt(input);
	}
	
	

}
