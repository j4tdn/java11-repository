package localdatetime;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/*
 * Demo with Local Date
 * Pattern : Builder Pattern
 */
public class Ex01 {
	public static void main(String[] args) {
		LocalDate date = LocalDate.now().withYear(2022).withMonth(8);
		System.out.println("date " + date);

		LocalDate anotherDate = LocalDate.of(2022, Month.AUGUST, 22).plusWeeks(2);
		System.out.println("anotherDate : " + anotherDate);
		
		Period period = Period.between(date, anotherDate);
		System.out.println("period : " + period);
		System.out.println("toString : " + period.getYears() + "Y "
				+ period.getMonths() + "M " + period.getDays() + "D ");
		
		
		// format
		DateTimeFormatter dft = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println("formatted : " + dft.format(date));
	}
}
