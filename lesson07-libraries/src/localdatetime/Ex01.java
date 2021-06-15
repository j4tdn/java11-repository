package localdatetime;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * Demo with local date 
 * Pattern: Pattern: Builder Pattern
 */

public class Ex01 {
	public static void main(String[] args) {
		LocalDate date = LocalDate.now()
								  .withMonth(8)
								  .withYear(2022);
		System.out.println("date: " + date);
		
		LocalDate anotherDate = LocalDate.of(2022,Month.AUGUST,15)
										 .plusWeeks(2);
		System.out.println("anotherDate: " + anotherDate);
		
		Period period = Period.between(date, anotherDate);
		System.out.println("period: " + period);
		System.out.println("toString: " + period.getYears() + "Y"
				                        + period.getMonths() + "M"
				                        + period.getDays() + "D");
		
		//format
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		System.out.println("formatted: " + dtf.format(date));
	}
}
