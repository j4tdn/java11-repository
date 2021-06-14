package datetime;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import javax.management.RuntimeErrorException;

import utils.DateUtils;

public class Ex04 {
	public static void main(String[] args) {
		//Epoch
		Calendar born = DateUtils.getCalendar(2021, Calendar.JUNE, 10);
		//born.set(Calendar.HOUR_OF_DAY, 20);
		Calendar today = Calendar.getInstance();
		
		if (born.after(today)) {
			throw new RuntimeException("born cannot greated than today!");
		}
		long bornInMils = born.getTimeInMillis();
		long todayInMils = today.getTimeInMillis();
		
		//millisecond => days, hour, minutes, seconds, milliseconds 
		long duration = todayInMils - bornInMils;
		
		//doi tu milliseconds sang day
		long days = TimeUnit.MILLISECONDS.toDays(duration);
		duration -= TimeUnit.DAYS.toMillis(days);
		
		long hours = TimeUnit.MILLISECONDS.toHours(duration);
		duration -= TimeUnit.DAYS.toMillis(hours);
		
		long minutes = TimeUnit.MILLISECONDS.toHours(duration);
		duration -= TimeUnit.DAYS.toMillis(minutes);
		
		long seconds = TimeUnit.MILLISECONDS.toHours(duration);
		duration -= TimeUnit.DAYS.toMillis(seconds);
		
		System.out.println(days + " D "
							+hours + " H "
							+minutes + " M "
							+seconds + " S "
							+duration + " MS ");
	}
}
