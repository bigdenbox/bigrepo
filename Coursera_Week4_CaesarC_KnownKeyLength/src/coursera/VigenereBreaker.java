package coursera;

public class VigenereBreaker {
	/*
	 * Write the public method sliceString , which has three parameters—a String
	 * message , representing the encrypted message, an integer whichSlice ,
	 * indicating the index the slice should start from, and an integer totalSlices
	 * , indicating the length of the key. This method returns a String consisting
	 * of every totalSlices th character from message , starting at the whichSlice
	 * th character.
	 */
	public String sliceString(String message, int whichSlice, int totalSlices) {
		StringBuilder sb = new StringBuilder();
		for (int i = whichSlice; i < message.length(); i += totalSlices) {
			sb = sb.append(message.charAt(i));
		}
		return sb.toString();
	}

	public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
		int[] key = new int[klength];
		CaesarCracker cc = new CaesarCracker(mostCommon);
		for (int i = 0; i < klength; i++) {
			key[i] = cc.getKey(sliceString(encrypted, i, klength));
		}
		return key;
	}

	public void breakVigenere() {
		System.out.println("Test");
		
	}

}
