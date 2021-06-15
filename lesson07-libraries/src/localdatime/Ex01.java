package localdatime;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * 
 *
 */
public class Ex01 {
	public static void main(String[] args) {
		LocalDate date = LocalDate.now()
								  .withMonth(8)
								  .withYear(2021);
		System.out.println("date: " + date);
		
		LocalDate anotherDate = LocalDate.of(2022, Month.OCTOBER, 22)
										 .plusWeeks(2);
		
		System.out.println("another date: " + anotherDate);
		
		Period period = Period.between(date, anotherDate);
		System.out.println("period: " + period);
		System.out.println("toString: " + period.getYears()  + "y" 
										+ period.getMonths() + "m"
										+ period.getDays()   + "d");
		
		//format
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		System.out.println("formarted: " + dtf.format(anotherDate));
	}
}
