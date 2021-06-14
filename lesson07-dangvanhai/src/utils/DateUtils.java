package utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class DateUtils {
	private static final String DATE_PATTERN = "dd/MM/yyyy";
	private static final DateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN);
	public static final String[] months = { "JAN", "FEB", "MAR", "APR", "MAY", "JUNE", "JULY", "AUG", "SEP", "OCT",
			"NOV", "DEC" };
	
	private DateUtils() {
	}
	
	public static Date toDate(String text) {
		if(text == null || text.isEmpty()) {
			throw new IllegalArgumentException();
		}
		Date date = null; 
		
		try {
			date =  dateFormat.parse(text);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return date;
	}
	
	public static Calendar toCalendar(String text) {
		if(text == null || text.isEmpty()) {
			throw new IllegalArgumentException();
		}
		Calendar c = Calendar.getInstance();
		c.setTime(toDate(text));
		return c;
	}
	
	public static String getWeekDayAsString(int day) {
		String[] days = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
		return days[day-1];
	}
	
	public static String toString(Date date) {
		Objects.requireNonNull(date);
		return dateFormat.format(date);
	}
	
	public static String toString(Calendar cal) {
		Objects.requireNonNull(cal);
		return dateFormat.format(cal.getTime());
	}
}
