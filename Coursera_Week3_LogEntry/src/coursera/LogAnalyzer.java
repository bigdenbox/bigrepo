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

	public void readFile() {
		FileResource file = new FileResource();
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
			if (!uniqueIPString.contains(le.getIpAddress())) {
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
				System.out.println(logEntry);
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
			if ((logEntry.getStatusCode() <= high) & (logEntry.getStatusCode() >= low)) {
				arrLe.add(logEntry);
			}
		}
		return getUniqueIPs(arrLe).size();
	}

	/*
	 * In the LogAnalyzer class, write the method countVisitsPerIP, which has no
	 * parameters. This method returns a HashMap<String, Integer> that maps an IP
	 * address to the number of times that IP address appears in records, meaning
	 * the number of times this IP address visited the website. Recall that records
	 * stores LogEntrys from a file of web logs. For help, refer to the video in
	 * this lesson on translating to code. Be sure to test this method on sample
	 * files.
	 */
	public HashMap<String, Integer> countVisitsPerIP() {
		HashMap<String, Integer> mapLogEntrys = new HashMap<>();
		for (LogEntry logEntry : records) {
			if (!mapLogEntrys.containsKey(logEntry.getIpAddress())) {
				mapLogEntrys.put(logEntry.getIpAddress(), 1);
			} else {
				mapLogEntrys.put(logEntry.getIpAddress(), mapLogEntrys.get(logEntry.getIpAddress()) + 1);
			}
		}
		return mapLogEntrys;
	}

	public HashMap<String, Integer> countVisitsPerIP(HashMap<String, Integer> inputMap) {
		HashMap<String, Integer> mapLogEntrys = new HashMap<>();
		for (String s : inputMap.keySet()) {
			if (!mapLogEntrys.containsKey(s)) {
				mapLogEntrys.put(s, 1);
			} else {
				mapLogEntrys.put(s, inputMap.get(s) + 1);
			}
		}
		return mapLogEntrys;
	}

	/*
	 * In the LogAnalyzer class, write the method mostNumberVisitsByIP, which has
	 * one parameter, a HashMap<String, Integer> that maps an IP address to the
	 * number of times that IP address appears in the web log file. This method
	 * returns the maximum number of visits to this website by a single IP address.
	 * For example, the call mostNumberVisitsByIP on a HashMap formed using the file
	 * weblog3-short_log returns 3
	 */
	public int mostNumberVisitsByIP(HashMap<String, Integer> inputMap) {
		int mostNumber = 0;
		for (String s : inputMap.keySet()) {
			if (mostNumber < inputMap.get(s)) {
				mostNumber = inputMap.get(s);
			}
		}
		return mostNumber;
	}

	/*
	 * In the LogAnalyzer class, write the method iPsMostVisits, which has one
	 * parameter, a HashMap<String, Integer> that maps an IP address to the number
	 * of times that IP address appears in the web log file. This method returns an
	 * ArrayList of Strings of IP addresses that all have the maximum number of
	 * visits to this website. For example, the call iPsMostVisits on a HashMap
	 * formed using the file weblog3-short_log returns the ArrayList with these two
	 * IP addresses, 61.15.121.171 and 84.133.195.161. Both of them visited the site
	 * three times, which is the maximum number of times any IP address visited the
	 * site.
	 */
	public ArrayList<String> iPsMostVisits(HashMap<String, Integer> inputMap) {
		ArrayList<String> arrS = new ArrayList<>();
		int mostNumber = mostNumberVisitsByIP(inputMap);
		for (String string : inputMap.keySet()) {
			if (inputMap.get(string) == mostNumber) {
				arrS.add(string);
			}
		}
		return arrS;
	}

	/*
	 * In the LogAnalyzer class, write the method iPsForDays, which has no
	 * parameters. This method returns a HashMap<String, ArrayList<String>> that
	 * uses records and maps days from web logs to an ArrayList of IP addresses that
	 * occurred on that day (including repeated IP addresses). A day is in the
	 * format “MMM DD” where MMM is the first three characters of the month name
	 * with the first letter capital and the others in lowercase, and DD is the day
	 * in two digits (examples are “Dec 05” and “Apr 22”). For example, for the file
	 * weblog3-short_log, after building this HashMap, if you print it out, you will
	 * see that Sep 14 maps to one IP address, Sep 21 maps to four IP addresses, and
	 * Sep 30 maps to five IP addresses.
	 */

	public HashMap<String, ArrayList<String>> iPsForDays() {
		HashMap<String, ArrayList<String>> resultMap = new HashMap<>();
		for (LogEntry logEntry : records) {
			String date = logEntry.getAccessTime().toString();
			String day = date.substring(4, 10);
			if (!resultMap.containsKey(day)) {
				ArrayList<String> ipArr = new ArrayList<>();
				ipArr.add(logEntry.getIpAddress());
				resultMap.put(day, ipArr);
			} else {
				String key = day;
				ArrayList<String> ipArr = resultMap.get(key);
				ipArr.add(logEntry.getIpAddress());
				resultMap.put(key, ipArr);
			}
		}
		return resultMap;
	}

	/*
	 * In the LogAnalyzer class, write the method dayWithMostIPVisits, which has one
	 * parameter that is a HashMap<String, ArrayList<String>> that uses records and
	 * maps days from web logs to an ArrayList of IP addresses that occurred on that
	 * day. This method returns the day that has the most IP address visits. If
	 * there is a tie, then return any such day. For example, if you use the file
	 * weblog3-short_log, then this method should return the day most visited as Sep
	 * 30.
	 */

	public String dayWithMostIPVisits(HashMap<String, ArrayList<String>> inputMap) {
		String dayResult = null;
		int mostN = 0;
		for (String s : inputMap.keySet()) {
			if (mostN < inputMap.get(s).size()) {
				dayResult = s;
				mostN = inputMap.get(s).size();
			}
		}
		return dayResult;
	}

	/*
	 * In the LogAnalyzer class, write the method iPsWithMostVisitsOnDay, which has
	 * two parameters—the first one is a HashMap<String, ArrayList<String>> that
	 * uses records and maps days from web logs to an ArrayList of IP addresses that
	 * occurred on that day, and the second parameter is a String representing a day
	 * in the format “MMM DD” described above. This method returns an
	 * ArrayList<String> of IP addresses that had the most accesses on the given
	 * day. For example, if you use the file weblog3-short_log, and the parameter
	 * for the day is “Sep 30”, then there are two IP addresses in the ArrayList
	 * returned: 61.15.121.171 and 177.4.40.87. Hint: This method should call
	 * another method you have written.
	 */

	public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String, ArrayList<String>> inputMap, String inputDay) {
		ArrayList<String> resultArr = new ArrayList<>();
		HashMap<String, Integer> map = new HashMap<>();
		int mostN = 0;
		for (String s : inputMap.get(inputDay)) {
			if (!map.containsKey(s)) {
				map.put(s, 1);
			} else {
				map.put(s, map.get(s) + 1);
			}
		}
		for (String s : map.keySet()) {
			if (mostN < map.get(s)) {
				mostN = map.get(s);
				resultArr.clear();
				resultArr.add(s);
			} else {
				if (mostN == map.get(s)) {
					resultArr.add(s);
				}
			}
		}
		return resultArr;
	}

}
