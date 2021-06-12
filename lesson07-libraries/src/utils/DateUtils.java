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
	private static String[] months = { "JAN", "FEB", "MAR", "APR", "MAY", "JUNE", "JULY", "AUG", "SEP", "OCT", "NOV",
			"DEC" };
	private static String[] weekdays = { "SUN", "MON", "TUE", "WED", "THUR", "FRI", "SAT" };

	private static GregorianCalendar gc = new GregorianCalendar();
	private static DateFormat df = new SimpleDateFormat(DATE_PATTERN);
	private static DateFormat dtf = new SimpleDateFormat(DATE_TIME_PATTERN);

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
	 * @param text input
	 * @return converted Date
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
	 * Conver to Date from given calendar. E.g: 10.10.1990 >> Epoch time. 01.01.1970
	 * >> Calendar Date
	 * 
	 * @param c input
	 * @return converted Date
	 */
	public static Date toDate(Calendar c) {
		Objects.requireNonNull(c);
		return c.getTime();
	}

	/**
	 * Conver to Calendar from given date. E.g: 10.10.1990 >> Epoch time. 01.01.1970
	 * >> Date Calendar
	 * 
	 * @param date input
	 * @return converted Calendar
	 */
	public static Calendar toCaledar(Date date) {
		Objects.requireNonNull(date);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c;
	}

	/**
	 * Get calendar from given year, month, day.
	 * 
	 * @param year given year
	 * @param month given month
	 * @param day given day
	 * @return
	 */
	public static Calendar toCalendar(int year, int month, int day) {
		Calendar c = Calendar.getInstance();
		c.set(year, month, day);
		return c;
	}

	/**
	 * Convert to String from given date with format dd/MM/yyyy HH:mm:ss EEEE
	 * 
	 * @param date input
	 * @return converted String
	 */
	public static String toString(Date date) {
		Objects.requireNonNull(date);
		return dtf.format(date);
	}
}
