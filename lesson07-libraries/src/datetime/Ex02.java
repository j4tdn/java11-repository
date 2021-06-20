package datetime;

import java.util.Calendar;
import java.util.Date;

import utils.DateUtils;

/**
 * 
 * Converter String, Date, calender
 */
public class Ex02 {
	
	private static String STRING_AS_DATE = "12/06/2021";
	
	public static void main(String[] args) {
		Date today = DateUtils.toDate(STRING_AS_DATE);
		Calendar c = DateUtils.toCalendar(today);
		
		System.out.println("todo: " + today);
		System.out.println(c);
		
		// get weekday 
//		System.out.println(c.DAY_OF_WEEK);
		System.out.println(DateUtils.getWeekDayAsString(c.get(Calendar.DAY_OF_WEEK)));
		
		System.out.println("===========");
		
		Date date = DateUtils.toDate(c);
		String dateAsString = DateUtils.toString(date);
		System.out.println(dateAsString);
	}
}