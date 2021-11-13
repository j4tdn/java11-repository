package datatime;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import utils.DateUtils;

public class Ex06 {
	public static void main(String[] args) {
		Calendar start = DateUtils.getdatetime(2021, Calendar.JUNE, 22, 20, 18, 12);
		Calendar now = Calendar.getInstance();
		if (start.after(now)) {
			throw new IllegalArgumentException("start time cannot exceed current time!");
		}
		long startAsMilliseconds = start.getTimeInMillis();
		long nowAsMilliseconds = now.getTimeInMillis();
		long duration = nowAsMilliseconds - startAsMilliseconds;
		long days =TimeUnit.MILLISECONDS.toDays(duration);
		duration = duration - TimeUnit.DAYS.toMillis(days);
		long hours = TimeUnit.MILLISECONDS.toHours(duration);
		duration = duration - TimeUnit.HOURS.toMillis(hours);
		long minutes = TimeUnit.MILLISECONDS.toMinutes(duration);
		duration = duration - TimeUnit.MINUTES.toMillis(minutes);
		long second = TimeUnit.MILLISECONDS.toSeconds(duration);
		duration = duration - TimeUnit.SECONDS.toMillis(second);
		System.out.println(days+"D"+hours+"H"+minutes+"M"+second+"S");
	}
}
