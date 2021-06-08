package datetime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import utils.DateUtils;

public class Ex01 {
	public static void main(String[] args) {
		// JAVA 07: Month 0 - 11 <<=>> JAn - DEC
		Date date = new Date();
		System.out.println("date: " + date);
		
		Calendar c = Calendar.getInstance();
		System.out.println("calendar: " + c);
		System.out.println("================");
		int day = c.get(Calendar.DAY_OF_MONTH);
		int month = c.get(Calendar.MONTH);
		int year = c.get(Calendar.YEAR);
		
		
		System.out.println("d/m/y: " + day + "-" + months[month] + "-" + year);
		
		int hour12 = c.get(Calendar.HOUR);
		int hour24 = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);
		
		System.out.println("h:m:s >> " + hour12 + ":" + minute + ":" + second);
		
		// number of days in month, year
		int daysInMonth = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		int test = c.getMaximum(Calendar.DAY_OF_MONTH);
		
		System.out.println("days in month: " + daysInMonth);
		System.out.println("test: " + test);
		
		int dow = c.get(Calendar.DAY_OF_WEEK);
		System.out.println("day of week: " + dow);
		
		// first day of week: default: MONDAY
		int fdow = c.getFirstDayOfWeek();
		System.out.println("first day of week: " + fdow);
		
		//first day of week number = current_date - fdow - current_dow
		
		c.add(Calendar.DAY_OF_MONTH, fdow - c.get(Calendar.DAY_OF_WEEK));
		System.out.println("c: " + c);
		// fdow_num = 7.6.2021
		
		int dayIndex = 1;
		while(dayIndex <= 7) {
			System.out.println(df.format(c.getTime()));
			c.add(Calendar.DAY_OF_MONTH, 1);
			dayIndex++;
		}
		c.set(Calendar.YEAR, 2020);
		System.out.println("isLeapYear: " + DateUtils.isLeapYear(2020));
	}
	
	private static String[] months = {"JAN", "Feb", "MAR", "APR", "MAY", "JUNE", "July", "Aug", "SEP", "OCT", "NOV", "DEM"};
	private static DateFormat df = new SimpleDateFormat("dd/MM/yyyy EEEE");
}
