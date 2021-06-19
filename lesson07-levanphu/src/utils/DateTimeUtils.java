package utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class DateTimeUtils {
	private static final String DATE_TIME_PATTERN = "dd/MM/yyyy EEEE ";
	private static final String DATE_PATTERN = "dd/MM/yyyy EEEE HH:mm:ss a";
	private static GregorianCalendar gc = new GregorianCalendar();
	private static DateFormat dft = new SimpleDateFormat(DATE_TIME_PATTERN);
	private static DateFormat df = new SimpleDateFormat(DATE_PATTERN);
	private static String[] weekdays = { "SUN", "MON", "TUE", "WEB", "THUR", "FRI", "SAT" };
	private static String[] months = { "JAN", "FEB", "MAR", "APR", "MAY", "JUNE", "JULY", "AUG", "SEP", "OCT",
			"NOV", "DEC" };
	public DateTimeUtils() {
	}
	
	public static String toString(Date date) {
		Objects.requireNonNull(date);
		return dft.format(date);
	}
	public static Date toDate(Calendar c) {
		Objects.requireNonNull(c);
		return c.getTime();
	}

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
	public static String getWeekDayAsString(int day ) {
		return weekdays[day - 1];
	}
	public static String getMonthAsString(int month ) {
		return months[month];
	}
	public static Calendar toCalendar(Date date) {
		Objects.requireNonNull(date);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c;
	}		
	}



	
}
