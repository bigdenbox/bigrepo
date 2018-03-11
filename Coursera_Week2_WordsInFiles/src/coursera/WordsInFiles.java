package coursera;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import edu.duke.DirectoryResource;
import edu.duke.ImageResource;

public class WordsInFiles {
	private HashMap<String, ArrayList<String>> hashWords;

	public WordsInFiles() {
		this.hashWords = new HashMap<>();
	}

	/*
	 * Write a private void method named addWordsFromFile that has one parameter
	 * f of type File. This method should add all the words from f into the map.
	 * If a word is not in the map, then you must create a new ArrayList of type
	 * String with this word, and have the word map to this ArrayList. If a word
	 * is already in the map, then add the current filename to its ArrayList,
	 * unless the filename is already in the ArrayList. You can use the File
	 * method getName to get the filename of a file.
	 */
	public void addWordsFromFile(File f) throws FileNotFoundException {
		// int k = 0;
		Scanner scanner = new Scanner(f);
		// System.out.println("Open file = " + f.getName());
		while (scanner.hasNext()) {
			String word = scanner.next();
			// System.out.println(word);
			if (!hashWords.containsKey(word)) {
				// System.out.println("! " + k++);
				ArrayList<String> arr = new ArrayList<String>();
				arr.add(f.getName());
				hashWords.put(word, arr);
			} else {
				if (!hashWords.get(word).contains(f.getName())) {
					hashWords.get(word).add(f.getName());
					// System.out.println("Add fileName = " + f.getName()
					// + ". Becouse word = " + word + " exist");
				}
			}
		}
		scanner.close();
//		System.out.println("Close file = " + f.getName());
	}

	/*
	 * Write a void method named buildWordFileMap that has no parameters. This
	 * method first clears the map, and then uses a DirectoryResource to select
	 * a group of files. For each file, it puts all of its words into the map by
	 * calling the method addWordsFromFile. The remaining methods to write all
	 * assume that the HashMap has been built.
	 */
	public void buildWordFileMap() throws FileNotFoundException {
		hashWords.clear();
		DirectoryResource dr = new DirectoryResource();
		for (File f : dr.selectedFiles()) {
			addWordsFromFile(f);
		}
	}

	/*
	 * Write the method maxNumber that has no parameters. This method returns
	 * the maximum number of files any word appears in, considering all words
	 * from a group of files. In the example above, there are four files
	 * considered. No word appears in all four files. Two words appear in three
	 * of the files, so maxNumber on those four files would return 3. This
	 * method assumes that the HashMap has already been constructed.
	 */
	public int maxNumber() {
		int result = 0;
		for (String str : hashWords.keySet()) {
			if (result < hashWords.get(str).size()) {
				result = hashWords.get(str).size();
			}
		}
		return result;
	}

	/*
	 * Write the method wordsInNumFiles that has one integer parameter called
	 * number. This method returns an ArrayList of words that appear in exactly
	 * number files. In the example above, the call wordsInNumFiles(3) would
	 * return an ArrayList with the words “cats” and “and”, and the call
	 * wordsInNumFiles(2) would return an ArrayList with the words “love”,
	 * “are”, and “dogs”, all the words that appear in exactly two files.
	 */

	public ArrayList<String> wordsInNumFiles(int number) {
		ArrayList<String> result = new ArrayList<>();
		for (String str : hashWords.keySet()) {
			if (number == hashWords.get(str).size()) {
				result.add(str);
			}
		}
		return result;
	}

	public void printWordsInNumFiles(int number) {
		System.out.println("printWordsInNumFiles(int " + number + " )");
		for (String str : wordsInNumFiles(number)) {
			System.out.println(str);
		}
		;
	}

	/*
	 * Write the void method printFilesIn that has one String parameter named
	 * word. This method prints the names of the files this word appears in, one
	 * filename per line. For example, in the example above, the call
	 * printFilesIn(“cats”) would print the three filenames: brief1.txt,
	 * brief3.txt, and brief4.txt, each on a separate line.
	 */

	public void printFilesIn(String word) {
		System.out.println("printFilesIn(String  " + word + " )");
//		if (hashWords.containsValue(word)) {
//			System.out.println("!");
			for (String str : hashWords.get(word)) {
				System.out.println("File = " + str);
			}
//		}
	}
}
