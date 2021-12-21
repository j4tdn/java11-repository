package utils;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

public class DateUtils {
	private DateUtils() {
	}
	
	public static Date toDate(LocalDate date) {
		Objects.requireNonNull(date, "LocalDate cannot be null");
		return Date.valueOf(date);
	}
}
