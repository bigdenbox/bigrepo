package cherednikov;

// (D1 - ( 1 yanvarya 2001) ) %7 !!!!!!!!!!!!

public class Date {
	// private static char[] DayOfWeek;
	private Day day;
	private Month month;
	private Year year;
	private boolean isLeap; // visokosnost
//	private DayOfWeek dayOfWeek;

	public Date(int day, int month, int year) {
		this.day = new Day(day);
		this.month = new Month(month);
		this.year = new Year(year);
		// this.dayOfWeek;

	}

	public DayOfWeek getDayOfWeek() {
		int daysAfter1_01_1990 = daysBetween(new Date(01, 01, 1990));
		for (DayOfWeek dw : DayOfWeek.values()) {
			if (dw.ordinal() == (Math.abs(daysAfter1_01_1990) % 7)) {
				return dw;
			}
		}
		return null;
	}

	public int getDayOfYear() {
		int dayOfYear = this.day.day;
		int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if (isLeap) {
			daysInMonth[1]++;
		}
		for (int i = 0; i < this.month.month - 1; i++) {
			dayOfYear += daysInMonth[i];
		}
		return dayOfYear;
	}

	public int daysBetween(Date date1, Date date2) {
		int result = 0;

		if (this.year.year > date2.year.year) {
			return (0 - daysBetween(date2, date1));
		}

		if (date1.year.year != date2.year.year) {
			if (this.isLeap) {
				result = date2.getDayOfYear() + (366 - date1.getDayOfYear());
			} else {
				result = date2.getDayOfYear() + (365 - date1.getDayOfYear());
			}
		} else {
			result = Math.abs(date1.getDayOfYear() - date2.getDayOfYear());
		}
		int[] years = new int[date2.year.year - date1.year.year];

		for (int i = 0; i < years.length; i++) {
			years[i] = date1.year.year + i;
		}

		for (int i = 1; i < years.length; i++) {
			if (new Date(01, 01, years[i]).isLeap) {
				result = result + 366;
			} else {
				result = result + 365;
			}
		}

		return result;

	}

	public int daysBetween(Date date2) {

		return daysBetween(this, date2);
	}

	private class Year {
		private int year;

		public Year(int year) {
			this.year = year;
			if (year % 4 == 0) {
				isLeap = true;
			}
		}
	}

	private class Month {
		private int month;

		public Month(int month) {
			this.month = month;
		}
	}

	private class Day {
		private int day;

		public Day(int day) {
			this.day = day;
		}
	}

	public enum DayOfWeek {
		MONDAY(0), TUESDAY(1), WEDNESDAY(2), THURSDAY(3), FRIDAY(4), SATURDAY(5), SUNDAY(
				6);

		private int index;

		private DayOfWeek(int index) {
			this.index = index;
		}
	}

	public String toString() {
		String result = "[" + this.day.day + "." + this.month.month + "."
				+ this.year.year + "] " + this.getDayOfWeek();
		if (isLeap) {
			result = result + " Leap year";
		} else {
			result = result + " Not Leap year";
		}
		return result;
	}
}
