package coursera;

public class MainGladLib {

	public static void main(String[] args) {
		GladLib gl = new GladLib();
		gl.makeStory();
//**    gl.printSeenWordsList();
		System.out.println("Total words in all ArrayLists = " + gl.totalWordsInMap());
		System.out.println("Total words in considered ArrayLists = " + gl.totalWordsConsidered());
		System.out.print("Considered files: " + gl.getTotalWordsCount().toString());
		
		
		
		

	}

}
