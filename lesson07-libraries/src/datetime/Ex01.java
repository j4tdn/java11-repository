package datetime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import utils.DateUtils;

public class Ex01 {
	private static String[] months = { "JAN", "FEB", "MAR", "APR", "MAY", "JUNE", "JULY", "AUG", "SEP", "OCT", "NOV",
			"DEC" };
	private static DateFormat df = new SimpleDateFormat("dd/MM/yyyy EEE");

	public static void main(String[] args) {
		// Java 7: Month 0-11 <<=>> Jan - Dec
		Date date = new Date();
		Date d2 = new Date();
		System.out.println("date: " + date);

		// Locale.setDefault(Locale.FRANCE);
		Calendar c = Calendar.getInstance();
		System.out.println("calendar: " + c);
		System.out.println("=====================");
		int day = c.get(Calendar.DAY_OF_MONTH);
		int month = c.get(Calendar.MONTH);
		int year = c.get(Calendar.YEAR);

		System.out.println("d/m/y: " + day + "-" + months[month] + "-" + year);

		int hour12 = c.get(Calendar.HOUR);
		int hour24 = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);
		System.out.println("h:m:s >> " + hour12 + ":" + minute + ":" + second);

		// set time
		// c.set(Calendar.MONTH, Calendar.JULY);

		int daysInMonth = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		// int test = c.getMaximum(Calendar.DAY_OF_MONTH);
		System.out.println("days in month: " + daysInMonth);
		// System.out.println("days in month: " + test);

		int daysInYear = c.getActualMaximum(Calendar.DAY_OF_YEAR);
		System.out.println("days in month: " + daysInYear);

		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);

		System.out.println("Locale: " + Locale.getDefault());

		int firstDayOfWeek = c.getFirstDayOfWeek();
		System.out.println("first day of week: " + firstDayOfWeek);

		// firsDayOfWeek_num = current_date + firstDayOfWeek - current_dayOfWeek
		c.add(Calendar.DAY_OF_MONTH, firstDayOfWeek - c.get(Calendar.DAY_OF_WEEK));
		// firstDayOfWeek: 6/6/2021
		System.out.println("c: " + c);

		int dayIndex = 1;
		while (dayIndex <= 7) {
			System.out.println(df.format(c.getTime()));
			// System.out.println("day: " + c.get(Calendar.DAY_OF_MONTH));
			c.add(Calendar.DAY_OF_MONTH, 1);
			dayIndex++;
		}
		c.set(Calendar.YEAR, 2020);
		System.out.println("is Leap year: " + DateUtils.isLeapYear(c.get(Calendar.YEAR)));
		
		System.out.println("c: " + c);
		System.out.println("From epoch: " + c.getTimeInMillis());
	}
}
