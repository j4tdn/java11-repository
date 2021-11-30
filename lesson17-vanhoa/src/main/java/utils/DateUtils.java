package utils;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class DateUtils {
	
	private DateUtils() {
	}
	/**
	 * Covert to java.sql.Date from give java.util.LocalDate
	 * 
	 * @param localDate given date
	 */
	public static java.sql.Date toDate(LocalDate localDate){
		Objects.requireNonNull(localDate, "LocalDate cannot be null");
		return java.sql.Date.valueOf(localDate);
	}
	public static LocalTime toTime(java.sql.Time localTime){
		Objects.requireNonNull(localTime, "LocalTime cannot be null");
		
		return LocalTime.of(localTime.getHours(), localTime.getMinutes(), localTime.getSeconds());
		
	}
}
