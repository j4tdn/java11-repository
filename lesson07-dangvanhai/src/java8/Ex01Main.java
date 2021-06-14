package java8;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class Ex01Main {
	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public static void main(String[] args) {
		// All Sundays in year
		LocalDate[] sundays = getAllSundaysInYear(2021);
		System.out.println("-- All sundays of 2021 --");
		for (LocalDate sun : sundays) {
			System.out.println(dtf.format(sun));
		}

		// Last Sunday in year
		LocalDate lastSunday = getLastSunday(2021);
		System.out.println("\n-- Last sunday of 2021 --");
		System.out.println(dtf.format(lastSunday));

	}

	private static LocalDate[] getAllSundaysInYear(int year) {
		LocalDate date = LocalDate.of(year, Month.JANUARY, 1);
		LocalDate exclusiveDate = LocalDate.of(year + 1, Month.JANUARY, 1);
		LocalDate[] days = new LocalDate[365];
		int count = 0;
		while (date.isBefore(exclusiveDate)) {
			if (date.getDayOfWeek() == DayOfWeek.SUNDAY) {
				days[count++] = date;
				date = date.plusDays(7);
			} else {
				date = date.plusDays(1);
			}
		}

		LocalDate[] result = new LocalDate[count];
		for (int i = 0; i < result.length; i++) {
			result[i] = days[i];
		}
		return result;
	}

	private static LocalDate getLastSunday(int year) {
		LocalDate date = LocalDate.of(year + 1, Month.JANUARY, 1);
		date = date.minusDays(1);
		while (true) {
			if (date.getDayOfWeek() == DayOfWeek.SUNDAY) {
				break;
			}
			date = date.minusDays(1);
		}
		return date;
	}
}
