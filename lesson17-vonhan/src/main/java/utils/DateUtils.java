package utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class DateUtils {
	private DateUtils() {
	}
	
	/**
	 * Convert to java.sql.Date from java.util.LocalDate
	 * @param localDate
	 * @return
	 */
	public static java.sql.Date toDate(LocalDate localDate) {
		Objects.requireNonNull(localDate, "LocalDate cannot be null");
		return java.sql.Date.valueOf(localDate);
	}
	
	public static LocalTime toTime(java.sql.Time time) {
		Objects.requireNonNull(time, "LocalTime cannot be null");
		return time.toLocalTime();
	}
}
