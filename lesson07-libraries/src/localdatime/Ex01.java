package localdatime;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Ex01 {
	private static  String Pattern ="dd/MM/yyyy HH:mm:ss";
	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		LocalDate anotherDate =LocalDate.of(2021, 9, 18);
		
		System.out.println("date: "+date);
		System.out.println("another: "+anotherDate);

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(Pattern);
		System.out.println("format: "+dtf.format(date));
		LocalDate parsed= LocalDate.parse("25/02/1998",dtf);
		System.out.println("parsed: "+parsed);
		Period period= Period.between(date, anotherDate);
		System.out.println("period: "+period);
	}
}
