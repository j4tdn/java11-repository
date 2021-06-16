package ex04;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class App {
	
	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("KK:mm:ss a");
	
	public static void main(String[] args) {
		String zoneId = "America/New_York";
		LocalDateTime datetime = LocalDateTime.now(ZoneId.of(zoneId));
		System.out.println("datetime: " + datetime);	
		
		Calendar today = Calendar.getInstance();
		System.out.println("Current month has " + today.getActualMaximum(Calendar.DAY_OF_MONTH) + " days.");
	
		int fdow = today.getFirstDayOfWeek();
		int day = today.get(Calendar.DAY_OF_WEEK);
		int duration = day - fdow;
		System.out.println("The first day of current week is date " + (today.get(Calendar.DAY_OF_MONTH) - duration));
		System.out.println("The last day of current week is date " + (today.get(Calendar.DAY_OF_MONTH) - duration + 6));
		
		
		LocalTime time = LocalTime.now().plusHours(8);
		System.out.println("the hour after 8 hour is: " + dtf.format(time));
		
		LocalDate date = LocalDate.now();
		System.out.println("date " + date);
		
		LocalDate anotherDate = LocalDate.of(2021, 11, 17);
		System.out.println("anotherDate : " + anotherDate);
		
		Period period = Period.between(date, anotherDate);
		System.out.println("toString : " + period.getYears() + "Y "
				+ period.getMonths() + "M " + period.getDays() + "D ");
		
		System.out.println("date after 20 days: " + date.plusDays(20));
		
		LocalDate born = LocalDate.of(1997, 11, 17);
		Period per = Period.between(born, date);
		System.out.println("my years old is : " + per.getYears() + "Y "
				+ per.getMonths() + "M " + per.getDays() + "D ");
	}
}
