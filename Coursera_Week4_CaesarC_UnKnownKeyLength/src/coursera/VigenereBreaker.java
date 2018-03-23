package coursera;

import java.util.ArrayList;
import java.util.HashSet;

import edu.duke.FileResource;

public class VigenereBreaker {
	/*
	 * Write the public method sliceString , which has three parameters—a String
	 * message , representing the encrypted message, an integer whichSlice ,
	 * indicating the index the slice should start from, and an integer
	 * totalSlices , indicating the length of the key. This method returns a
	 * String consisting of every totalSlices th character from message ,
	 * starting at the whichSlice th character.
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
		System.out.println("-----------------------------------");
		for (int i = 0; i < klength; i++) {
			key[i] = cc.getKey(sliceString(encrypted, i, klength));
			System.out.println("key[" + i + "] = " + key[i]);
		}

		return key;
	}

	public void printArrInt(int[] arrInt) {
		System.out.print("{");
		for (int i = 0; i < arrInt.length; i++) {
			System.out.print(arrInt[i]);
			if (i < (arrInt.length - 1)) {
				System.out.print(", ");
			}
		}
		System.out.println("}");
	}

	public String breakVigenere(int klength, char mostCommon) {
		FileResource file = new FileResource();
		String encrypted = file.asString();
		int[] keyArr = tryKeyLength(encrypted, klength, mostCommon);
		VigenereCipher vc = new VigenereCipher(keyArr);
		return vc.decrypt(encrypted);
	}

	public String breakVigenere(String encrypted, int klength, char mostCommon) {
		int[] keyArr = tryKeyLength(encrypted, klength, mostCommon);
		VigenereCipher vc = new VigenereCipher(keyArr);
		return vc.decrypt(encrypted);
	}

	/*
	 * In the VigenereBreaker​class, write the public method
	 * readDictionary,​which has one parameter—a FileResource fr​. This method
	 * should first make a new HashSet of Strings, then read each line in
	 * fr​(which should contain exactly one word per line), convert that line to
	 * lowercase, and put that line into the HashSet that you created. The
	 * method should then return the HashSet representing the words in a
	 * dictionary.
	 */
	public HashSet<String> readDictionary(FileResource fr) {
		HashSet<String> dictionary = new HashSet<>();
		for (String string : fr.words()) {
			dictionary.add(string.toLowerCase());
		}
		return dictionary;
	}

	/*
	 * In the VigenereBreaker​class, write the public method countWords,​which
	 * has two parameters—a String message,​and a HashSet of Strings
	 * dictionary​. ​This method should split the message into words (use
	 * .split(“\\W”), which returns a String array), iterate over those words,
	 * and see how many of them are “real words”—that is, how many appear in the
	 * dictionary. This method should return the integer count of how many valid
	 * words it found.
	 */

	public int countWords(String message, HashSet<String> dictionary) {
		ArrayList<String> arString = new ArrayList<String>();
		int result = 0;
		for (String string : message.split("\\W")) {

			if (dictionary.contains(string.toLowerCase())) {
			//	if (!arString.contains(string)) {
					arString.add(string);
					result++;
			//	}
			}
		}
		System.out.println("arString.size() = " + arString.size());
		return result;
	}

	/*
	 * In the VigenereBreaker​class, write the public method
	 * breakForLanguage,​which has two parameters—a String encrypted,​and a
	 * HashSet of Strings dictionary​. This method should try all key lengths
	 * from 1 to 100 (use your tryKeyLength​method to try one particular key
	 * length) to obtain the best decryption for each key length in that range.
	 * For each key length, your method should decrypt the message (using
	 * VigenereCipher’​s Java Programming: Arrays, Lists, and Structured Data
	 * decrypt​method as before), and count how many of the “words” in it are
	 * real words in English, based on the dictionary​passed in (use the
	 * countWords​method you just wrote). This method should figure out which
	 * decryption gives the largest count of real words, and return that String
	 * decryption. Note that there is nothing special about 100; we will just
	 * give you messages with key lengths in the range 1–100. If you did not
	 * have this information, you could iterate all the way to
	 * encrypted.length().​Your program would just take a bit longer to run.
	 */

	public String breakForLanguage(String encrypted,
			HashSet<String> dictionary, int largestKeyLength, char mostCommon) {
		mostCommon = 'e';
		ArrayList<String> decryptedArr = new ArrayList<String>();
		int[] overlap = new int[largestKeyLength];
		int key;
		for (int klength = 1; klength <= largestKeyLength; klength++) {
			decryptedArr.add(breakVigenere(encrypted, klength, mostCommon));
		}
		for (int i = 0; i < overlap.length; i++) {
			overlap[i] = countWords(decryptedArr.get(i), dictionary);
		}
		System.out.println("##############################");
		key = maxInt(overlap) + 1;
		System.out.println("klength = " + key);
		printArrInt(tryKeyLength(encrypted, key, mostCommon));
		return breakVigenere(encrypted, maxInt(overlap) + 1, mostCommon);
	}

	public int maxInt(int[] arr) {
		int maxInt = 0;
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			if (maxInt < arr[i]) {
				maxInt = arr[i];
				index = i;
			}
		}
		System.out.println("valid words = " + arr[index]);
		return index;
	}
}
