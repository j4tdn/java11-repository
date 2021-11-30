package utils;

import java.time.LocalDate;
import java.util.Objects;

public class DateUtils {
	private DateUtils() {
		
	}
	
	/**
	 *  Convert to sql from given util
	 * @param localDate
	 * @return
	 */
	
	public static java.sql.Date toDate(LocalDate localDate) {
		Objects.requireNonNull(localDate, "LocalDate cannot be null");
		return java.sql.Date.valueOf(localDate);
	}
	
}
