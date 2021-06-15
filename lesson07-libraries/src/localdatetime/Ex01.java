package localdatetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class Ex01 {
	public static void main(String[] args) {
		LocalDateTime date = LocalDateTime.now().withMonth(8).withYear(2022);
		
		System.out.println("date: "+date);
		
		LocalDate anotherDate = LocalDate.of(2022, Month.AUGUST, 15).plusWeeks(2);

		//DateTimeFormatter dtf = 
	}
}
