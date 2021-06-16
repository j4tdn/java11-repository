package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class LocalDateTimeUtils {
	private static String localizedKey = "dd.MM.yyyy KK:mm:ss a";
	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern(localizedKey);
	
	private LocalDateTimeUtils() {
	}

	public static String toString(LocalDateTime localDateTime) {
		Objects.requireNonNull(localDateTime);
		return dtf.format(localDateTime);
	}
}
