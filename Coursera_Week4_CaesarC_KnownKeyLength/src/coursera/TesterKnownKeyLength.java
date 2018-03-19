package coursera;

import edu.duke.*;

public class TesterKnownKeyLength {
	
	private FileResource file = new FileResource();
	private String message = file.asString();
	private String encryptedMessage = null;
	
    CaesarCipher cc = new CaesarCipher(4);
    
    public void testencrypt(){
    	System.out.println("ORIGINAL MESSAGE:");
    	System.out.println(message);
    	System.out.println("\nENCRYPTED MESSAGE:");
    	System.out.println(encryptedMessage = cc.encrypt(message));
    }
    
    public void testdecrypt(){
    	System.out.println("ORIGINAL MESSAGE:");
    	System.out.println(encryptedMessage);
    	System.out.println("\nDECRYPTED MESSAGE:");
    	System.out.println(cc.decrypt(encryptedMessage));
    }

	

}
