package utils;

import java.util.GregorianCalendar;

public class DateUtils {
	private int a;
	private int b;
	private static GregorianCalendar gc = new GregorianCalendar();
	
	private DateUtils() {
		
	}
	public static boolean isLeapYear(int year) {
		return gc.isLeapYear(year);
	}
}
