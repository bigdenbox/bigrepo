package coursera;

public class CaesarCipher {
	private String alphabet;
	private String shiftedAlphabet;
	private int mainKey;
	
	public CaesarCipher(int key){
		alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		shiftedAlphabet = alphabet.substring(key)
				+ alphabet.substring(0, key);
		mainKey = key;
	}
	public String encrypt(String input){
		StringBuilder sb = new StringBuilder(input);
		int index = 0;
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if (Character.isUpperCase(ch)) {
				index = alphabet.indexOf(ch);
				if (index != -1) {
					sb.setCharAt(i, shiftedAlphabet.charAt(index));
				}
			} else {
				index = alphabet.indexOf(Character.toUpperCase(ch));
				if (index != -1) {
					sb.setCharAt(i, Character.toLowerCase(shiftedAlphabet.charAt(index)));
				}
			}
		}
//		System.out.println(sb.toString());
		return sb.toString();
	}
	
	public String decrypt(String input){
		CaesarCipher cc = new CaesarCipher(26 - mainKey); 
		return cc.encrypt(input);
	}

}
