package coursera;

/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer {
	private ArrayList<LogEntry> records;

	public LogAnalyzer() {
		records = new ArrayList<LogEntry>();

	}

	public void readFile(String filename) {
		FileResource file = new FileResource(filename);
		for (String line : file.lines()) {
			records.add(WebLogParser.parseEntry(line));
		}
	}

	public void printAll() {
		for (LogEntry le : records) {
			System.out.println(le);
		}
	}

	/*
	 * In the LogAnalyzer class, write the method countUniqueIPs that has no
	 * parameters. This method should return an integer representing the number of
	 * unique IP addresses. It should also assume that the instance variable records
	 * already has its ArrayList of Strings read in from a file, and should access
	 * records in computing this value. For help, refer to the lectures in this
	 * lesson on the unique IP algorithm and code.
	 */
	public int countUniqueIPs() {

		ArrayList<String> hasCopy = new ArrayList<>();
		for (LogEntry le : records) {
			if (!hasCopy.contains(le.getIpAddress())) {
				hasCopy.add(le.getIpAddress());
			}
		}
		return hasCopy.size();
	}
/*
 * return ArrayList<LogEntry> with unique IP
 */
	public ArrayList<LogEntry> getUniqueIPs(ArrayList<LogEntry> inputArr) {

		ArrayList<LogEntry> uniqueIPEntry = new ArrayList<>();
		ArrayList<String> uniqueIPString = new ArrayList<>();
			for (LogEntry le : inputArr) {
				if(!uniqueIPString.contains(le.getIpAddress())) {
					uniqueIPString.add(le.getIpAddress());
					uniqueIPEntry.add(le);
			}
		}
		return uniqueIPEntry;
	}

	/*
	 * In the LogAnalyzer class, write the void method printAllHigherThanNum that
	 * has one integer parameter num. This method should examine all the web log
	 * entries in records and print those LogEntrys that have a status code greater
	 * than num. Be sure to add code in the Tester class to test out this method
	 * with the file short-test_log.
	 */

	public void printAllHigherThanNum(int num) {
		System.out.println("\nprintAllHigherThanNum() started");
		System.out.println("LogEntrys that have a status code greater than num = " + num + ":");
		ArrayList<LogEntry> arrayLogsHigherThanNum = new ArrayList<>();
		for (LogEntry logEntry : records) {
			if (num < logEntry.getStatusCode()) {
				arrayLogsHigherThanNum.add(logEntry);
				System.out.println(arrayLogsHigherThanNum);
			}
		}
	}

	/*
	 * In the LogAnalyzer class, write the method uniqueIPVisitsOnDay that has one
	 * String parameter named someday in the format “MMM DD” where MMM is the first
	 * three characters of the month name with the first letter capitalized and the
	 * others in lowercase, and DD is the day in two digits (examples are “Dec 05”
	 * and “Apr 22”). This method accesses the web logs in records and returns an
	 * ArrayList of Strings of unique IP addresses that had access on the given day.
	 * (Note that the dates in LogEntrys are stored as a Date object, but using
	 * toString will allow you to access the characters in the Date. For example,
	 * consider that d is a Date. String str = d.toString(); allows you to now use a
	 * String representation of the date.) Be sure to test your program with code in
	 * the Tester class. Using the file weblog-short_log you should see that the
	 * call to uniqueIPVisitsOnDay(“Sep 14”) returns an ArrayList of 2 items and
	 * uniqueIPVisitsOnDay(“Sep 30”) returns an ArrayList of 3 items.
	 */
	public ArrayList<String> uniqueIPVisitsOnDay(String someDay) {
		System.out.println("\nuniqueIPVisitsOnDay started");
		ArrayList<LogEntry> sameDate = new ArrayList<>();
		ArrayList<String> result = new ArrayList<>();
		for (LogEntry le : records) {
			if (le.getAccessTime().toString().contains(someDay)) {
				sameDate.add(le);
			}
		}
		for (LogEntry logEntry : getUniqueIPs(sameDate)) {
			result.add(logEntry.getIpAddress());
		}
		return result;
	}
	
	/*
	 * In the LogAnalyzer class, write the method countUniqueIPsInRange that has two
	 * integer parameters named low and high. This method returns the number of
	 * unique IP addresses in records that have a status code in the range from low
	 * to high, inclusive. Be sure to test your program on several ranges. For
	 * example, using the file short-test_log, the call
	 * countUniqueIPsInRange(200,299) returns 4, as there are four unique IP
	 * addresses that have a status code from 200 to 299. The call
	 * countUniqueIPsInRange(300,399) returns 2. In this case, note that there are
	 * three entries in the file that have a status code in the 300 range, but two
	 * of them have the same IP address.
	 */
	public int countUniqueIPsInRange(int low, int high) {
		ArrayList<LogEntry> arrLe = new ArrayList<>();
		for (LogEntry logEntry : records) {
			if((logEntry.getStatusCode() <= high) & (logEntry.getStatusCode() >= low)) {
				arrLe.add(logEntry);
			}
		}
		return getUniqueIPs(arrLe).size();
	}
}
