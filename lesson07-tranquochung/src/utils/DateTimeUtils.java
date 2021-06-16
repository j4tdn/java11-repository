package utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class DateTimeUtils {
	private static String[] weekdays = { "Sun", "Mon", " Tue", "Wed", "Thur", "Fri", "Sat" };
	private static final String DATE_PATTERN = "dd/MM/yyyy";
	private static DateFormat df = new SimpleDateFormat(DATE_PATTERN);

	/**
	 * convert to String from given Date
	 * 
	 * @param date
	 * @return String
	 */
	public static String toString(Date date) {
		Objects.requireNonNull(date);
		return df.format(date);
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

	public static Calendar toCalendar(Date date) {
		Objects.requireNonNull(date);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c;
	}

	public static String getWeekDayAsString(int weekDayAsNumber) {
		return weekdays[weekDayAsNumber - 1];
	}
}
