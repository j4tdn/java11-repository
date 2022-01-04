package utils;

import java.time.LocalDate;
import java.util.Objects;

public class DateUtils {
	public DateUtils() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * convert to java.sql.date from given java.util.LocalDate
	 * @param locaDate
	 * @return
	 */
	public static java.sql.Date toDate(LocalDate locaDate){
		Objects.requireNonNull(locaDate,"LocalDate cannot be null");
		return java.sql.Date.valueOf(locaDate);
	}
}