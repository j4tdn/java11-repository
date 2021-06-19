package ex02;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import utils.DateTimeUtils;

public class Ex02 {
	public static void main(String[] args) {
		String dayStart = "14/03/2021";
		Calendar c = DateTimeUtils.toCalendar(DateTimeUtils.toDate(dayStart));
	    System.out.println("dayStart: " + DateTimeUtils.getWeekDayAsString(c.get(Calendar.DAY_OF_WEEK))); 
DaysLove(dayStart);
	}
	
	public static void DaysLove(String dayLove) {
		Calendar today = Calendar.getInstance();
		Calendar dayStart = toCalendar(toDate(dayLove));
		
		if(dayStart.after(today)) {
			throw new RuntimeException("born cannot greated than today!");
		}
		
		long startInMillis = dayStart.getTimeInMillis();
		long todayInMillis = today.getTimeInMillis();
		
		long duration = todayInMillis - startInMillis;
		
		long days = TimeUnit.MILLISECONDS.toDays(duration);
		duration -= TimeUnit.DAYS.toMillis(days);
		
		long hours = TimeUnit.MILLISECONDS.toHours(duration);
		duration -= TimeUnit.HOURS.toMillis(hours);
		
		long minutes = TimeUnit.MILLISECONDS.toMinutes(duration);
		duration -= TimeUnit.MINUTES.toMillis(minutes);
		
		long seconds = TimeUnit.MILLISECONDS.toSeconds(duration);
		duration -= TimeUnit.SECONDS.toMillis(seconds);
		
		System.out.println(days + "D "
				+ hours + "H "
				+ minutes + "M "
				+ seconds + "S "
				+ duration + "MS"
			);
	}

	private static Calendar toCalendar(Object date) {
		return null;
	}

	private static Object toDate(String dayLove) {
		return null;
	}


	}

