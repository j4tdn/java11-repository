package utils;

import java.time.LocalDate;
import java.util.Objects;

public class DateUtils {
	private DateUtils() {
		// util date
		// sql date
	}
	
	/**
	 * Convert to java.sql.Date from give java.util.LocalDate
	 * @param localDate
	 * @return java.sql.Date
	 */
	public static java.sql.Date toDate(LocalDate localDate) {
		Objects.requireNonNull(localDate, "LocalDate cannot be null");
		return java.sql.Date.valueOf(localDate);
	}
}
