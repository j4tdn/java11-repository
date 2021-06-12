package datetime;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import utils.DateUtils;

public class Ex04 {
	public static void main(String[] args) {
		// Epoch
		Calendar born = DateUtils.setCalendar(1999, Calendar.MAY, 24);
		born.set(Calendar.HOUR_OF_DAY, 20);
		Calendar today = Calendar.getInstance();
		
		if(born.after(today)) {
			throw new RuntimeException("born cannot greated than today!");
		}
		
		long startInMils = born.getTimeInMillis();
		long todayInMils = today.getTimeInMillis();
		
		// milliseconds => days, hours, minutes, seconds, milliseconds
		long duration = todayInMils - startInMils;
//		System.out.println(duration);
		
		long days = TimeUnit.MILLISECONDS.toDays(duration);
		duration = duration - TimeUnit.DAYS.toMillis(days);
		
		long hours = TimeUnit.MILLISECONDS.toHours(duration);
		duration = duration - TimeUnit.HOURS.toMillis(hours);
		
		long minutes = TimeUnit.MILLISECONDS.toMinutes(duration);
		duration = duration - TimeUnit.MINUTES.toMillis(minutes);

		long seconds = TimeUnit.MILLISECONDS.toSeconds(duration);
		duration = duration - TimeUnit.MINUTES.toMillis(seconds);
		
		System.out.println(days + "D "
					+ hours + "H "
					+ minutes + "M "
					+ seconds + "S "
					+ duration + "MS"
				);
		
		
	}
}