package java8;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Objects;
import java.util.Scanner;

public class Ex02Main {
	private static Scanner scanner = new Scanner(System.in);
	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

	public static void main(String[] args) {
		theUltimateRelationshipCalculator();
	}

	private static void theUltimateRelationshipCalculator() {

		// Date Time Start
		System.out.println("time start: (dd/MM/yyyy HH:mm:ss)");
		String text = getDateTimeInput();
		LocalDateTime dateTimeStart = LocalDateTime.parse(text, dtf);

		// Date Time End
		System.out.println("Have you broken up yet? (yes/no)");
		text = scanner.nextLine();
		while (!text.equals("yes") && !text.equals("no")) {
			System.out.println("Enter again: ");
			text = scanner.nextLine();
		}

		LocalDateTime dateTimeEnd = LocalDateTime.now();
		if (text.equals("yes")) {
			// "18/06/2021 07:27:18";
			System.out.println("Enter the break up time: (dd/MM/yyyy HH:mm:ss)");
			text = getDateTimeInput();
			dateTimeEnd = LocalDateTime.parse(text, dtf);
		}
		scanner.close();

		// Day of week
		System.out.println("You started dating on: " + getdayOfWeek(dateTimeStart.toLocalDate()));

		// Duration
		System.out.println("Total time: " + beetween(dateTimeStart, dateTimeEnd));

	}

	private static DayOfWeek getdayOfWeek(LocalDate date) {
		return date.getDayOfWeek();
	}

	private static String getDateTimeInput() {
		String text = "";
		text = scanner.nextLine();
		while (!validateDateTimeInput(text)) {
			System.out.println("Enter again! ");
			text = scanner.nextLine();
		}
		return text;
	}

	private static boolean validateDateTimeInput(String text) {
		Objects.requireNonNull(text);
		try {
			LocalDateTime.parse(text, dtf);
		} catch (DateTimeParseException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private static String beetween(LocalDateTime start, LocalDateTime end) {
		Objects.requireNonNull(start);
		Objects.requireNonNull(end);

		if (start.isAfter(end)) {
			throw new IllegalArgumentException("Start time cannot exceed end time");
		}

		Period period = Period.between(start.toLocalDate(), end.toLocalDate());
		Duration duration = Duration.between(start.toLocalTime(), end.toLocalTime());

		if (start.toLocalTime().isAfter(end.toLocalTime())) {
			period = period.minusDays(1);
			duration = duration.plusDays(1);
		}

		return period.getYears() + " year, " + period.getMonths() + " month, " + period.getDays() + " day, "
				+ duration.toHoursPart() + " hour, " + duration.toMinutesPart() + " minius, " + duration.toSecondsPart()
				+ " sencond ";
	}
}
