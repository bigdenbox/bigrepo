package coursera;

import edu.duke.*;

import java.util.*;

public class GladLib {

	private HashMap<String, ArrayList<String>> myMap;
	private ArrayList<String> arrNamesOfFiles;
	private ArrayList<String> seenWordsList;
	private Random myRandom;
	private ArrayList<String> totalWordsCount;

	@SuppressWarnings("unused")
	private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
	private static String dataSourceDirectory = "data";

	public GladLib() {
		initializeFromSource(dataSourceDirectory);
		myRandom = new Random();
	}

	public GladLib(String source) {
		initializeFromSource(dataSourceURL);
		myRandom = new Random();
	}

	private void initializeFromSource(String source) {
		arrNamesOfFiles = readIt(source + "/namesOfFiles.txt");
		seenWordsList = new ArrayList<String>();
		totalWordsCount = new ArrayList<String>();
		myMap = new HashMap<>();
		myMap.clear();
		ArrayList<String> tempArr = new ArrayList<>();
		for (String string : arrNamesOfFiles) {
			tempArr = readIt(source + "/" + string + ".txt");
			myMap.put(string, tempArr);
		}
	}

	private String randomFrom(ArrayList<String> source) {
		int index = myRandom.nextInt(source.size());
		index = myRandom.nextInt(source.size());
		return source.get(index);
	}

	private String getSubstitute(String label) {
		if (myMap.containsKey(label)) {
			if (!totalWordsCount.contains(label)) {
				totalWordsCount.add(label);
			}
			return randomFrom(myMap.get(label));
		}
		if (label.equals("number")) {
			return "" + myRandom.nextInt(50) + 5;
		}
		return "**UNKNOWN**";
	}

	public ArrayList<String> getTotalWordsCount() {
		return totalWordsCount;
	}

	private String processWord(String w) {
		int first = w.indexOf("<");
		int last = w.indexOf(">", first);
		if (first == -1 || last == -1) {
			return w;
		}
		String prefix = w.substring(0, first);
		String suffix = w.substring(last + 1);
		String sub = getSubstitute(w.substring(first + 1, last));
		while (seenWordsList.contains(sub)) {
			sub = getSubstitute(w.substring(first + 1, last));
		}
		seenWordsList.add(sub);
		return prefix + sub + suffix;
	}

	private void printOut(String s, int lineWidth) {
		int charsWritten = 0;
		for (String w : s.split("\\s+")) {
			if (charsWritten + w.length() > lineWidth) {
				System.out.println();
				charsWritten = 0;
			}
			System.out.print(w + " ");
			charsWritten += w.length() + 1;
		}
	}

	private String fromTemplate(String source) {
		String story = "";
		if (source.startsWith("http")) {
			URLResource resource = new URLResource(source);
			for (String word : resource.words()) {
				story = story + processWord(word) + " ";
			}
		} else {
			FileResource resource = new FileResource(source);
			for (String word : resource.words()) {
				story = story + processWord(word) + " ";
			}
		}
		return story;
	}

	private ArrayList<String> readIt(String source) {
		ArrayList<String> list = new ArrayList<String>();
		if (source.startsWith("http")) {
			URLResource resource = new URLResource(source);
			for (String line : resource.lines()) {
				list.add(line);
			}
		} else {
			FileResource resource = new FileResource(source);
			for (String line : resource.lines()) {
				list.add(line);
			}
		}
		return list;
	}

	public void makeStory() {
		System.out.println("\n");
		String story = fromTemplate("data/madtemplate3.txt");
		printOut(story, 100);
		printTotalNumberOfWords();
	}

	public void printSeenWordsList() {
		for (String str : seenWordsList) {
			System.out.println(str);
		}

	}

	/*
	 * Modify your program to print out the total number of words that were replaced
	 * right after the story is printed.
	 */
	public void printTotalNumberOfWords() {
		System.out.println("\nThe total number of words that were replaced = " + seenWordsList.size());
	}

	public int totalWordsInMap() {
		int result = 0;
		for (String string : myMap.keySet()) {
			for (String str : myMap.get(string)) {
				result++;
//				System.out.println(str + " " + result);
			}
		}
		return result;
	}

	public int totalWordsConsidered() {
		int result = 0;
		for (String string : myMap.keySet()) {
			if (totalWordsCount.contains(string)) {
				for (String str : myMap.get(string)) {
					result++;
					// System.out.println(str + " " + result);
				}
			}
		}
		return result;
	}

}
