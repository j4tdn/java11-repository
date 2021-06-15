package datetime;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import utils.DateUtils;

public class Ex04 {
	public static void main(String[] args) {
		// Epoch
		Calendar born = DateUtils.getCalendar(2021, Calendar.JUNE, 5);
		born.set(Calendar.HOUR_OF_DAY, 20);

		Calendar today = Calendar.getInstance();

		if (born.after(today)) {
			throw new RuntimeException("born cannor greated than today !");
		}

		long bornInMils = born.getTimeInMillis();
		long todayInMils = today.getTimeInMillis();

		// millisecons => days, hours, minutes, seconds, milliseconds
		long duration = todayInMils - bornInMils;

		long days = TimeUnit.MILLISECONDS.toDays(duration);
		duration -= TimeUnit.DAYS.toMillis(days);

		long hours = TimeUnit.MILLISECONDS.toHours(duration);
		duration -= TimeUnit.HOURS.toMillis(hours);

		long minutes = TimeUnit.MILLISECONDS.toMinutes(duration);
		duration -= TimeUnit.MINUTES.toMillis(minutes);

		long seconds = TimeUnit.MILLISECONDS.toSeconds(duration);
		duration -= TimeUnit.SECONDS.toMillis(seconds);

		System.out.println(days + " D " + hours + " H " + minutes + " M " + seconds + " S " + duration + " MS ");
	}
}
