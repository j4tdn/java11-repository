package utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

public class DateUtils {
	
	private static final String DATE_PATTERN = "dd/MM/yyyy";
	private static final String DATE_TIME_PATTERN = "dd/MM/yyyy HH:mm:ss EEEE";
	String[] months = {"JAN","FEB", "MAR","APR","MAY"};
	private static String[] weekday = {"SUN","MON","TUE","WED","THUR","FRI","SAT"};
	private static GregorianCalendar gc = new GregorianCalendar();
	private static DateFormat df = new SimpleDateFormat(DATE_PATTERN);
	private static DateFormat dft = new SimpleDateFormat(DATE_TIME_PATTERN);
	private DateUtils() {
		
	}
	
	public static String getWeekDayAsString (int weekDayAsNumber) {
		// 1 - 7
		// SUN - SAT
		// index[0] - index[6]
		return weekday[weekDayAsNumber - 1];
	}
	
	
	public static boolean isLeapYear(int year) {
		return gc.isLeapYear(year);
		
	}
	
	/**
	 * Convert to Date from given text with format dd/MM/yyyy
	 * @param text input
	 * @return convert Date
	 */
	public static Date toDate(String text) {
		if(text  == null  ||  text.isEmpty()) {
			throw new IllegalArgumentException();
		}
		Date date = null;
		try {
			date = df.parse(text);
		}catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
		
	}

	/**
	 * Convert to Date from given Calendar 
	 * E.g : 10.10.1990 >> Epoch time : 01.01.1970 >> Date Calendar
	 * @param Calendar input
	 * @return	convert Date
	 */
	
	public static Date toDate(Calendar c) {
		Objects.requireNonNull(c);
		return c.getTime();
	}
	
	
	/**
	 * Convert to Calendar from given date 
	 * @param date input
	 * @return	convert Calendar
	 */
	public static Calendar toCalendar(Date date) {
		Objects.requireNonNull(date);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		
		return c;
	}
	public static Calendar getCalendar(int year, int mont, int day) {
		Calendar c = Calendar.getInstance();
		c.setTime();
		return c;
	}
	/**
	 * Convert to String  from given date with  format dd/MM/yyyy HH:mm:ss EEEE
	 * @param date input
	 * @return	convert String
	 */
	public static String toString(Date date) {
		Objects.requireNonNull(date);
		return  dft.format(date);
	}
}
