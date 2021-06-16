package ex04;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.TimeZone;

public class AppJava8 {
	public static void main(String[] args) {
		// 1. Show time in New York
		showTime();

		// 2. Show day number in this month
		showDaysInMonth();

		// 3. Show last day in this month
		showLastDayInMonth();

		// 4. Show first and last day in this week
		showFirstAndLastDayInMonth();

		// 5. Show this day in ? week in year
		showWeekInYearWithDay();

		// 6. Add 8 hours and show
		addAndShowTime();

		// 7. Check distance of startTime and endTime
		showTimeDistance();

		// 8. Show day after 20 day
		showDayAfter20Days();

		// 9. Show the rest month in year
		showRestMonthInYear();

		// 10. Calc age
		calcAndShowAge();
	}

	private static void calcAndShowAge() {
		Scanner sc = new Scanner(System.in);
		LocalDate birthDay = null, now = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		String tmp = "";
		System.out.print("10. Your birthday (dd/MM/yyyy): ");
		tmp = sc.nextLine();
		birthDay = LocalDate.parse(tmp, formatter);
		Period period = Period.between(birthDay, now);
		System.out.println("Your age: " + period.getYears() + " Year " + period.getMonths() + " Month "
				+ period.getMonths() + " Day");

	}

	private static void showRestMonthInYear() {
		LocalDate ld = LocalDate.now();
		System.out.println("9. The rest months in year: " + (12 - ld.getMonthValue()));
	}

	private static void showTime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(("dd/MM/yyyy HH:mm:ss"));
		String zoneId = "America/New_York";
		LocalDateTime datetime = LocalDateTime.now(ZoneId.of(zoneId));
		System.out.println("1. Time in New York: " + dtf.format(datetime));
	}

	private static void showDaysInMonth() {
		LocalDateTime datetime = LocalDateTime.now();
		System.out.println("2. This month has " + datetime.getMonth().maxLength() + " days.");
	}

	private static void showLastDayInMonth() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime datetime = LocalDateTime.now();
		datetime = datetime.withDayOfMonth(datetime.getMonth().maxLength());
		System.out.println("3. The last day of this month: " + dtf.format(datetime));
	}

	private static void showFirstAndLastDayInMonth() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime datetime = LocalDateTime.now();
		while (true) {
			if (String.valueOf(datetime.getDayOfWeek()).equals("MONDAY")) {
				System.out.println("4. First day in this week: " + dtf.format(datetime));
				break;
			}
			datetime = datetime.minusDays(1);
		}
		while (true) {
			if (String.valueOf(datetime.getDayOfWeek()).equals("SUNDAY")) {
				System.out.println("4. Last day in this week: " + dtf.format(datetime));
				break;
			}
			datetime = datetime.plusDays(1);
		}
	}

	private static void showWeekInYearWithDay() {
		LocalDate date = LocalDate.now();
		WeekFields weekFields = WeekFields.of(Locale.getDefault());
		int weekNumber = date.get(weekFields.weekOfWeekBasedYear());
		System.out.println("5. This day in week " + weekNumber + " in year.");

	}

	private static void addAndShowTime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime datetime = LocalDateTime.now();
		datetime = datetime.plusHours(8);
		System.out.println("6. Time after 8 hours: " + dtf.format(datetime));
	}

	private static void showTimeDistance() {
		System.out.println("7. Check time distance");
		Scanner sc = new Scanner(System.in);
		LocalDate dayStart, dayEnd = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		String tmp = "";
		System.out.print("Date start:  (dd/MM/yyyy): ");
		tmp = sc.nextLine();
		dayStart = LocalDate.parse(tmp, formatter);
		System.out.print("Date end:  (dd/MM/yyyy): ");
		tmp = sc.nextLine();
		dayStart = LocalDate.parse(tmp, formatter);

		Period period = Period.between(dayStart, dayEnd);
		System.out.println("toString: " + period.getYears() + " Year " + period.getMonths() + " Month");
	}

	private static void showDayAfter20Days() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy EEEE");
		LocalDate date = LocalDate.now().plusDays(20);
		System.out.println("8. Day after 20 days: " + dtf.format(date));
	}

}
