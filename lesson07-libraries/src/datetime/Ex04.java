package datetime;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import utils.DateUtils;

public class Ex04 {
	public static void main(String[] args) {
		// Epoch : 01.01.1970
		Calendar born = DateUtils.getCalendar(2021,Calendar.JUNE,5);
		born.set(Calendar.HOUR_OF_DAY, 20);
		
		Calendar today = Calendar.getInstance();
		
		if(born.after(today)) {
			throw new RuntimeException("Born cannot greated than today");
		}
		
		long bornInMilis = born.getTimeInMillis();
		long todayInMilis = today.getTimeInMillis();
		
		// milissecond => days, hour,minute,second, milissecond
		long duration  =  todayInMilis - bornInMilis;
		
		long days = TimeUnit.MILLISECONDS.toDays(duration);
		 duration = duration - TimeUnit.DAYS.toMillis(days);
		 
		 long hours = TimeUnit.MILLISECONDS.toHours(duration);
		 duration = duration - TimeUnit.HOURS.toMillis(hours);
		 
		 long minutes  =  TimeUnit.MILLISECONDS.toMinutes(duration);
		 duration = duration - TimeUnit.MINUTES.toMillis(minutes);
		 
		 long seconds = TimeUnit.MILLISECONDS.toSeconds(duration);
		 long miliseconds = duration - TimeUnit.SECONDS.toMillis(seconds);
		 
		 System.out.println(days + " D "
				 			+ hours + " H "
				 			+ minutes + " M "
				 			+ seconds + " S "
				 			+ miliseconds + " MS ");
		 
	}
}
