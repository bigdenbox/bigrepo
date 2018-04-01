package cherednikov;

public class MainDate {

	public static void main(String[] args) {
		Date date = new Date(01, 04, 2018);
		System.out.println("Our date is " + date.toString());
		System.out.println("Day in this year = " + date.getDayOfYear());
		Date date2 = new Date(01, 04, 2018);
		System.out.println("Days beetween " + date + " and " + date2 + " is " + date.daysBetween(date2) + " days");
		
		
	}

}
