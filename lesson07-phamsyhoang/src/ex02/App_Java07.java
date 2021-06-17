package ex02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.Calendar;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class App_Java07 {

	private static String[] weekdays = { "SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY" };

	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		System.out.println("===== THE ULTIMATE RELATIONSHIP CALCULATOR =====");

		System.out.print("When did you start dating? (dd/MM/yyyy): ");
		String input = ip.nextLine() + " 00:00:00";
		// LocalDateTime dateStart = LocalDateTime.parse(input, df);
		Calendar dateStart = Calendar.getInstance();
		try {
			dateStart.setTime(dtf.parse(input));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		System.out.println("Current status: ");
		System.out.println("	1.In love ");
		System.out.println("	2.Broke up :)");
		int tt = Integer.parseInt(ip.next());

		switch (tt) {
		case 1:
			Calendar dateEnd1 = Calendar.getInstance();
			between(dateStart, dateEnd1);
			break;
		case 2:
			System.out.print("When did you break up? (dd/MM/yyyy): ");
			String input2 = ip.next() + " 00:00:00";
			Calendar dateEnd2 = Calendar.getInstance();
			try {
				dateEnd2.setTime(dtf.parse(input2));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			between(dateStart, dateEnd2);
			break;
		default:
			System.out.println("Invalid number!");
		}
	}

	private static void between(Calendar dtStart, Calendar dtEnd) {
		Objects.requireNonNull(dtStart);
		Objects.requireNonNull(dtEnd);

		if (dtStart.after(dtEnd)) {
			throw new IllegalArgumentException("StartDate cannot exceed EndDate!");
		}
		System.out.println("==================================");
		System.out.println("Date started dating: " + weekdays[dtStart.get(Calendar.DAY_OF_WEEK) - 1]);

		long dayStartInMils = dtStart.getTimeInMillis();
		long dayEndInMils = dtEnd.getTimeInMillis();

		long duration = dayEndInMils - dayStartInMils;

		long days = TimeUnit.MILLISECONDS.toDays(duration);
		duration -= TimeUnit.DAYS.toMillis(days);

		long year = days / 365;
		days = days - year * 365;
		long month = days / 30;
		days = days - month * 30;
		if (days >= 30) {
			days = days - 30 * month;
			if (month >= 12) {
				year = year + month / 12;
				month = month - 12 * (month / 12);
			}
		}
		System.out.println("Period: " + year + " year " + month + " month " + days + " days ");
	}

}
