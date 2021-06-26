package java07;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Ex02 {
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy HH:mm:ss");

	public static void main(String[] args) {
		LocalDateTime lstart = LocalDateTime.of(2020, Month.JUNE.getValue(), 27, 16, 20, 20);
		// Date start, Date end
		Calendar theNextDay = Calendar.getInstance();
		Date end = theNextDay.getTime();
		// theNextDay.set(2020, 2020, 1); // month 0-11
		theNextDay.set(2020, 0, 1, 0, 1, 12);
		Date start = theNextDay.getTime();
		relationshipCalculator(start, end);
	}

	private static void relationshipCalculator(Date start, Date end) {
		DateOfWeek dateOfWeek;
		long duration = Math.abs(end.getTime() - start.getTime()); // 86400000 the number of miliseconds
		long days = TimeUnit.MILLISECONDS.toDays(duration);
		long hours = TimeUnit.MILLISECONDS.toHours(duration) - TimeUnit.DAYS.toHours(days);
		long minutes = TimeUnit.MILLISECONDS.toMinutes(duration) - TimeUnit.DAYS.toMinutes(days)
				- TimeUnit.HOURS.toMinutes(hours);
		long seconds = TimeUnit.MILLISECONDS.toSeconds(duration) - TimeUnit.DAYS.toSeconds(days)
				- TimeUnit.HOURS.toSeconds(hours) - TimeUnit.MINUTES.toSeconds(minutes);
		System.out.println("the day when we have startting dating is " + DateOfWeek.values()[start.getDay()]);
		System.out.format("%d days %d hours %d minutes %d seconds from todays date of %s until %s", days, hours,
				minutes, seconds, sdf.format(start), sdf.format(end));
	}

}

enum DateOfWeek {
	SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, NULL;
}