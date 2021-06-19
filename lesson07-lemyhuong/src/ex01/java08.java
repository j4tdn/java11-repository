package ex01;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.DayOfWeek;
import static java.time.temporal.TemporalAdjusters.firstInMonth;

public class java08 {
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	public static void main(String[] args) {
		
		getAllSundaysInYear(2021);
	}	
	
	public static LocalDate getAllSundaysInYear(int year) {
		LocalDate date = LocalDate.of(year, 1, 1);
		LocalDate sunday = date.with(firstInMonth(DayOfWeek.SUNDAY));
		
		do {
            System.out.println(sunday.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
            sunday = sunday.plus(Period.ofDays(7));
        } while (sunday.getYear() == year);
		
		return sunday;
	}
}
