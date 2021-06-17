package ex04;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class App_Java07 {

	private static SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	private static SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

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
		Scanner sc = new Scanner(System.in);
		Calendar dob = Calendar.getInstance();
		Calendar date = Calendar.getInstance();
		String tmp;

		System.out.println("10.Caculate your age:");
		System.out.print("   Enter your date of birth: ");
		tmp = sc.next();
		try {
			dob.setTime(df.parse(tmp));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (dob.after(date)) {
			throw new RuntimeException("born cannot greated than today!");
		}

		long dayStartInMils = dob.getTimeInMillis();
		long dayEndInMils = date.getTimeInMillis();

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
		System.out.println("   Your age: " + year + " year " + month + " month " + days + " days ");
		;

	}

	private static void function9() {
		Calendar c = Calendar.getInstance();
		System.out.println("9.Remaining months: " + (12 - c.get(Calendar.MONTH) - 1) + " month");
	}

	private static void function8() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, 20);
		System.out.println("8.After 20 days: " + df.format(c.getTime()) + " => Thứ " + c.get(Calendar.DAY_OF_WEEK));
	}

	private static void function7() {
		Scanner sc = new Scanner(System.in);
		Calendar dayStart = Calendar.getInstance();
		Calendar dayEnd = Calendar.getInstance();
		String tmp;

		System.out.println("7.Check the distance between 2 timelines: ");
		System.out.print("  Day Start: ");
		tmp = sc.next();
		try {
			// dayStart.setTime(df.parse(tmp));
			dayStart.setTime(df.parse(tmp));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.print("  Day End: ");
		tmp = sc.next();
		try {
			dayEnd.setTime(df.parse(tmp));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (dayStart.after(dayEnd)) {
			throw new IllegalArgumentException("StartDate cannot exceed EndDate!");
		}

		long dayStartInMils = dayStart.getTimeInMillis();
		long dayEndInMils = dayEnd.getTimeInMillis();

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
		System.out.println("  Period: " + year + " year " + month + " month " + days + " days ");
	}

	private static void function6() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.HOUR, 8);
		System.out.println("6.After 8 hours: " + dtf.format(c.getTime()));
	}

	private static void function5() {
		Calendar c = Calendar.getInstance();
		int weekNumber = c.get(Calendar.WEEK_OF_YEAR);
		System.out.println("5.The current date is at week " + weekNumber + " of the year");
	}

	private static void function4() {
		Calendar c = Calendar.getInstance();
		int fdow = c.getFirstDayOfWeek();
		c.add(Calendar.DAY_OF_MONTH, fdow - c.get(Calendar.DAY_OF_WEEK));
		System.out.println("4.First day of current week: " + df.format(c.getTime()));
		c.add(Calendar.DAY_OF_MONTH, 7);
		System.out.println("  Last day of current week: " + df.format(c.getTime()));
	}

	private static void function3() {
		Calendar c = Calendar.getInstance();
		c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.getActualMaximum(c.get(Calendar.MONTH)));
		System.out.println("3.The last day of the current month: " + df.format(c.getTime()));
	}

	private static void function2() {
		Calendar c = Calendar.getInstance();
		System.out.println("2.Current month has " + c.getActualMaximum(c.get(Calendar.MONTH)) + " days");
	}

	private static void function1() {
		DateFormat df = new SimpleDateFormat("dd/MM/yy");
		Date date = new Date();
		df.setTimeZone(TimeZone.getTimeZone("America/New_York"));
		System.out.println("1.Current time in New York: " + df.format(date));
	}
}
