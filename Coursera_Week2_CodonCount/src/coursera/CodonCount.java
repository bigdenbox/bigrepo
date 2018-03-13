package coursera;

import java.util.HashMap;

import javax.swing.plaf.basic.BasicScrollPaneUI.HSBChangeListener;

import edu.duke.FileResource;

public class CodonCount {
	private HashMap<String, Integer> hashDna;
	private static int DNA_STRAND_LENGTH = 3;

	public CodonCount() {
		this.hashDna = new HashMap<>();
	}

	/*
	 * Write a void method named buildCodonMap that has two parameters, an int
	 * named start and a String named dna. This method will build a new map of
	 * codons mapped to their counts from the string dna with the reading frame
	 * with the position start (a value of 0, 1, or 2). You will call this
	 * method several times, so make sure your map is empty before building it.
	 */
	public void buildCodonMap(int start, String dna) {
		hashDna.clear();
		int countForThree = ((dna.length() - 1 - start) - ((dna.length() - 1 - start) % DNA_STRAND_LENGTH))
				/ DNA_STRAND_LENGTH;
		int beginIndex = start;
		for (int k = 1; k <= countForThree; k++) {
			String abc = dna.substring(beginIndex, beginIndex
					+ DNA_STRAND_LENGTH);
			if (!hashDna.containsKey(abc)) {
				hashDna.put(abc, 1);
			} else {
				hashDna.replace(abc, hashDna.get(abc) + 1);
			}
			beginIndex = beginIndex + DNA_STRAND_LENGTH;
		}
	}

	public void printHashDna() {
		for (String str : hashDna.keySet()) {
			System.out.println(str + "\t" + hashDna.get(str));
		}
	}

	/*
	 * Write a method named getMostCommonCodon that has no parameters. This
	 * method returns a String, the codon in a reading frame that has the
	 * largest count. If there are several such codons, return any one of them.
	 * This method assumes the HashMap of codons to counts has already been
	 * built.
	 */
	public String getMostCommonCodon() {
		String result = "";
		int maxInt = 0;
		for (String str : hashDna.keySet()) {
			if (maxInt < hashDna.get(str)) {
				maxInt = hashDna.get(str);
				result = str;
			}
		}
		return result;
	}

	/*
	 * Write a void method named printCodonCounts that has two int parameters,
	 * start and end. This method prints all the codons in the HashMap along
	 * with their counts if their count is between start and end, inclusive.
	 */
	public void printCodonCounts(int start, int end) {
		System.out.println("printCodonCounts with start = " + start
				+ " to end = " + end + ":");
		for (String str : hashDna.keySet()) {
			if ((start <= end) & (start >= 0) & (start <= hashDna.get(str))
					& (end >= hashDna.get(str))) {
				System.out.println(str + "\t" + hashDna.get(str));
			}
		}
	}

	/*
	 * Write a tester method that prompts the user for a file that contains a
	 * DNA strand (could be upper or lower case letters in the file, convert
	 * them all to uppercase, since case should not matter). Then for each of
	 * the three possible reading frames, this method builds a HashMap of codons
	 * to their number of occurrences in the DNA strand, prints the total number
	 * of unique codons in the reading frame, prints the most common codon and
	 * its count, and prints the codons and their number of occurrences for
	 * those codons whose number of occurrences in this reading frame are
	 * between two numbers inclusive.
	 */
	public void tester(int start, int end) {
		FileResource file = new FileResource();
		String input = file.asString().toUpperCase().trim();
		System.out.println(input);
		for (int i = 0; i < DNA_STRAND_LENGTH; i++) {
			System.out.println("##############################");
			System.out.println("start = " + i);
			buildCodonMap(i, input);
			printHashDna();
	//		printCodonCounts(0, hashDna.get(getMostCommonCodon()));
			System.out.println("getMostCommonCodon = " + getMostCommonCodon()
					+ ". It has " + hashDna.get(getMostCommonCodon())
					+ " occurrences");
			System.out.println("Number of unique codons = " + hashDna.size());
			System.out
					.println("Prints the codons and their number of occurrences between two numbers inclusive [" + start + "; " + end + "]:");
			printCodonCounts(start, end);
		}

	}
}
