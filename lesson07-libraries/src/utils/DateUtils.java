package utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

import java.util.Calendar;

public class DateUtils {
	
	private static String[] months = {"JAN", "FEB", "MAR", "APR", "MAY", "JUNE", "JULY", "AUG", "SEP", "OCT", "NOV", "DEC"};
	private static String[] weekdays = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
	private static final String DATE_PATTERN = "dd/MM/yyyy";
	private static final String DATE_TIME_PATTERN = "dd/MM/yyyy HH:mm:ss EEEE";
	private static GregorianCalendar gc = new GregorianCalendar();
	private static DateFormat df = new SimpleDateFormat(DATE_PATTERN);
	private static DateFormat dtf = new SimpleDateFormat(DATE_TIME_PATTERN);
	
	private DateUtils() {
		
	}
	
	public static boolean isLeapYear(int year) {
		return gc.isLeapYear(year);
	}
	
	public static String getWeekDayAsString(int weekDayAsNumber) {
		return weekdays[weekDayAsNumber - 1];
	}
	
	
	/**
	 * Convert to Date from given text with format dd/MM/yyyy
	 * 
	 * @param date input
	 * @return converted Date
	 */
	
	public static Date toDate(String text) {
		
		if(text == null || text.isEmpty()) {
			throw new IllegalArgumentException();		
		}
		Date date = null;
		try {
			df.parse(text);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	
	
	/**
	 * Convert to Date from given calendar
	 * @param date input
	 * @return converted Calendar
	 */
	public static Date toDate(Calendar c) {
		Objects.requireNonNull(c);
		return c.getTime();
	}
	
	/**
	 * Convert to Calendar from give date
	 * @param date input
	 * @return converted Calendar
	 */

	public static Calendar toCalendar(Date date) {

		Objects.requireNonNull(date);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c;
	}
	
	public static Calendar getCalendar(int year, int month, int day) {
		
		Calendar c = Calendar.getInstance();
		c.set(year, month, day);
		return c;
	}
	/**
	 * Convert to String from give fate with format dd/MM/yyyy HH:mm:ss EEEE
	 * @param date input
	 * @return converted String
	 */
	public static String toString(Date date) {
		Objects.requireNonNull(date);
		return dtf.format(date);
	}
	
}