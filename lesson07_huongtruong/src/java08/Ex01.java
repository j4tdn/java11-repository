package java08;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Ex01 {
	private static DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	public static void main(String[] args) {
		getAllSundayInYear(2020);
		getLastSunday(2020);
	}

	private static void getAllSundayInYear(int year) {
		LocalDate now = LocalDate.of(year, Month.JANUARY, 1);
		LocalDate sunday = now.with(DayOfWeek.SUNDAY);
		System.out.println("List all Sunday of the year:");
		do {
			System.out.println(sunday.format(df));
			sunday = sunday.plus(Period.ofDays(7));
		} while (sunday.getYear() == year);
	}

	private static void getLastSunday(int year) {
		LocalDate lastSunday = LocalDate.of(year, Month.DECEMBER, 31);
		do {
			lastSunday=lastSunday.minusDays(1);
		}while(lastSunday.getDayOfWeek()!=DayOfWeek.SUNDAY);
		System.out.println("the last Sunday of the year is " + lastSunday.format(df));

	}
}