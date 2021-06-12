package datetime;

import java.util.Calendar;
import java.util.Date;

import utils.DateUtils;

/*
 * Converter String, Date, Calendar
 * 
 * */
public class Ex02 {
	private static String STRING_AS_DATE = "12/06/2021";
	public static void main(String[] args) {
		Date today = DateUtils.toDate(STRING_AS_DATE);
		Calendar c = DateUtils.toCalendar(today);
		
		System.out.println("today: " + today);
		System.out.println("c: " + c);
		
		// get weekday
		// int weekday = c.get(Calendar.DAY_OF_WEEK);
		String weekday = DateUtils.getWeekDayAsString(c.get(Calendar.DAY_OF_WEEK));
		System.out.println("weekday: " + weekday);
		
		Date date = DateUtils.toDate(c);
		String dateAsString = DateUtils.toString(date);
		
		System.out.println("date: " + date);
		System.out.println("dateAsString: " + dateAsString);
	}
}
