package datetime;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import utils.DateUtils;

public class Ex01 {
	private static String[] months = { "JAN", "FEB", "MAR", "APR", "MAY", "JUNE", "JULY", "AUG", "AUG", "SEP", "OCT",
			"NOV", "DEC" };

	private static SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy EEE");

	public static void main(String[] args) {
		// java7: month 0-11 <<==>> JAN - DEC
		Date date = new Date();
		System.out.println("date: " + date);

		Calendar c = Calendar.getInstance();
		System.out.println("calendar: " + c);
		System.out.println("=========");
		int day = c.get(Calendar.DAY_OF_MONTH);
		int month = c.get(Calendar.MONTH);
		int year = c.get(Calendar.YEAR);

		System.out.println("d/m/y: " + day + "/" + months[month] + "/" + year);

		int hour12 = c.get(Calendar.HOUR);
		int hour24 = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);

		System.out.println("h:m:s>> " + hour12 + ":" + minute + ":" + second);

		// number of days in month, year
		int daysInmonth = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		int test = c.getMaximum(Calendar.DAY_OF_MONTH);
		System.out.println("day in month: " + daysInmonth);

		int dow = c.get(Calendar.DAY_OF_WEEK);
		System.out.println("dow: " + dow);
		// first day of week:default: SUNDAY
		System.out.println("local: " + Locale.getDefault());
		int fdow = c.getFirstDayOfWeek();
		System.out.println("fdow: " + fdow);

		// fdow_num = current_date + fdow - current_dow
		c.add(Calendar.DAY_OF_MONTH, fdow - c.get(Calendar.DAY_OF_WEEK));
		System.out.println("c: " + c);

		// fdow_num = 6.6.2021
		System.out.println("=====");
		int dayIndex = 0;
		while (dayIndex <= 6) {
			System.out.println(df.format(c.getTime()));
			c.add(Calendar.DAY_OF_MONTH, 1);
			dayIndex++;
		}

		c.set(Calendar.YEAR, 2020);
		System.out.println("isLeapYear: " + DateUtils.isLeapYear(c.get(Calendar.YEAR)));

		System.out.println(c);
		System.out.println("form epoch time: " + c.getTimeInMillis());
	}
}
