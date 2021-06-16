package bt02;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Bt02 {

	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy':'KK:mm:ss a");

	public static void main(String[] args) {

		LocalDateTime dtStart = LocalDateTime.of(2020, 1, 12, 16, 24, 10);
		System.out.println("DatingStart: " + dtf.format(dtStart));
		LocalDateTime dtEnd = LocalDateTime.of(2021, 6, 7, 8, 42, 30);
		System.out.println("DatingEnd: " + dtf.format(dtEnd));

		String duration = timeLove(dtStart, dtEnd);
		System.out.println("DurationDating: " + duration);

	}

	private static String timeLove(LocalDateTime dtStart, LocalDateTime dtEnd) {
		Objects.requireNonNull(dtStart);
		Objects.requireNonNull(dtEnd);

		if (dtStart.isAfter(dtEnd)) {
			throw new IllegalArgumentException("StartDate cannot exceed EndDate");
		}
		LocalDate dateStart = dtStart.toLocalDate();
		LocalDate dateEnd = dtEnd.toLocalDate();

		LocalTime timeStart = dtStart.toLocalTime();
		LocalTime timeEnd = dtEnd.toLocalTime();

		Period period = Period.between(dateStart, dateEnd);
		Duration duration = Duration.between(timeStart, timeEnd);

		if (timeEnd.isBefore(timeStart)) {
			duration = duration.plusDays(1);
			period = period.minusDays(1);
		}

		return period.toString() + '-' + duration.toString();
	}
}