package ex02;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class AppJava8 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LocalDateTime dayStart, dayEnd = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		boolean status = true;
		String tmp = "";
		System.out.print("When did you start dating? (dd/MM/yyyy): ");
		tmp = sc.nextLine() + " 00:00:00";
		dayStart = LocalDateTime.parse(tmp, formatter);
		System.out.print("\nAre you continuing your love? (true/false): ");
		status = sc.nextBoolean();
		sc.nextLine();
		if (status == false) {
			System.out.print("\nWhen did you separate? (dd/MM/yyyy): ");
			tmp = sc.nextLine() + " 00:00:00";
			dayEnd = LocalDateTime.parse(tmp, formatter);
		}
		String time = between(dayStart, dayEnd);
		System.out.println("The day of first day: " + dayStart.getDayOfWeek());
		System.out.println("Your love duration: " + time);
	}

	private static String between(LocalDateTime dtStart, LocalDateTime dtEnd) {
		String time = "";
		Objects.requireNonNull(dtStart);
		Objects.requireNonNull(dtEnd);

		if (dtStart.isAfter(dtEnd)) {
			throw new IllegalArgumentException("StartDate cannot exceed EndDate!!!");
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
		time = period.getYears() + "year - " + period.getMonths() + "month - " + period.getDays() + "day - "
				+ duration.toHoursPart() + "hour - " + duration.toMinutesPart() + "minutes - "
				+ duration.toSecondsPart() + " seconds";
		return time;
	}
}
