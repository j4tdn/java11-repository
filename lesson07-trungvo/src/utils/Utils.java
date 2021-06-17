package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class Utils {
	private static final String DATE_TIME_PATTERN = "dd/MM/yyyy";
	private static DateFormat dft = new SimpleDateFormat(DATE_TIME_PATTERN);
	private static String[] weekdays = {"SUN","MON", "TUE","WED","THU","FRI","SAT" };
	
	public Utils() {
	}
	
	public static String toString(Date date) {
		Objects.requireNonNull(date);
		return dft.format(date);
	}
	
	public static String getWeekdayAsString(int weekDayAsNumber) {
		return weekdays[weekDayAsNumber -1];
	}

}
