package java8;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.Year;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

public class Ex04Main {
	private static DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		System.out.println("1. Time now at New York: " + getTimeNewYork());
		System.out.println("2. Days of this month: " + getDaysOfMonth(date));
		System.out.println("3. Last day of this month: " + getLastDayOfMonth(date));
		System.out.println("4. First day and last day of this week :" + getFirstDayAndLastDayThisWeek(date));
		System.out.println("5. Number week of year: " + numberWeekOfYear(date));
		System.out.println("6. Plus 8 hours: " + plusHours(time, 8));
		System.out.println("7. Between of month and year: " + between(LocalDate.of(1990, Month.APRIL, 25), date));
		System.out.println("8. Plus 20 Days: " + plusDays(date, 20));
		System.out.println("9. The back month in year: " + backMonthsInYear(date));
		System.out.println("10. My age: " + calcAge(LocalDate.of(1990, Month.APRIL, 26)));
	}

	private static String calcAge(LocalDate date) {
		Period period = Period.between(date, LocalDate.now());
		return "" + period.getYears() + " years, " + period.minusYears(period.getYears()).getMonths() + " months "
				+ period.minusMonths(period.getMonths()).getDays() + " days";
	}

	private static String backMonthsInYear(LocalDate date) {
		return "" + ((!Year.isLeap(date.getYear()) ? 366 : 365) - date.get(ChronoField.DAY_OF_YEAR));
	}

	private static String plusDays(LocalDate date, int days) {
		date.plusDays(20);
		return date.getDayOfWeek().toString() + " " + df.format(date);
	}

	private static String between(LocalDate start, LocalDate endDateExclusive) {
		Period period = Period.between(start, endDateExclusive);
		return "" + period.getYears() + " years and " + period.minusYears(period.getYears()).getMonths() + " months";
	}

	private static String plusHours(LocalTime time, int hours) {
		return time.plusHours(hours).toString();
	}

	private static String numberWeekOfYear(LocalDate date) {
		return "" + date.get(ChronoField.ALIGNED_WEEK_OF_YEAR);
	}

	private static String getFirstDayAndLastDayThisWeek(LocalDate date) {
		return "" + df.format(date.withDayOfMonth(1)) + " - "
				+ df.format(date.withDayOfMonth(1).plusMonths(1).minusDays(1));
	}

	private static String getLastDayOfMonth(LocalDate date) {
		return df.format(date.withDayOfMonth(1).plusMonths(1).minusDays(1));
	}

	private static String getDaysOfMonth(LocalDate date) {
		return "" + date.withDayOfMonth(1).plusMonths(1).minusDays(1).getDayOfMonth();
	}

	private static LocalTime getTimeNewYork() {
		return LocalTime.now(ZoneId.of("America/New_York"));
	}

}
