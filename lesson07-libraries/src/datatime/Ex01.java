package datatime;

import java.util.Calendar;
import java.util.Date;

public class Ex01 {
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println("date: "+ date);
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, 20);
		System.out.println("c: "+c);
		int day = c.get(Calendar.DAY_OF_MONTH);
		int month = c.get(Calendar.MONTH)+1;
		int year = c.get(Calendar.YEAR);
		
		int hour = c.get(Calendar.HOUR);
		int ap= c.get(Calendar.AM_PM);
		int minutes =c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);
		
		System.out.println(day+"/"+month+"/"+year);
		System.out.println(hour+":"+minutes+":"+second+(ap==1?"pm":"am"));
	
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		int weekOfMonth = c.get(Calendar.WEEK_OF_MONTH);
		int weedOfYear = c.get(Calendar.WEEK_OF_YEAR);
		
		String [] weekdays= {"SUN", "MON", "TUE", "WED", "THU","FRI", "SAT"};
		Weekday[] wdEnum = Weekday.values();
		System.out.println();
		System.out.println("dayOfWeek: "+weekdays[dayOfWeek-1]);
		System.out.println("dayOfWeek: "+wdEnum[dayOfWeek-1]);
		System.out.println("weekOfMonth: "+weekOfMonth);
		System.out.println("weedOfYear: "+weedOfYear);
	}
}
