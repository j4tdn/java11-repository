package datetime;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import utils.DateUtils;

public class Ex01 {
	private static String[] months = { "JAN", "FEB", " MAR", "APR", "MAY", "JUNE", "JULY", "AUG", "SEP", "OCT", "NOV",
			"DEC" };
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy EEE");

	public static void main(String[] args) {
		// Java07: Month 0 - 11 <=> Jan - Dec
		Date date = new Date();
		System.out.println("date: " + date);

		// singleton pattern
		Locale.setDefault(Locale.FRANCE);
		//Locale.setDefault(Locale.US);
		Calendar c = Calendar.getInstance();
		System.out.println("Calendar " + c);
		System.out.println("===============");
		int day = c.get(Calendar.DAY_OF_MONTH);
		int month = c.get(Calendar.MONTH);
		int year = c.get(Calendar.YEAR);

		System.out.println("d/m/y: " + day + "/" + (month + 1) + "/" + year);

		int hour12 = c.get(Calendar.HOUR);
		int hour24 = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);
		System.out.println("h:m:s >> " + hour12 + ":" + minute + ":" + second);
		// set time
		c.set(Calendar.MONTH, Calendar.JULY);

		// number of days in month
		int daysInMonth = c.getActualMinimum(Calendar.DAY_OF_MONTH);
		System.out.println("Day of month: " + daysInMonth);

		int dow = c.get(Calendar.DAY_OF_WEEK);
		System.out.println("dow: " + dow);
		// first day of week
		System.out.println("Locale: " + Locale.getDefault());
		int fdow = c.getFirstDayOfWeek();
		System.out.println("fow: " + fdow);
		
		// fow_num = current_date + fow - current_dow
		c.add(Calendar.DAY_OF_MONTH, fdow - c.get(Calendar.DAY_OF_WEEK));
		System.out.println("c: " + c);
		
		int dayIndex = 1;
		while(dayIndex <= 7 ) {
		  System.out.println(sdf.format(c.getTime()));
		  c.add(Calendar.DAY_OF_WEEK, 1);
			dayIndex++;
		}
		c.set(Calendar.YEAR, 2020);
		System.out.println("isLeapYear: " + DateUtils.isLeapYear(c.get(Calendar.YEAR)));
		
		
		System.out.println("FROM EPOCH: " + c.getTimeInMillis());
	}
}
