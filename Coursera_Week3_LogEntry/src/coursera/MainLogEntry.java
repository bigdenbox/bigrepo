package coursera;

public class MainLogEntry {

	public static void main(String[] args) {

//		Tester tester = new Tester("src\\weblog-short_log.txt");
		Tester tester = new Tester("src\\short-test_log.txt");
		
		/*  print all entrys  */
		tester.testLogAnalyzer();
		
		/* print number of unique IPs */ 
		tester.testUniqueIP();
		
		/* print all Entrys who has status code higher than num */
		tester.testprintAllHigherThanNum(200);
		
		/* print number of unique IPs in Date range*/
		tester.testuniqueIPVisitsOnDay("Sep 14");

		/* print number of unique IPs in status range*/ 
		tester.testcountUniqueIPsInRange(300, 399);
	}

}
