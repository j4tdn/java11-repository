package utils;

import java.time.LocalDate;
import java.util.Objects;

public class DateUtils {
	private DateUtils() {
		// utils date
		// sql date
	}
	
	/**
	 * Convert to java.sql.Date from given java.util.LocalDate
	 * 
	 * 
	 * @param localDate
	 * 
	 */
	public static java.sql.Date toDate(LocalDate localDate){
		Objects.requireNonNull(localDate,"LocalDate cannot be null");
		return java.sql.Date.valueOf(localDate);
	}

}
