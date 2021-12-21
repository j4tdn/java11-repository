package utils;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

public class DateUtils {
	private DateUtils() {

	}

	public static Date toSqlDate(LocalDate orderDate) {
		Objects.requireNonNull(orderDate, "LocalDate cannot be null");
		return Date.valueOf(orderDate);
	}
}
