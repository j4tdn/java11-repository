package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

public class DateUtils {
	private static final String PATTERN = "dd/MM/yyyy HH:mm:ss a EEE";
	private static final GregorianCalendar gc = new GregorianCalendar();

	private DateUtils() {

	}

	public static Calendar getDateTime(int year, int month, int day, int hour, int minute, int second) {
		Calendar c = Calendar.getInstance();
		c.set(year, month, day, hour, minute, second);
		return c;
	}

	public static Calendar getDate(int year, int month, int day) {
		Calendar c = Calendar.getInstance();
		c.set(year, month, day);
		return c;
	}

	public static boolean isLeapYear(int year) {
		return gc.isLeapYear(year);
	}

	/**
	 * Convert Calendar to formated string with dd/MM/yyyy pattern
	 * 
	 * @param c given calendar
	 * @return formated calendar as string
	 */
	public static String format(Calendar c) {
		Objects.requireNonNull(c);

		DateFormat df = new SimpleDateFormat(PATTERN);
		return df.format(c.getTime());
	}
	
	/*
	 * Convert string to date with dd/MM/yyy pattern
	 * 
	 * @param s given string
	 * return Date type
	 */
	public static Date to(String s) {
		Objects.requireNonNull(s);
		DateFormat df = new SimpleDateFormat(PATTERN);
		
		Date date = null;
		try {
			date = df.parse(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/*
	 * Convert date to calendar
	 * 
	 * @param date given date
	 * return Calendar type
	 */
	public static Calendar to(Date date) {
		Objects.requireNonNull(date);
		Calendar c =  Calendar.getInstance();
		c.setTime(date);
		return c;
	}
}
