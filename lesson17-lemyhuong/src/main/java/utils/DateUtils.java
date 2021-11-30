package utils;

import java.time.LocalDate;
import java.util.Objects;

public class DateUtils {
	public DateUtils() {
	}
	
	public static java.sql.Date toDate(LocalDate localDate){
		Objects.requireNonNull(localDate, "LocalDate cannot be null");
		return java.sql.Date.valueOf(localDate);
	}
}
