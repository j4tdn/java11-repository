package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

public class DateUtils {
	private static final String ddMMyyyy = "dd/MM/yyyy";
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
	 * @returnformated calendar as string
	 */
	public static String format(Calendar c) {
		Objects.requireNonNull(c);
		
		DateFormat df = new SimpleDateFormat(ddMMyyyy);
	return df.format(c.getTime());
	}
}
