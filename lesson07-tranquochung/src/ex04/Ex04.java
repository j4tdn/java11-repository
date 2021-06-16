package ex04;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.Objects;

public class Ex04 {
	public static void main(String[] args) {
		// Date time New York
		String zoneIdNewYork = "America/New_York";
		LocalDateTime datetimeNY = LocalDateTime.now(ZoneId.of(zoneIdNewYork));
		System.out.println("datetime New York now: " + datetimeNY);

		// Days of month
		LocalDate date = LocalDate.now();
		System.out.println("day of month: " + date.lengthOfMonth());

		// 3
		System.out.println("=========================");
		System.out.println("last day of month: " + date.of(date.getYear(), date.getMonth(), date.lengthOfMonth()));

		// 4
		System.out.println("=========================");

		// 5
		System.out.println("=========================");

		// 6
		System.out.println("=========================");
		LocalTime time = LocalTime.now();
		System.out.println("Add 8 hours: " + time.plusHours(8));

		// 7
		System.out.println("=========================");
		LocalDateTime dayStart = LocalDateTime.of(2020, 6, 16, 0, 0);
		LocalDateTime dayEnd = LocalDateTime.now();
		System.out.println(between(dayStart, dayEnd));

		// 8
		System.out.println("=========================");
		System.out.println("Add 20 Days: " + date.plusDays(20));

		// 9
		System.out.println("=========================");
		int numMonth = 12 - date.getMonthValue();
		System.out.println("remaining months: " + numMonth);

		// 10
		LocalDateTime born = LocalDateTime.of(1999, 07, 20, 0, 0, 0);
		LocalDateTime live = LocalDateTime.now();
		System.out.println("Age of you is: " + between(born, live));
	}

	private static String between(LocalDateTime dtStart, LocalDateTime dtEnd) {
		Objects.requireNonNull(dtStart);
		Objects.requireNonNull(dtEnd);

		if (dtStart.isAfter(dtEnd)) {
			throw new IllegalArgumentException("StartDate cannot exceed EndDate !!!");
		}

		LocalDate dateStart = dtStart.toLocalDate();
		LocalDate dateEnd = dtEnd.toLocalDate();

		LocalTime timeStart = dtStart.toLocalTime();
		LocalTime timeEnd = dtEnd.toLocalTime();

		Period period = Period.between(dateStart, dateEnd);
		Duration duration = Duration.between(dtStart, dtEnd);

		if (timeEnd.isBefore(timeStart)) {
			duration = duration.plusDays(1);
			period = period.minusDays(1);
		}

		return period.getYears() + " Y " + period.getMonths() + " M " + period.getDays() + " D "
				+ duration.toHoursPart() + " h " + duration.toMinutesPart() + " m " + duration.toSecondsPart() + " s";

	}

}
