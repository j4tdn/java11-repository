package util;

import java.time.LocalDate;
import java.util.Objects;

public class DateUtils {

	private DateUtils() {
	}
	
	public static java.sql.Date toDate(LocalDate localDate){
		Objects.requireNonNull(localDate, "LocalDate cannot be null");
		return java.sql.Date.valueOf(localDate);
	}
}
