package ex02;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Scanner;

public class App_Java08 {

	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		System.out.println("===== THE ULTIMATE RELATIONSHIP CALCULATOR =====");

		System.out.print("When did you start dating? (dd/MM/yyyy): ");
		String input = ip.nextLine() + " 00:00:00";
		LocalDateTime dateStart = LocalDateTime.parse(input, dtf);

		System.out.println("Current status: ");
		System.out.println("	1.In love ");
		System.out.println("	2.Broke up :)");
		int tt = Integer.parseInt(ip.next());

		switch (tt) {
		case 1:
			LocalDateTime dateEnd1 = LocalDateTime.now();
			between(dateStart, dateEnd1);
			break;
		case 2:
			System.out.print("When did you break up? (dd/MM/yyyy): ");
			String input2 = ip.next() + " 00:00:00";
			LocalDateTime dateEnd2 = LocalDateTime.parse(input2, dtf);
			between(dateStart, dateEnd2);
			break;
		default:
			System.out.println("Invalid number!");
		}
	}

	private static void between(LocalDateTime dtStart, LocalDateTime dtEnd) {
		Objects.requireNonNull(dtStart);
		Objects.requireNonNull(dtEnd);

		if (dtStart.isAfter(dtEnd)) {
			throw new IllegalArgumentException("StartDate cannot exceed EndDate!");
		}
		System.out.println("==================================");
		System.out.println("Date started dating: " + dtStart.getDayOfWeek());

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

		String time = period.getYears() + "year - " + period.getMonths() + "month - " + period.getDays() + "day / "
				+ duration.toHoursPart() + "hours - " + duration.toMinutesPart() + "minutes - "
				+ duration.toSecondsPart() + "seconds";
		System.out.println("Period: " + time);

	}

}
