package datetime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import utils.DateUtils;

public class Ex01 {
	
	private static DateFormat df = new SimpleDateFormat("dd/MM/yyyy EEEE");
	
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println("date: " + date);
		
//		Locale.setDefault(Locale.FRANCE);
		Calendar c = Calendar.getInstance();
		System.out.println("calendar: " + c);
		System.out.println("===============");
		int day = c.get(Calendar.DAY_OF_MONTH);
		int month = c.get(Calendar.MONTH);
		int year = c.get(Calendar.YEAR);
		String[] months = {"JAN", "FEB", "MAR", "APR", "MAY", "JUNE", "JULY", "AUG", "SEP", "OCT", "NOV", "DEC"};
		System.out.println("d-m-y: " + day + "-" + months[month] + "-" + year);
		
		int hour12 = c.get(Calendar.HOUR);
		int hour24 = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);
		System.out.println("h:m:s >> " + hour12 + ":" + minute + ":" + second);
		
		// Number of days in month, year
		int daysInMonth = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println("days in month: " + daysInMonth);
		
		int dow = c.get(Calendar.DAY_OF_WEEK);
		System.out.println("dow: " + dow);
		
		// first day of week
		int fdow = c.getFirstDayOfWeek();
		System.out.println("fdow: " + fdow);
		
		// fdow
		c.add(Calendar.DAY_OF_MONTH, fdow);
		
		c.add(Calendar.DAY_OF_MONTH, fdow - c.get(Calendar.DAY_OF_WEEK));
		System.out.println("c: " + c);
		
		
		int dayindex = 1;
		while(dayindex <= 7) {
			System.out.println(df.format(c.getTime()));
			c.add(Calendar.DAY_OF_MONTH, 1);
			dayindex++;
		}
		
		c.set(Calendar.YEAR, 2020);
		System.out.println("isLeapYear: " + DateUtils.isLeapYear(c.get(Calendar.YEAR)));
	}
}
