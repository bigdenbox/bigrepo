package coursera;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;

public class VigenereBreaker { 
/*	private String encryptedLanguage;
	private int encryptedKlength;
	private int[] encryptedKeys;
*/	/*
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
//		System.out.println("-----------------------------------");
		for (int i = 0; i < klength; i++) {
			key[i] = cc.getKey(sliceString(encrypted, i, klength));
//			System.out.println("key[" + i + "] = " + key[i]);
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
	 * Modify your breakVigenere​method to read many dictionaries instead of just
	 * one. ○ In particular, you should make a HashMap mapping Strings to a HashSet
	 * of Strings that will map each language name to the set of words in its
	 * dictionary. Then, you will want to read (using your readDictionary​method)
	 * each of the dictionaries that we have provided (Danish, Dutch, English,
	 * French, German, Italian, Portuguese, and Spanish) and store the words in the
	 * HashMap you made. Reading all the dictionaries may take a little while, so
	 * you might add some print statements to reassure you that your program is
	 * making progress. ○ Once you have made that change, you will want to call
	 * breakForAllLangs,​ passing in the message (the code to read in the message is
	 * unchanged from before), and the HashMap you just created.
	 */

	public String breakVigenere() throws FileNotFoundException {
		HashMap<String, HashSet<String>> dictionaries = buildDictionariesFileMap();
		System.out.println("Please open encrypted file:");
		FileResource fr = new FileResource();
		String encrypted = fr.asString();
		String decrypted = breakForAllLanguages(encrypted, dictionaries);
		System.out.println("\nDECRYPTED TEXT:");
		if(decrypted.length() > 1000) {
		System.out.println(decrypted.substring(0, 1000));
		}else 
			System.out.println(decrypted);
		return decrypted; 
	}

	public HashMap<String, HashSet<String>> buildDictionariesFileMap() throws FileNotFoundException {
		HashMap<String, HashSet<String>> dictionaries = new HashMap<>();
		dictionaries.clear();
		System.out.println("Please open files with dictionaries:");
		DirectoryResource dr = new DirectoryResource();
		for (File file : dr.selectedFiles()) {
			String fileName = file.getName();
			FileResource fr = new FileResource("src/dictionaries/" + fileName);
			System.out.println("Dictionary " + fileName + " is reading....");
			dictionaries.put(fileName, readDictionary(fr));
		}
		return dictionaries;
	}

	/*
	 * In the VigenereBreaker​class, write the public method readDictionary,​which
	 * has one parameter—a FileResource fr​. This method should first make a new
	 * HashSet of Strings, then read each line in fr​(which should contain exactly
	 * one word per line), convert that line to lowercase, and put that line into
	 * the HashSet that you created. The method should then return the HashSet
	 * representing the words in a dictionary.
	 */
	public HashSet<String> readDictionary(FileResource fr) {
		HashSet<String> dictionary = new HashSet<>();
		for (String string : fr.words()) {
			dictionary.add(string.toLowerCase());
		}
		return dictionary;
	}

	/*
	 * In the VigenereBreaker​class, write the public method countWords,​which has
	 * two parameters—a String message,​and a HashSet of Strings dictionary​. ​This
	 * method should split the message into words (use .split(“\\W”), which returns
	 * a String array), iterate over those words, and see how many of them are “real
	 * words”—that is, how many appear in the dictionary. This method should return
	 * the integer count of how many valid words it found.
	 */

	public int countWords(String message, HashSet<String> dictionary) {
		ArrayList<String> arString = new ArrayList<String>();
		int result = 0;
		for (String string : message.split("\\W")) {
			if (dictionary.contains(string.toLowerCase())) {
				arString.add(string);
				result++;
			}
		}
		return result;
	}

	/*
	 * In the VigenereBreaker​class, write the public method breakForLanguage,​which
	 * has two parameters—a String encrypted,​and a HashSet of Strings dictionary​.
	 * This method should try all key lengths from 1 to 100 (use your
	 * tryKeyLength​method to try one particular key length) to obtain the best
	 * decryption for each key length in that range. For each key length, your
	 * method should decrypt the message (using VigenereCipher’​s Java Programming:
	 * Arrays, Lists, and Structured Data decrypt​method as before), and count how
	 * many of the “words” in it are real words in English, based on the
	 * dictionary​passed in (use the countWords​method you just wrote). This method
	 * should figure out which decryption gives the largest count of real words, and
	 * return that String decryption. Note that there is nothing special about 100;
	 * we will just give you messages with key lengths in the range 1–100. If you
	 * did not have this information, you could iterate all the way to
	 * encrypted.length().​Your program would just take a bit longer to run.
	 */

