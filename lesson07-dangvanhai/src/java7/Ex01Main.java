package java7;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Ex01Main {
	private static final String DATE_PATTERN = "dd/MM/yyyy";
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN);

	public static void main(String[] args) {
		System.out.println("-- List of sundays --");
		Date[] sundays = getAllSundaysInYear(2022);
		for (Date day : sundays) {
			System.out.println(toString(day));
		}

		System.out.println("\n-- The last Sunday of year --");
		System.out.println(toString(getLastSunday(2022)));
	}

	private static Date[] getAllSundaysInYear(int year) {
		// Declare the first day
		Calendar firstDay = Calendar.getInstance();
		firstDay.set(year, firstDay.getActualMinimum(Calendar.MONTH), firstDay.getActualMinimum(Calendar.DAY_OF_MONTH));

		// Declare the last day
		Calendar lastDay = Calendar.getInstance();
		lastDay.set(Calendar.YEAR, year);
		lastDay.set(Calendar.MONTH, lastDay.getActualMaximum(Calendar.MONTH));
		lastDay.set(Calendar.DAY_OF_MONTH, lastDay.getActualMaximum(Calendar.DAY_OF_MONTH));

		// Declare day of week
		int dayOfWeek = Calendar.SUNDAY;

		// Solve
		for (int i = 0; i < Calendar.DAY_OF_WEEK; i++) {
			if (firstDay.get(Calendar.DAY_OF_WEEK) == dayOfWeek) {
				break;
			}
			firstDay.add(Calendar.DAY_OF_MONTH, 1);
		}

		Date[] days = new Date[1000];
		int count = 0;
		while (firstDay.before(lastDay)) {
			days[count++] = firstDay.getTime();
			firstDay.add(Calendar.DAY_OF_MONTH, Calendar.DAY_OF_WEEK);
		}

		Date[] result = new Date[count];
		for (int i = 0; i < result.length; i++) {
			result[i] = days[i];
		}

		// Return
		return result;
	}

	private static Date getLastSunday(int year) {
		// Declare the last day of year
		Calendar lastDay = Calendar.getInstance();
		lastDay.set(Calendar.YEAR, year);
		lastDay.set(Calendar.MONTH, lastDay.getActualMaximum(Calendar.MONTH));
		lastDay.set(Calendar.DAY_OF_MONTH, lastDay.getActualMaximum(Calendar.DAY_OF_MONTH));

		// Find the last Sunday
		while (true) {
			if (lastDay.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
				break;
			}
			lastDay.add(Calendar.DAY_OF_MONTH, -1);
		}
		return lastDay.getTime();
	}

	private static String toString(Calendar c) {
		return dateFormat.format(c.getTime());
	}

	private static String toString(Date date) {
		SimpleDateFormat d = new SimpleDateFormat(DATE_PATTERN);
		return dateFormat.format(date);
	}
}
