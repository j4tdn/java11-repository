package ex04;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class AppJava7 {
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

		// 8. Show day after 20 day
		showDayAfter20Days();

		// 9. Show the rest month in year
		showRestMonthInYear();
	}

	public static void showTime() {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss ");
		Date date = new Date();
		df.setTimeZone(TimeZone.getTimeZone("America/New_York"));
		System.out.println("1. Time in New York: " + df.format(date));
	}

	public static void showDaysInMonth() {
		Calendar c = Calendar.getInstance();
		System.out.println("2. This month has " + c.getActualMaximum(c.get(Calendar.MONTH)) + " days.");
	}

	public static void showLastDayInMonth() {
		Calendar c = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.getActualMaximum(c.get(Calendar.MONTH)));
		System.out.println("3. The last day of this month: " + df.format(c.getTime()));
	}

	public static void showFirstAndLastDayInMonth() {
		Calendar c = Calendar.getInstance();
		while (true) {
			if (c.get(Calendar.DAY_OF_WEEK) == 2) {
				System.out.println("4. First day in this week: " + c.getTime());
				break;
			}
			c.add(Calendar.DAY_OF_MONTH, -1);
		}
		while (true) {
			if (c.get(Calendar.DAY_OF_WEEK) == 1) {
				System.out.println("4. Last day in this week: " + c.getTime());
				break;
			}
			c.add(Calendar.DAY_OF_MONTH, 1);
		}
	}

	public static void showWeekInYearWithDay() {
		Calendar c = Calendar.getInstance();
		System.out.println("5. This day in week " + c.get(Calendar.WEEK_OF_YEAR) + " in year.");
	}

	public static void addAndShowTime() {
		Calendar c = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		c.add(Calendar.HOUR_OF_DAY, 8);
		System.out.println("6. Time after 8 hours: " + df.format(c.getTime()));
	}

	public static void showDayAfter20Days() {
		Calendar c = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("EEEE dd/MM/yyyy");
		c.add(Calendar.DAY_OF_MONTH, 20);
		System.out.println("8. Day after 20 days: " + df.format(c.getTime()));
	}

	public static void showRestMonthInYear() {
		Calendar c = Calendar.getInstance();
		System.out.println("9. The rest months in year: " + (11 - c.get(Calendar.MONTH)));
	}
}
