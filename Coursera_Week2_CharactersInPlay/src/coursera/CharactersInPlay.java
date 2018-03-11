package coursera;

import java.util.ArrayList;

import edu.duke.FileResource;

public class CharactersInPlay {
	private ArrayList<String> charactersWords;
	private ArrayList<Integer> charactersFreqs;

	public CharactersInPlay() {
		charactersFreqs = new ArrayList<Integer>();
		charactersWords = new ArrayList<String>();
	}

	/*
	 * Write a void method named update that has one String parameter named
	 * person. This method should update the two ArrayLists, adding the
	 * character’s name if it is not already there, and counting this line as
	 * one speaking part for this person.
	 */
	public void update(String person) {
		int index = charactersWords.indexOf(person);
		if (index == -1) {
			charactersWords.add(person);
			charactersFreqs.add(1);
		} else {
			int value = charactersFreqs.get(index);
			charactersFreqs.set(index, value + 1);
		}
	}

	/*
	 * Write a void method called findAllCharacters that opens a file, and reads
	 * the file line-by-line. For each line, if there is a period on the line,
	 * extract the possible name of the speaking part, and call update to count
	 * it as an occurrence for this person. Make sure you clear the appropriate
	 * instance variables before each new file.
	 */

	public void findAllCharacters() {
		charactersFreqs.clear();
		charactersWords.clear();
		FileResource file = new FileResource();
		for (String str : file.lines()) {
			int indexDot = str.indexOf('.');
			if (indexDot != -1) {
				String name = str.substring(0, indexDot);
				update(name);
			}
		}
	}

	public void print() {
		int k = 0;
		for (String str : charactersWords) {
			if (charactersFreqs.get(k) > 2) {
				System.out.println(charactersFreqs.get(k) + "\t" + str);
			}
			k++;
		}
	}

	/*
	 * Write a void method called charactersWithNumParts that has two int
	 * parameters named num1 and num2, where you can assume num1 should be less
	 * than or equal to num2. This method should print out the names of all
	 * those characters that have exactly number speaking parts, where number is
	 * greater than or equal to num1 and less than or equal to num2. Add code in
	 * tester to test this method out.
	 */
	
	public void charactersWithNumParts(int num1, int num2){
		if ((num1 <= num2) & (num1 > 0)){
			int index = 0;
			for(int i: charactersFreqs){
				if ((i >= num1) & (i <= num2)){
					System.out.println(i + "\t" + charactersWords.get(index));
					
				}
				index++;
			}
		}else{
			System.out.println("Num1 must be more then 0 and (num1 <= num2)");
		}
	}
	

	@Override
	public String toString() {
		return "CharactersInPlay [charactersWords=" + charactersWords
				+ ", charactersFreqs=" + charactersFreqs + "]";
	}

}
