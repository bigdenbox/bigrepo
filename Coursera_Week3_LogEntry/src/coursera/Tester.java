package coursera;

/**
 * Write a description of class Tester here.
 * 
 * @author bigdenbox 
 * @version (a version number or a date)
 */

import java.util.*;

public class Tester {
	private LogAnalyzer la;

	public Tester() {
		la = new LogAnalyzer();
		la.readFile();
	}
	
	public Tester(String fileName) {
		la = new LogAnalyzer();
		la.readFile(fileName);
	}

	public void testLogEntry() {
		LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
		System.out.println(le);
		LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
		System.out.println(le2);
	}

	public void testLogAnalyzer() {
		this.la.printAll();
	}

	public void testUniqueIP() {
		System.out.println("Unique IP = " + this.la.countUniqueIPs());

	}

	public void testprintAllHigherThanNum(int num) {
		this.la.printAllHigherThanNum(num);
	}

	public void testuniqueIPVisitsOnDay(String str) {
		ArrayList<String> uniqueIP = this.la.uniqueIPVisitsOnDay(str);
		System.out.println("Number of unique IP at Date = " + str + " is: " + uniqueIP.size());
		for (String s : uniqueIP) {
			System.out.println(s);
		}
	}
	
	public void testcountUniqueIPsInRange(int low, int high) {
		System.out.println("\nIn range of Status Code[" + low + ", " + high + "] there are " + this.la.countUniqueIPsInRange(low, high) + " IPs");
	}
	
	public void testcountVisitsPerIP() {
		System.out.println("\ncountVisitsPerIP started");
		HashMap<String, Integer> map = this.la.countVisitsPerIP();
		System.out.println("HashMap<IP,Count> created:");
		for (String s : map.keySet()) {
			System.out.println("IP = " + s + "\t" + map.get(s) );
		}
	}
	
	public void testmostNumberVisitsByIP() {
		System.out.println("\nmostNumberVisitsByIP started");
		System.out.println("The most Number Visits By IP = " + this.la.mostNumberVisitsByIP(this.la.countVisitsPerIP()));
	}
	
	public void testiPsMostVisits() {
		System.out.println("\niPsMostVisits started");
		ArrayList<String> ipArr = this.la.iPsMostVisits(this.la.countVisitsPerIP());
		System.out.println("Most common IPs with number = " + this.la.mostNumberVisitsByIP(this.la.countVisitsPerIP()));
		for (String string : ipArr) {
			System.out.println("IP = " + string);
		}
	}
	
	public void testiPsForDays() {
		System.out.println("\n iPsForDays started");
		HashMap<String, ArrayList<String>> map = this.la.iPsForDays();
		//System.out.println(this.la.iPsForDays());
		for (String s : map.keySet()) {
			System.out.println("Day: " + s);
			for (String arrs : map.get(s)) {
				System.out.println("\t" + arrs);
			}
		}
	}
	
	public void testdayWithMostIPVisits() {
		System.out.println("\ndayWithMostIPVisits started");
		System.out.println("The day With Most IP Visits is: " + this.la.dayWithMostIPVisits(this.la.iPsForDays()));
	}
	
	public void testiPsWithMostVisitsOnDay (String day) {
		System.out.println("iPsWithMostVisitsOnDay started");
		ArrayList<String> arrIP = this.la.iPsWithMostVisitsOnDay(this.la.iPsForDays(), day);
		System.out.println("iPs With Most Visits On Day = " + day + ":");
		for (String string : arrIP) {
			System.out.println(string);
		}
	}
	
}
