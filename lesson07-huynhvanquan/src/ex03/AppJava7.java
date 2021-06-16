package ex03;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class AppJava7 {
	private static String[] months = { "January", "February", "March", "April", "May", "June", "July", "August",
			"September", "October", "November", "December" };
	private static String[] dates = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

	public static void main(String[] args) {
		Calendar c = UtilsJava7.input();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println(c.get(Calendar.DAY_OF_MONTH) + " " + months[c.get(Calendar.MONTH)] + " "
				+ c.get(Calendar.YEAR) + " is a " + dates[c.get(Calendar.DAY_OF_WEEK) - 1]);
		System.out.println("Additional facts");

		System.out.println("It is day number " + c.get(Calendar.DAY_OF_YEAR) + " of the year, "
				+ UtilsJava7.countDayLeft(c) + " days left");

		System.out
				.println("It is " + dates[c.get(Calendar.DAY_OF_WEEK) - 1] + " number " + UtilsJava7.countDay(c, "YEAR")
						+ " out of " + UtilsJava7.countAllDay(c, "YEAR") + " in " + c.get(Calendar.YEAR));

		System.out.println("It is" + dates[c.get(Calendar.DAY_OF_WEEK) - 1] + "number "
				+ UtilsJava7.countDay(c, "MONTH") + " out of " + UtilsJava7.countAllDay(c, "MONTH") + " in "
				+ months[c.get(Calendar.MONTH)] + " " + c.get(Calendar.YEAR));
		System.out.println("Year " + c.get(Calendar.YEAR) + " has " + UtilsJava7.allDaysInYear(c));
		System.out.println(months[c.get(Calendar.MONTH)] + " " + c.get(Calendar.YEAR) + " has "
				+ c.getActualMaximum(Calendar.DATE) + " days");
	}

}