	public String breakForLanguage(String encrypted, HashSet<String> dictionary, int largestKeyLength,
			char mostCommon) {
//		mostCommon = 'e';
		ArrayList<String> decryptedArr = new ArrayList<String>();
		int[] overlap = new int[largestKeyLength];
		int key;
		for (int klength = 1; klength <= largestKeyLength; klength++) {
			decryptedArr.add(breakVigenere(encrypted, klength, mostCommon));
		}
		for (int i = 0; i < overlap.length; i++) {
			overlap[i] = countWords(decryptedArr.get(i), dictionary);
		}
		System.out.println("---------------------------------");
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

	/*
	 * In the VigenereBreaker​class, write the public method mostCommonCharIn,​which
	 * has one parameter—a HashSet of Strings dictionary​. This method should find
	 * out which character, of the letters in the English alphabet, appears most
	 * often in the words in dictionary. It should return this most commonly
	 * occurring character. Remember that you can iterate over a HashSet<String>
	 * with a for­each style for loop.
	 */

	public char mostCommonCharIn(HashSet<String> dictionary) {
		HashMap<Character, Integer> countChars = new HashMap<>();
		for (String string : dictionary) {
			for (char ch : string.toCharArray()) {
				if (!countChars.containsKey(ch)) {
					countChars.put(ch, 1);
				} else {
					countChars.put(ch, (countChars.get(ch) + 1));
				}
			}
		}
		Character mostCommonChar = null;
		int maxCount = 0;
		for (Character ch : countChars.keySet()) {
			if (maxCount < countChars.get(ch)) {
				mostCommonChar = ch;
				maxCount = countChars.get(ch);
			}
		}
		return mostCommonChar;
	}

	/*
	 * In the VigenereBreaker​class, write the public method
	 * breakForAllLanguages,​which has two parameters—a String encrypted,​and a
	 * HashMap, called languages,​mapping a String representing the name of a
	 * language to a HashSet of Strings containing the words in that language. Try
	 * breaking the encryption for each language, and see which gives the best
	 * results! Remember that you can iterate over the language.keySet() to get the
	 * name of each language, and then you can use .get()to look up the
	 * corresponding dictionary for that language. You will want to use the
	 * breakForLanguage and countWords​methods that you already wrote to do most of
	 * the work (it is slightly inefficient to re­count the words here, but it is
	 * simpler, and the inefficiency is not significant). You will want to print out
	 * the decrypted message as well as the language that you identified for the
	 * message.
	 */

	public String breakForAllLanguages(String encrypted, HashMap<String, HashSet<String>> languages) {
		int largestKeyLength = 100;
		HashMap<String, Integer> wordsValueInLanguages = new HashMap<>();
		// int[] wordsValue = new int[languages.size()];
		int i = 0;
		for (String language : languages.keySet()) {
			HashSet<String> dictionary = languages.get(language);
			char mostCommonCharInThisLanguage = mostCommonCharIn(dictionary);
			System.out.println("####################### \nlanguage = " + language);
			System.out.println("mostCommonCharInThisLanguage = " + mostCommonCharInThisLanguage);
			String decrypted = breakForLanguage(encrypted, dictionary, largestKeyLength, mostCommonCharInThisLanguage);
			wordsValueInLanguages.put(language, countWords(decrypted, dictionary));
			i++;
		}
		String myLanguage = chooseLangFromHashMap(wordsValueInLanguages);
		HashSet<String> myDictionary = languages.get(myLanguage);
		return breakForLanguage(encrypted, myDictionary, largestKeyLength, mostCommonCharIn(myDictionary));
	}

	public String chooseLangFromHashMap(HashMap<String, Integer> wordsValueInLanguages) {
		String language = null;
		int maxValue = 0;
		for (String lang : wordsValueInLanguages.keySet()) {
			if (maxValue < wordsValueInLanguages.get(lang)) {
				language = lang;
				maxValue = wordsValueInLanguages.get(lang);
			}
		}
		return language;
	}
}
