package utils;

import java.time.LocalDate;
import java.util.Objects;

public class DateUtils {

	private DateUtils() {

	}

	/**
	 * converr to java.sql.Date from given java.utils.LocalDate
	 * @param localDate
	 * @return
	 */
	public static java.sql.Date toDate(LocalDate localDate) {
		Objects.requireNonNull(localDate, "LocalDate cannot be null");
		return java.sql.Date.valueOf(localDate);
	}

}
