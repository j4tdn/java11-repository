package java8;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Ex03Main {
	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public static void main(String[] args) {
		System.out.println("Enter date:(dd/MM/yyyy) ");
		Scanner scanner = new Scanner(System.in);
		String text = scanner.nextLine();
		while (!validateDateInput(text)) {
			System.out.println("Enter again: ");
			text = scanner.nextLine();
		}
		scanner.close();
		LocalDate date = LocalDate.parse(text, dtf);
		WeekdayCalculator(date);
	}

	private static void WeekdayCalculator(LocalDate date) {
		System.out.println(showdateInfo(date));
		System.out.println("- " + dayNumberInYear(date));
		System.out.println("- " + weekDayOfYear(date));
		System.out.println("- " + weekDayOfYearInMonth(date));
		System.out.println("- " + daysOfYear(date));
		System.out.println("- " + daysOfMonth(date));
	}

	private static String weekDayOfYearInMonth(LocalDate date) {
		String result = "It is " + date.getDayOfWeek().toString().substring(0, 1)
				+ date.getDayOfWeek().toString().substring(1).toLowerCase() + " number ";
		LocalDate tmp = date.withDayOfMonth(1);
		int count = 0;
		while (tmp.getDayOfWeek() != date.getDayOfWeek()) {
			tmp = tmp.plusDays(1);
		}
		while (!tmp.isAfter(date)) {
			count++;
			tmp = tmp.plusDays(7);
		}
		result += count + " out of ";
		while (!tmp.isAfter(date.plusMonths(1).withDayOfMonth(1).minusDays(1))) {
			count++;
			tmp = tmp.plusDays(7);
		}
		result += count + " in " + toString(date.getMonth()) + date.getYear();
		return result;
	}

	private static String showdateInfo(LocalDate date) {

		return "" + date.getDayOfMonth() + " "
				+ date.getMonth().toString().toLowerCase().replaceFirst("^\\w{1}",
						date.getMonth().toString().substring(0, 1))
				+ " " + date.getYear() + " is a " + date.getDayOfWeek().toString().toLowerCase().replaceFirst("\\w{1}",
						date.getDayOfWeek().toString().substring(0, 1));
	}

	private static String daysOfMonth(LocalDate date) {
		return ""
				+ date.getMonth().toString().toLowerCase().replaceFirst("^\\w{1}",
						date.getMonth().toString().substring(0, 1))
				+ " " + date.getYear() + " has " + date.withDayOfMonth(1).plusMonths(1).minusDays(1).getDayOfMonth()
				+ " days";
	}

	private static String daysOfYear(LocalDate date) {
		return "Year " + date.getYear() + " has " + (Year.isLeap(date.getYear()) ? 366 : 365) + " days";
	}

	private static String dayNumberInYear(LocalDate date) {
		return "It is day number " + date.getDayOfYear() + " of the year, "
				+ ChronoUnit.DAYS.between(date, LocalDate.of(date.getYear() + 1, Month.JANUARY, 1).minusDays(1))
				+ " days left";
	}

	private static String weekDayOfYear(LocalDate date) {
		String result = "It is " + toString(date.getDayOfWeek());
		result += " number ";
		LocalDate tmp = LocalDate.of(date.getYear(), Month.JANUARY, 1);
		while (tmp.getDayOfWeek() != date.getDayOfWeek()) {
			tmp = tmp.plusDays(1);
		}
		int count = 0;
		while (!tmp.isAfter(date)) {
			count++;
			tmp = tmp.plusDays(7);
		}
		result += count;

		while (!tmp.isAfter(LocalDate.of(date.getYear() + 1, Month.JANUARY, 1).minusDays(1))) {
			count++;
			tmp = tmp.plusDays(7);
		}
		result += " out of " + count + " in " + date.getYear();
		return result;
	}

	private static String toString(Month month) {
		return month.toString().substring(0, 1) + month.toString().substring(1).toLowerCase();
	}

	private static String toString(DayOfWeek day) {
		return day.toString().substring(0, 1) + day.toString().substring(1).toLowerCase();
	}

	private static boolean validateDateInput(String text) {
		try {
			LocalDate.parse(text, dtf);
		} catch (DateTimeParseException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
