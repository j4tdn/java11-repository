package homework01;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Hw01 {
	private static String[] weekdays = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };
	private static DateFormat df = new SimpleDateFormat("dd/MM/yyyy EEE");
	
	public static void main(String[] args) {
		getAllSundaysInYear(2021, "SUN");
		System.out.println(getLastSunday(2021, "SUN"));
	}

	private static void getAllSundaysInYear(int year, String weekday) {
		Calendar c = Calendar.getInstance();
		Calendar last  = Calendar.getInstance();
		int dayNum = 0;

		for (int i = 0; i < 7; i++) {
			if (weekdays[i].equals(weekday)) {
				dayNum = i + 1;
			}
		}
		
		// find first weekday
		c.set(year, 0, 1);
		last.set(year, 11, 31);
		int dow = c.get(Calendar.DAY_OF_WEEK);
		c.add(Calendar.DAY_OF_MONTH, dayNum + 7 - dow);
		while(c.before(last)) {
			System.out.println(df.format(c.getTime()));
			c.add(Calendar.DAY_OF_MONTH, 7);
		}
	}
	
	private static String getLastSunday(int year, String weekday) {
		Calendar lastDayOfYear = Calendar.getInstance();
		lastDayOfYear.set(year, 11, 31);
		int dayNum = 0;
		for (int i = 0; i < 7; i++) {
			if(weekdays[i].equals(weekday)) {
				dayNum = i + 1;
			}
		}
		int dow = lastDayOfYear.get(Calendar.DAY_OF_WEEK);
		lastDayOfYear.add(Calendar.DAY_OF_MONTH, dayNum - dow);
		return df.format(lastDayOfYear.getTime());
	}
}
