package utils;

import java.time.LocalDate;
import java.util.Objects;

public class DateUtils {
 public DateUtils() {
 
 }
  /**
   * convert to java.sql.date from give java.util.LocalDate
   * @param localDate
   * @return
   */
 public static java.sql.Date toDate(LocalDate localDate) {
	Objects.requireNonNull(localDate, "LocalDate cannot be null");
	return java.sql.Date.valueOf(localDate);
 }
}
