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
}
