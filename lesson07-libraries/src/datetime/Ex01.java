package datetime;

import java.time.DayOfWeek;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;

public class Ex01 {
	private static String[] months = { "JAN", "FEB", "FEB", "MAR", "APR", "MAY", "JUNE", "JULY", "AUG", "SEP", "OCT",
			"NOV", "DEC" };

	public static void main(String[] args) {
		Date date = new Date();
		System.out.println("date: " + date);

		Calendar c = Calendar.getInstance();
		System.out.println("calender: " + c);
		int day = c.get(Calendar.DAY_OF_MONTH);
		int month = c.get(Calendar.MONTH);
		int year = c.get(Calendar.YEAR);

		Month month1 = Month.of(5);
		System.out.println(month1);

		System.out.println("d/m/y: " + day + "/" + month + "/" + year);
		System.out.println("d/m/y: " + day + "/" + month + "/" + year);

		int hour12 = c.get(Calendar.HOUR);
		int hour24 = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);
		System.out.println("h:m:s  " + hour12 + ":" + minute + ":" + second);

		int daysInMonth = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println(daysInMonth);

		// First day of week
		System.out.println(c.getFirstDayOfWeek());

		//
		int dow = c.get(Calendar.FRIDAY);

	}
}
