package utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

public class DateUtils {
	private static final String PATTERN = "dd/MMM/YYYY KK:mm:ss a EEEE";
	private static final GregorianCalendar gc = new GregorianCalendar();

	private DateUtils() {
		// TODO Auto-generated constructor stub
	}

	public static Calendar getdatetime(int year, int month, int day, int hours, int minutes, int second) {
		Calendar c = Calendar.getInstance();
		c.set(year, month, day, hours, minutes, second);
		return c;
	}

	public static Calendar getdatetime(int year, int month, int day) {
		Calendar c = Calendar.getInstance();
		c.set(year, month, day);
		return c;
	}

	public static boolean isLeapYear(int year) {
		return gc.isLeapYear(year);
	}

	/**
	 * Convert calendar to formatted string with dd/MM/yyyy pattern.
	 * 
	 * @param c given calendar
	 * @return formatted calendar as string
	 */

	public static String format(Calendar c) {
		Objects.requireNonNull(c);
		DateFormat df = new SimpleDateFormat(PATTERN);
		return df.format(c.getTime());

	}

	/**
	 * Convert string to date with dd/MMM/YYYY KK:mm:ss a EEEE
	 * 
	 * @param s given string
	 * @return Date type
	 */
	public static Date toDate(String s) {
		Objects.requireNonNull(s);
		DateFormat df = new SimpleDateFormat(PATTERN);
		Date date = null;
		try {
			date = df.parse(s);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * Convert date to calendar
	 * 
	 * @param date given date
	 * @return Calendar type
	 */
	public static Calendar to(Date date) {
		Objects.requireNonNull(date);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c;
	}
}
