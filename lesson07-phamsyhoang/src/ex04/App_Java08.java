package ex04;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.Locale;
import java.util.Scanner;

public class App_Java08 {

	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm:ss");
	private static DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public static void main(String[] args) {

		function1();
		function2();
		function3();
		function4();
		function5();
		function6();
		function7();
		function8();
		function9();
		function10();
	}

	private static void function10() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		Scanner sc = new Scanner(System.in);
		System.out.println("10.Caculate your age:");
		LocalDate date = LocalDate.now();
		System.out.print("   Enter your date of birth: ");
		String tmp = sc.nextLine() + " 00:00:00";
		LocalDate dob = LocalDate.parse(tmp, dtf);
		if (dob.isAfter(date)) {
			throw new RuntimeException("born cannot greated than today!");
		}
		Period period = Period.between(dob, date);
		String output = period.getYears() + " years " + period.getMonths() + " months " + period.getDays() + " days ";
		System.out.println("   Your age: " + output);
	}

	private static void function9() {
		LocalDateTime date = LocalDateTime.now();
		System.out.println("9.Remaining months: " + (12 - date.getMonthValue()) + " month");
	}

	private static void function8() {
		LocalDateTime date = LocalDateTime.now().plusDays(20);
		System.out.println("8.After 20 days: " + df.format(date.toLocalDate()) + " => " + date.getDayOfWeek());
	}

	private static void function7() {
		Scanner sc = new Scanner(System.in);
		System.out.println("7.Check the distance between 2 timelines: ");
		String tmp;
		System.out.print("  Day Start: ");
		tmp = sc.next();
		LocalDate dayStart = LocalDate.parse(tmp, df);
		System.out.print("  Day End: ");
		tmp = sc.next();
		LocalDate dayEnd = LocalDate.parse(tmp, df);
		if (dayStart.isAfter(dayEnd)) {
			throw new IllegalArgumentException("StartDate cannot exceed EndDate!");
		}
		Period period = Period.between(dayStart, dayEnd);
		String output = period.getYears() + " year " + period.getMonths() + " month " + period.getDays() + " day ";
		System.out.println("  Period: " + output);
	}

	private static void function6() {
		LocalDateTime date = LocalDateTime.now().plusHours(8);
		System.out.println("6.After 8 hours: " + dtf.format(date));
	}

	private static void function5() {
		LocalDateTime date = LocalDateTime.now();
		WeekFields weekFields = WeekFields.of(Locale.getDefault());
		int weekNumber = date.get(weekFields.weekOfYear());
		System.out.println("5.The current date is at week " + weekNumber + " of the year");
	}

	private static void function4() {
		LocalDateTime date = LocalDateTime.now().with(WeekFields.of(Locale.US).dayOfWeek(), 1L);
		System.out.println("4.First day of current week: " + df.format(date));
		System.out.println("  Last day of current week: " + df.format(date.plusDays(7)));
	}

	private static void function3() {
		LocalDateTime date = LocalDateTime.now();
		date = date.withDayOfMonth(date.getMonth().maxLength());
		System.out.println("3.The last day of the current month: " + df.format(date));
	}

	private static void function2() {
		LocalDateTime date = LocalDateTime.now();
		System.out.println("2.Current month has " + date.getMonth().maxLength() + " days");
	}

	private static void function1() {
		LocalDateTime date = LocalDateTime.now();
		date = LocalDateTime.now(ZoneId.of("America/New_York"));
		System.out.println("1.Current time in New York: " + dtf.format(date));
	}
}
