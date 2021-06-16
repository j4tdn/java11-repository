package ex03;

import java.time.LocalDate;

public class AppJava8 {
	public static void main(String[] args) {
		LocalDate localDate = UtilsJava8.input();
		System.out.println(localDate.getDayOfMonth() + " " + localDate.getMonth() + " " + localDate.getYear() + " is a "
				+ localDate.getDayOfWeek());
		System.out.println("Additional facts");
		System.out.println("It is day number " + localDate.getDayOfYear() + " of the year, "
				+ (localDate.isLeapYear() ? 366 - localDate.getDayOfYear() : 365 - localDate.getDayOfYear())
				+ " days left");
		System.out.println("It is " + localDate.getDayOfWeek() + " number " + UtilsJava8.countDay(localDate, "YEAR")
				+ " out of " + UtilsJava8.countAllDay(localDate, "YEAR") + " in " + localDate.getYear());

		System.out.println("It is " + localDate.getDayOfWeek() + " number " + UtilsJava8.countDay(localDate, "MONTH")
				+ " out of " + UtilsJava8.countAllDay(localDate, "MONTH") + " in " + localDate.getMonth() + " "
				+ localDate.getYear());
		System.out.println("Year " + localDate.getYear() + " has " + (localDate.isLeapYear() ? 366 : 365) + " days.");
		System.out.println(localDate.getMonth() + " " + localDate.getYear() + " has " + localDate.getMonth().maxLength()
				+ " days");
	}
}
