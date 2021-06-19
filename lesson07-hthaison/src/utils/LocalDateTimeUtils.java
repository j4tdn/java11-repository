package utils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class LocalDateTimeUtils {
	
	private static final String DATE_PATTERN = "dd/MM/yyyy KK:mm:ss a EEEE";
	private static final String DATE_PATTERN_DAY = "dd/MM/yyyy EEEE";
	private static final String DATE_PATTERN_TIME = "KK:mm::ss a EEEE";
	
	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern(DATE_PATTERN);
	private static DateTimeFormatter df = DateTimeFormatter.ofPattern(DATE_PATTERN_DAY);
	private static DateTimeFormatter tf = DateTimeFormatter.ofPattern(DATE_PATTERN_TIME);
	
	public LocalDateTimeUtils() {
		// TODO Auto-generated constructor stub
	}
	public static String toString(LocalDateTime datetime) {
		return dtf.format(datetime);
	}
	public static String toString(LocalDate date) {
		return df.format(date);
	}
	public static String toString(LocalTime time) {
		return tf.format(time);
	}
	public static LocalDate[] getAllWeekdayInYear(int year, DayOfWeek weekday) {
		LocalDate[] arrDate = new LocalDate[100];
		LocalDate dayfirst = LocalDate.of(year, Month.JANUARY, 1);
		LocalDate dayEnd = LocalDate.of(year, 12, 31);
		int i = 0;
		while(!dayEnd.isBefore(dayfirst)) {
			if(dayfirst.getDayOfWeek() == weekday) {
				arrDate[i++] = dayfirst;
				dayEnd = dayfirst.plusDays(7);
			}
			else {
				dayfirst = dayfirst.plusDays(1);
			}
		}
		return Arrays.copyOfRange(arrDate, 0, i);
	}
	public static void allWeekday(int year, DayOfWeek weekday) {
		LocalDate[] arrDate = getAllWeekdayInYear(year, weekday);
		for(int i = 0; i < arrDate.length; i++) {
			System.out.println(toString(arrDate[i]));
		}
	}
	public static LocalDate getLastWeekday(int year, DayOfWeek weekday) {
		LocalDate[] arrdate = getAllWeekdayInYear(year, weekday);
		return arrdate[arrdate.length - 1];
	}
}
