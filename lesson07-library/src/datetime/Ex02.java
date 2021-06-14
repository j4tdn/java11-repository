package datetime;

import java.util.Calendar;
import java.util.Date;

import utils.DateUtils;

/**
 * 
 *Converter String, Date (cua package Utils), Calendar : chuyen doi qua lai
 */
public class Ex02 {
	private static String STRING_AS_DATE = "12/06/2021";
	public static void main(String[] args) {
		Date today = DateUtils.toDate(STRING_AS_DATE); //String ve date
		Calendar c = DateUtils.toCalendar(today); 		//date ve Calendar
		
		System.out.println("today" + today);
		System.out.println("c:" + c);
		
		//get weekday in c. ngay c la thu may
		String weekday = DateUtils.getWeekDayAsString(c.get(Calendar.DAY_OF_WEEK));
		System.out.println("weekday: " + weekday);
		
		System.out.println("=============================================");
		Date date = DateUtils.toDate(c);	//Calendar ve date
		String dateAsString = DateUtils.toString(date); 	//date ve String
		
		System.out.println("date: " + date);
		System.out.println("date As String: " + dateAsString);
	}
	
}
