package coursera;

import javax.swing.SingleSelectionModel;

import edu.duke.*;

public class TesterKnownKeyLength {
	
	public String initFile() {
	FileResource file = new FileResource();
	String message = file.asString();
	return message;
	}
//	private String encryptedMessage = null;
	
    
    public void testencrypt(int key){
    	CaesarCipher cc = new CaesarCipher(key);
    	String message = initFile();
    	System.out.println("ORIGINAL MESSAGE:");
    	System.out.println(message);
    	System.out.println("\nENCRYPTED MESSAGE:");
    	System.out.println(cc.encrypt(message));
    }
    
    public void testdecryptKnowKey(int key){
    	CaesarCipher cc = new CaesarCipher(key);
    	String message = initFile();
    	System.out.println("testdecryptKnowKey() started  with known key = " + key);
    	System.out.println("ORIGINAL MESSAGE:");
    	System.out.println(message);
    	System.out.println("\nDECRYPTED MESSAGE:");
    	System.out.println(cc.decrypt(message));
    }

    public void testdecryptDontKnowKey(){
    	CaesarCracker cracker = new CaesarCracker();
    	String message = initFile();
    	System.out.println("testdecryptDontKnowKey() started");
    	System.out.println("ORIGINAL MESSAGE:");
    	System.out.println(message);
    	System.out.println("The key was count = " + cracker.getKey(message));
    	System.out.println("\nDECRYPTED MESSAGE:");
    	System.out.println(cracker.decrypt(message));
    }
    
    public void testdecryptDontKnowKeyNotEnglish(char ch){
    	CaesarCracker cracker = new CaesarCracker(ch);
    	String message = initFile();
    	System.out.println("testdecryptDontKnowKeyNotEnglish started with char = " + ch);
    	System.out.println("ORIGINAL MESSAGE:");
    	System.out.println(message);
    	System.out.println("The key was count = " + cracker.getKey(message));
    	System.out.println("\nDECRYPTED MESSAGE:");
    	System.out.println(cracker.decrypt(message));
    }
    public void testdecryptVigenereCipherEncrypt(int [] arrInt){
    	VigenereCipher vc = new VigenereCipher(arrInt);
    	String message = initFile();
    	System.out.print("testdecryptVigenereCipherEncrypt(int [] arrInt) started with arrInt = ");
    	printArrInt(arrInt);
    	System.out.println("ORIGINAL MESSAGE:");
    	System.out.println(message);
    	System.out.println("\nDECRYPTED MESSAGE:");
    	System.out.println(vc.decrypt(message));
    }
    
    public void testencryptVigenereCipherEncrypt(int [] arrInt){
    	VigenereCipher vc = new VigenereCipher(arrInt);
    	String message = initFile();
    	System.out.print("testencryptVigenereCipherEncrypt(int [] arrInt) started with arrInt = ");
    	printArrInt(arrInt);
    	System.out.println("ORIGINAL MESSAGE:");
    	System.out.println(message);
    	System.out.println("\nENCRYPTED MESSAGE:");
    	System.out.println(vc.encrypt(message));
    }
    
    public void printArrInt(int[] arrInt) {
    	System.out.print("{");
    	for (int i = 0; i < arrInt.length; i++) {
			System.out.print(arrInt[i]);
			if(i < (arrInt.length - 1)) {
				System.out.print(", ");
			}
		}
    	System.out.println("}");
    }
    
    public void testVigenereBreakerSliceString(String message, int whichSlice, int totalSlices) {
    	System.out.println("testVigenereBreakerSliceString started");
    	VigenereBreaker vb = new VigenereBreaker();
    	System.out.println(vb.sliceString(message, whichSlice, totalSlices));
    }
    
    public void testVigenereBreakertryKeyLength(int klength, char mostCommon) {
    	VigenereBreaker vb = new VigenereBreaker();
    	String encrypted = initFile();
    	System.out.println("ORIGINAL MESSAGE:");
    	System.out.println(encrypted);
    	System.out.println("Key length = " + klength);
    	System.out.println("mostCommon char = " + mostCommon);
    	System.out.print("key[] = ");
    	printArrInt(vb.tryKeyLength(encrypted, klength, mostCommon));
    }
    public void testbreakVigenere(int klength, char mostCommon){
    	System.out.println("testbreakVigenere()");
    	VigenereBreaker vb = new VigenereBreaker();
    	vb.breakVigenere(klength, mostCommon);
    	
    }


}
