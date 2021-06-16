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
	private static String[] weekdays = { "SUN", "MON", "TUE", "WED", "THUR", "FRI", "SAT" };

	private static GregorianCalendar gc = new GregorianCalendar();
	private static DateFormat df = new SimpleDateFormat(DATE_PATTERN);
	private static DateFormat dtf = new SimpleDateFormat(DATE_TIME_PATTERN);

	private DateUtils() {

	}

	public static boolean isLeapYear(int year) {
		return gc.isLeapYear(year);
	}

	public static String getWeekDayAssString(int weekDateAsNumber) {
		// 1-7
		// sun-sat
		// i0-i6
		return weekdays[weekDateAsNumber - 1];
	}

	/**
	 * convert to Date form given text with format dd/MM/yyyy
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
	 * convert to Calendar from give Calendar e.g: 10.10.1990 >> epoch time.
	 * 1.1.1970 >>date calendar
	 * 
	 * @param date input
	 * @return converted Calendar
	 */
	public static Date toDate(Calendar c) {
		Objects.requireNonNull(c);
		return c.getTime();
	}

	/**
	 * convert to Calendar from give date e.g: 10.10.1990 >> epoch time. 1.1.1970 >>
	 * date calendar
	 * 
	 * @param date input
	 * @return converted Calendar
	 */
	public static Calendar toCalendar(Date date) {
		Objects.requireNonNull(date);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c;
	}

	/**
	 * 
	 * @param Calendar form give year,month,day
	 * @param given    year
	 * @param given    month
	 * @param given    day
	 * @return
	 */
	public static Calendar getCalendar(int year, int month, int day) {
		Calendar c = Calendar.getInstance();
		c.set(year, month, day);
		return c;
	}

	/**
	 * Convert to String from give date with format dd/MM/yyyy HH:mm:ss EEEE
	 * 
	 * @param date input
	 * @return converted String
	 */
	public static String toString(Date date) {
		Objects.requireNonNull(date);
		return dtf.format(date);
	}
}