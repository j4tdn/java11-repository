package java7;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import utils.DateUtils;

public class Ex04Main {
	public static void main(String[] args) {
		System.out.println("Time in NewYork: " + showTimeNewYork());
		System.out.println("Number day in month: " + numberDaysOfMonth());
		System.out.println("Last day of Month: " + DateUtils.toString(lastDayOfMonth()));
		System.out.println("First day of Month: " + DateUtils.toString(firstDayOfWeek()));
		System.out.println("Last day of week: " + DateUtils.toString(lastDayOfWeek()));
		System.out.println("Week of year: " + weekOfYear());
		System.out.println("Plus 8 hours: " + plusHour(8).getTime());
		System.out.println("Plust 20 days: " + DateUtils.toString(plusDays(20)));

		// 7 9 10: Take it easier with java8
	}

	private static Calendar plusDays(int day) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, day);
		return c;
	}

	private static String showTimeNewYork() {
		Calendar c = Calendar.getInstance();
		c.setTimeZone(TimeZone.getTimeZone("America/New_York"));
		System.out.println(c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND));
		return "";
	}

	private static int numberDaysOfMonth() {
		Calendar c = Calendar.getInstance();
		return c.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	private static Date lastDayOfMonth() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		return c.getTime();
	}

	private static Date firstDayOfWeek() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, -(c.get(Calendar.DAY_OF_WEEK) - c.getActualMinimum(Calendar.DAY_OF_WEEK)));
		return c.getTime();
	}

	private static Date lastDayOfWeek() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, -(c.get(Calendar.DAY_OF_WEEK) - c.getActualMaximum(Calendar.DAY_OF_WEEK)));
		return c.getTime();
	}

	private static int weekOfYear() {
		Calendar c = Calendar.getInstance();
		return c.get(Calendar.WEEK_OF_YEAR);
	}

	private static Calendar plusHour(int hour) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.HOUR_OF_DAY, hour);
		return c;
	}

}
