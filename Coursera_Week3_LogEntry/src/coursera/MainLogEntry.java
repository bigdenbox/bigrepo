package coursera;

public class MainLogEntry {

	public static void main(String[] args) {

//		Tester tester = new Tester("src\\weblog-short_log.txt");
		Tester tester = new Tester();
		
		/*  print all entrys  */
//		tester.testLogAnalyzer();
		
		/* print number of unique IPs */ 
//		tester.testUniqueIP();
		
		/* print all Entrys who has status code higher than num */
//		tester.testprintAllHigherThanNum(400);
		
		/* print number of unique IPs in Date range*/
//		tester.testuniqueIPVisitsOnDay("Sep 27");

		/* print number of unique IPs in status range*/ 
//		tester.testcountUniqueIPsInRange(400,499);
		
		/* create HashMap<String, Integer> and count IPs*/
//		tester.testcountVisitsPerIP();
	
		/* print most number visits by IP*/
//		tester.testmostNumberVisitsByIP();
		
		/* print ALL ips with most number visits*/
//		tester.testiPsMostVisits();
		
		/* print ALL ips per day*/
//		tester.testiPsForDays();
		
		/* print day with most visits*/
		tester.testdayWithMostIPVisits();
		
		/* print most common IPs per  some DAY*/
		tester.testiPsWithMostVisitsOnDay("Sep 29");
		
	
	}

}
