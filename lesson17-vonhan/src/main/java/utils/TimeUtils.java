package utils;

import java.time.LocalTime;
import java.util.Objects;

public class TimeUtils {
	private TimeUtils() {
	}
	
	public static java.sql.Time toTime(LocalTime localTime) {
		Objects.requireNonNull(localTime, "LocalTime cannot be null");
		return java.sql.Time.valueOf(localTime);
	}
}
