package localdatetime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Ex03 {
	private static String localizedKey = "dd.MM.yyyy'T'KK:mm:ss a";
	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern(localizedKey);
	public static void main(String[] args) {
		LocalDateTime datetime = LocalDateTime.now();
		
		LocalDateTime anotherLocalDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.now()); 
		System.out.println("notherLocalDateTime: " + anotherLocalDateTime);
		
		System.out.println("formatted: " + dtf.format(datetime));
		
		// Period	: LocalDate
		// Duration	: LocalTime
		//			: LocalDateTime
		
		LocalDateTime dtStart = LocalDateTime.of(2021, 10, 8, 10, 24, 40);
		LocalDateTime dtEnd = LocalDateTime.of(2021, 10, 10, 8, 22, 30);
		
		System.out.println(between(dtStart, dtEnd));
	}
	
	private static String between(LocalDateTime dtStart, LocalDateTime dtEnd) {
		Objects.requireNonNull(dtStart);
		Objects.requireNonNull(dtEnd);
		
		LocalDate dateStart = dtStart.toLocalDate();
		LocalDate dateEnd = dtEnd.toLocalDate();
		
		if(dtStart.isAfter(dtEnd)) {
			throw new IllegalArgumentException("Startdate cannot exceed EndDate !!!");
		}
		
		LocalTime timeStart = dtStart.toLocalTime();
		LocalTime timeEnd = dtEnd.toLocalTime();
		
		Period period = Period.between(dateStart, dateEnd);
		Duration duration = Duration.between(timeStart, timeEnd);
		
		if(timeEnd.isBefore(timeStart)) {
			duration.plusDays(1);
			period = period.minusDays(1);
		}
		
		return period.toString() + "-" + duration.toString();
	}
}
