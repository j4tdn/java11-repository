package utils;

import java.util.GregorianCalendar;

public class DateUtils {

	private static GregorianCalendar gc = new GregorianCalendar();

	public DateUtils() {

	}

	public static boolean isLeapYear(int year) {
		return gc.isLeapYear(year);
	}
}
