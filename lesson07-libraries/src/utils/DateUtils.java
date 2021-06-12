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
	private static String[] months = { "JAN", "FEB", "FEB", "MAR", "APR", "MAY", "JUNE", "JULY", "AUG", "SEP", "OCT",
			"NOV", "DEC" };
	private static String[] weekdays = { "SUN", "MON", "TUE", "WEB", "THUR", "FRI", "SAT" };
	private static DateFormat df = new SimpleDateFormat(DATE_PATTERN);
	private static DateFormat dtf = new SimpleDateFormat(DATE_TIME_PATTERN);
	private static GregorianCalendar gc = new GregorianCalendar();

	private DateUtils() {
	}

	public static boolean isLeapYear(int year) {
		return gc.isLeapYear(year);
	}

	public static String getWeekDayAsString(int weekDayAsNumber) {
		// 1 - 7
		//
		//
		return weekdays[weekDayAsNumber - 1];
	}

	public static Date toDate(Calendar c) {
		Objects.requireNonNull(c);
		return c.getTime();
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * Convert to Calendar from given date E.g: 10.10.1990 >> Epoch time. 01.01.1970
	 * >> Date Calendar
	 * 
	 * @param date
	 * @return converted Calendar
	 */
	public static Calendar toCalendar(Date date) {
		Objects.requireNonNull(date);
		Calendar c = Calendar.getInstance();
		// long dateInMillis = date.getTime();
		// c.setTimeInMillis(dateInMillis);
		c.setTime(date);
		return c;
	}

	/**
	 * Get calendar from given year, month, day
	 * 
	 * @param year
	 * @param month
	 * @param day
	 * @return calendar
	 */
	public static Calendar setCalendar(int year, int month, int day) {
		Calendar c = Calendar.getInstance();
		c.set(year, month, day);
		return c;
	}

	/**
	 * Convert to String from given date with format dd/MM/yyyy HH:mm:ss EEEE
	 * 
	 * @param date
	 * @return
	 */
	public static String toString(Date date) {
		Objects.requireNonNull(date);
		return dtf.format(date);
	}
}