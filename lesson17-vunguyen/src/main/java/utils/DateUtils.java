package utils;

import java.time.LocalDate;
import java.util.Objects;

public class DateUtils {
    private DateUtils() {
        // util date
        // sql date
    }


    /**
     * Convert to java.sql.Date from given java.util.LocalDate
     *
     * @param localDate the local date
     */
    public static java.sql.Date toDate(LocalDate localDate) {
        Objects.requireNonNull(localDate, "LocalDate cannot be null");
        return java.sql.Date.valueOf(localDate);
    }

    public static LocalDate toLocalDate(java.sql.Date date) {
        Objects.requireNonNull(date, "Date cannot be null");
        return date.toLocalDate();
    }

    public static LocalDate toLocalDate(String dateString) {
        String[] dateStringTokens = dateString.split("-");
        return LocalDate.of(Integer.parseInt(dateStringTokens[0]), Integer.parseInt(dateStringTokens[1]), Integer.parseInt(dateStringTokens[2]));
    }
}
