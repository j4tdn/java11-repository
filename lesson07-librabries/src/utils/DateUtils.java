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
	private static final String DATE_TIME_PATTERN = "dd/MM/yyy HH:mm:ss EEEE";
	private static String[] weekdays = { "SUN", "MON", "TUE", "WED", "THUR", "PRI", "SAT" };
	private static GregorianCalendar gc = new GregorianCalendar();
	private static DateFormat df = new SimpleDateFormat(DATE_PATTERN);
	private static DateFormat dft = new SimpleDateFormat(DATE_TIME_PATTERN);
	
	private DateUtils() {
	}

	public static boolean isLeapYear(int year) {
		return gc.isLeapYear(year);
	}

	public static String getWeekDayAsString(int weekDayAsNumber) {
		// 1 - 7
		// SUN - SAT
		// i0 - 6
		return weekdays[weekDayAsNumber - 1];
	}

	/**
	 * Convert to Date from given text with format dd/MM/yyyy
	 * 
	 * @param text
	 * @return
	 */
	public static Date toDate(String text) {
		if (text == null || text.isEmpty()) {
			throw new IllegalArgumentException();
		}

		Date date = null;
		try {
			date = df.parse(text);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * Convert to date from give calendar.
	 * e.g: 10.10.1990 >> Epoch time >> 01.01.1970 >> Date Calendar
	 * 
	 * @param today
	 * @return converter Calendar
	 */
	public static Date toDate(Calendar c) {
		Objects.requireNonNull(c);
		return c.getTime();
	}

	/**
	 * Convert to Calendar from give date.
	 * e.g: 10.10.1990 >> Epoch time >> 01.01.1970 >> Date Calendar
	 * 
	 * @param today
	 * @return converter Calendar
	 */
	public static Calendar toCalendar(Date date) {
		Objects.requireNonNull(date);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c;
	}
		/**
		 * Get calendar from given year, month, day
		 * @param year given year
		 * @param month given month 
		 * @param day given day
		 * @return calendar
		 */
	public static Calendar getCalendar(int year, int month, int day) {
		Calendar c = Calendar.getInstance();
		c.set(year, month, day);
		return c;
	}
	
	/**
	 * Convert to String from give date with format dd/MM/yyy HH:mm:ss EEEE
	 * @param date input
	 * @return converted String
	 */
	public static String toString(Date date) {
		Objects.requireNonNull(date);
		return dft.format(date);
	}
}
