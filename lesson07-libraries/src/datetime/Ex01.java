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
	private static DateFormat  df = new SimpleDateFormat("dd/MM/yy EEE");

	public static void main(String[] args) {
		// JAVA07: Month 0 - 11 <<=>> JAN - DEC

		Date date = new Date();
		System.out.println("date" + date);

		//Locale.setDefault(Locale.FRANCE);
		Calendar c = Calendar.getInstance();
		System.out.println("Calendar" + c);
		System.out.println("================");
		int day = c.get(Calendar.DAY_OF_MONTH);
		int month = c.get(Calendar.MONTH);
		int year = c.get(Calendar.YEAR);

		// 8-June-2021
		System.out.println("d-m-y: " + day + "/" + (month + 1) + "/" + year);

		int hour12 = c.get(Calendar.HOUR);
		int hour24 = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);

		System.out.println("h:m:s >> " + hour12 + ":" + minute + ":" + second);

		// set time
		c.set(Calendar.MONTH, Calendar.JULY);

		// number of days in month, year
		int daysInMonth = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		int test = c.getMaximum(Calendar.DAY_OF_MONTH);
		System.out.println("days in month: " + daysInMonth);
		System.out.println("test: " + test);

		int dow = c.get(Calendar.DAY_OF_WEEK);
		System.out.println("dow: " + dow);

		// first of week
		System.out.println("Locale: " + Locale.getDefault());

		int fdow = c.getFirstDayOfWeek();
		System.out.println("fdow: " + fdow);

		// fdow_num = current_date + fdow - current_dow

		c.add(Calendar.DAY_OF_MONTH, fdow - c.get(Calendar.DAY_OF_WEEK));
		System.out.println("c: " + c);
		// fdow_num = 6.6.2021

		System.out.println("==========================");
		
		int dayIndex = 1;
		while (dayIndex <= 7) {
			System.out.println(df.format(c.getTime()));
			c.add(Calendar.DAY_OF_MONTH, 1);
			//System.out.println("day: " + c.get(Calendar.DAY_OF_MONTH));
			dayIndex++;
		}
		
        c.set(Calendar.YEAR, 2020);
		System.out.println("isLeapYear: " + DateUtils.isLeapYear(c.get(Calendar.YEAR)));

		System.out.println("c " + c);
		System.out.println("FROM EPOCH: " + c.getTimeInMillis());
	}
}
