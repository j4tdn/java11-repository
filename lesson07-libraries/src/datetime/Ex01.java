package datetime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import utils.DateUtils;

public class Ex01 {

	private static String[] months = { "JAN", "FEB", "MAR", "APR", "MAY", "JUNE", "JULY", "AUG", "SEP", "OCT", "NOV",
			"DEC" };
	private static DateFormat df = new SimpleDateFormat("dd/MM/yyyy EEE");

	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);

		// singleton pattern
		Calendar c = Calendar.getInstance();
		System.out.println(c);

		int day = c.get(Calendar.DAY_OF_MONTH);
		int month = c.get(Calendar.MONTH);
		int year = c.get(Calendar.YEAR);

		System.out.println("d-m-y: " + day + "-" + (months[month]) + "-" + year);

		int hour = c.get(Calendar.HOUR);
		int hour24 = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);

		int daysInMonth = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println("days in month: " + daysInMonth);

		int dow = c.get(Calendar.DAY_OF_WEEK);
		System.out.println("dow: " + dow);

		// System.out.println("Local: " + Local.getDefault());

		int fdow = c.getFirstDayOfWeek();
		System.out.println("fdow: " + fdow);

		// fdow_num = currentDate + fdow - currentdow
		c.add(Calendar.DAY_OF_MONTH, fdow - c.get(Calendar.DAY_OF_WEEK));
		System.out.println("c: " + c);

		System.out.println("===================");
		int dayIndex = 1;
		while (dayIndex <= 7) {
			System.out.println(df.format(c.getTime()));
			c.add(Calendar.DAY_OF_MONTH, 1);
			dayIndex++;
		}

		c.set(Calendar.YEAR, 2020);
		System.out.println("isLeapYear: " + DateUtils.isLeapYear(c.get(Calendar.YEAR)));
	}

}
