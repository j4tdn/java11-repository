package utils;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class DateUtils {
	private DateUtils() {
		
	}
	
	/**
	 * Covert java.sql.Date from given  java.util.LocaDate
	 * @param localDate given date
	 * @return
	 */
	public static java.sql.Date toDate(LocalDate localDate){
		Objects.requireNonNull(localDate,"LocalDate cannot be null");
		return java.sql.Date.valueOf(localDate);
	}	
}
