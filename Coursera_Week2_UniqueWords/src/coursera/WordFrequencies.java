package coursera;

import java.util.ArrayList;

import edu.duke.FileResource;

public class WordFrequencies {
	ArrayList<String> myWords;
	ArrayList<Integer> myFreqs;

	public WordFrequencies() {
		myWords = new ArrayList<>();
		myFreqs = new ArrayList<>();
	}

	/*
	 * Write a void method findUnique that has no parameters. This method should
	 * first clear both myWords and myFreqs, using the .clear() method. Then it
	 * selects a file and then iterates over every word in the file, putting the
	 * unique words found into myWords. For each word in the kth position of
	 * myWords, it puts the count of how many times that word occurs from the
	 * selected file into the kth position of myFreqs, as was demonstrated in
	 * the lesson.
	 */

	public void findUnique() {
		myFreqs.clear();
		myFreqs.clear();
		FileResource file = new FileResource();
		for (String s : file.words()) {
			s = s.toLowerCase();
			int index = myWords.indexOf(s);
			if (index == -1) {
				myWords.add(s);
				myFreqs.add(1);
			} else {
				int value = myFreqs.get(index);
				myFreqs.set(index, value + 1);
			}
		}

	}

	/*
	 * Write a void tester method that has no parameters. This method should
	 * call findUnique. Then print out the number of unique words, and for each
	 * unique word, print the frequency of each word and the word, as was
	 * demonstrated in the lesson.
	 * 
	 * Add code to the tester method to determine and print the word that occurs
	 * the most often in a selected file and how many times it occurs. You
	 * should find it helpful to call findIndexOfMax.
	 */
	public void tester() {
		findUnique();
		System.out.println("Number of unique words: " + myFreqs.size());
		int k = 0;
		for (int i : myFreqs) {
			System.out.println(i + "\t" + myWords.get(k++));
		}
		System.out.print("The word that occurs most often and its count are: ");
		System.out.println(myFreqs.get(findIndexOfMax()) + "\t" + myWords.get(findIndexOfMax()));
	}

	/*
	 * Write the method findIndexOfMax that has no parameters. This method
	 * returns an int that is the index location of the largest value in
	 * myFreqs. If there is a tie, then return the first such value.
	 */

	public int findIndexOfMax() {
		int maxInt = myFreqs.get(0);
		for (int i : myFreqs) {
			if (maxInt < i) {
				maxInt = i;
			}
		}
		return myFreqs.indexOf(maxInt);
	}

}
