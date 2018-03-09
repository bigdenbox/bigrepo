package coursera;


public class CaesarCipherTwo {
	
	private String alphabet;
	private String shiftedAlphabet1;
	private String shiftedAlphabet2;
	private int mainKey1;
	private int mainKey2;
	
	public CaesarCipherTwo(int key1, int key2){
		alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		shiftedAlphabet1 = alphabet.substring(key1)
				+ alphabet.substring(0, key1);
		shiftedAlphabet2 = alphabet.substring(key2)
				+ alphabet.substring(0, key2);
		mainKey1 = key1;
		mainKey2 = key2;
	}
	
	public String encrypt(String input){
		StringBuilder sb = new StringBuilder(input);
		int index = 0;
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if (Character.isUpperCase(ch)) {
				index = alphabet.indexOf(ch);
				if (index != -1) {
					if (!isOdd(i)) {
						sb.setCharAt(i,
								shiftedAlphabet1.charAt(index));
					} else {
						sb.setCharAt(i,
								shiftedAlphabet2.charAt(index));
					}
				}
			} else {
				ch = Character.toUpperCase(ch);
				index = alphabet.indexOf(ch);
				if (index != -1) {
					if (!isOdd(i)) {
						sb.setCharAt(i,
								shiftedAlphabet1.toLowerCase().charAt(index));
					} else {
						sb.setCharAt(i,
								shiftedAlphabet2.toLowerCase().charAt(index));
					}
				}
			}
		}
		return sb.toString();
	}
	
	public String decrypt(String input){
		CaesarCipherTwo cctwo = new CaesarCipherTwo(26 - mainKey1, 26 - mainKey2);
		return cctwo.encrypt(input);
	}
	
	public boolean isOdd(int in) {
		if (in % 2 > 0) {
			return true;
		}
		return false;
	}
}
