package datetime;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import utils.DateUtils;

public class Ex04 {
	public static void main(String[] args) {
		Calendar born = DateUtils.getCalendar(2021, Calendar.JUNE, 05);
		born.set(Calendar.HOUR_OF_DAY, 20);
		
		Calendar today = Calendar.getInstance();
		
		if(born.after(today)) {
			throw new RuntimeException("born can't greated than today");
		}
		long bornInMils = born.getTimeInMillis();
		long todayInMils =  today.getTimeInMillis();
		
		//miliseconds => days, hours, mins, secs, milis
		long duration = todayInMils - bornInMils; 
		
		long days = TimeUnit.MILLISECONDS.toDays(duration);
		duration -= TimeUnit.DAYS.toMillis(days);
		
		long hours = TimeUnit.MILLISECONDS.toHours(duration);
		duration -= TimeUnit.HOURS.toMillis(hours);
		
		long minutes = TimeUnit.MILLISECONDS.toHours(duration);
		duration -= TimeUnit.MINUTES.toMillis(minutes);
		
		long seconds = TimeUnit.MILLISECONDS.toHours(duration);
		duration -= TimeUnit.SECONDS.toMillis(seconds);
		
		System.out.println(days + " Days"
						+ hours + " Hours"
						+ minutes + " Minutes"
						+ seconds + " Seconds"
				);
	}
}
