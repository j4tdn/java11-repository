package localdatetime;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class Ex01 {
	
	private static String PARTTERN = "dd/MM/yyyy";
	
	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		LocalDate anotherDate = LocalDate.of(2023, 9, 18);
		System.out.println("date: " + date);
		System.out.println("anotherDate: " + anotherDate);
		
		// format - parse
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(PARTTERN);
		System.out.println("format: " + dtf.format(date));
	
		LocalDate parsed = LocalDate.parse("25/02/2000", dtf);
		System.out.println("parsed: " + parsed);
		
		// duration
		Period period =	Period.between(date, anotherDate);
		System.out.println("period: " + period);
		
		System.out.println(period.getYears() + " years\n"
						 + period.getMonths() + " months\n"
					     + period.getDays() + " days");
	}
}
