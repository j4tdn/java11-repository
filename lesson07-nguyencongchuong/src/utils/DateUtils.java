package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class DateUtils {
	
	private static final String DATE_PATTERN = "dd/MM/yyyy EEE";
	private static DateFormat dft = new SimpleDateFormat(DATE_PATTERN);
	private DateUtils() {
	}
	
	public static Calendar getCalendar(int year, int month, int day) {
		Calendar c = Calendar.getInstance();
		c.set(year, month, day);
		return c;
	}
	
	public static String toString(Date date) {
		Objects.requireNonNull(date);
		return dft.format(date);
	}
}
