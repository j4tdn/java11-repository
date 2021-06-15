package localdatetime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Ex03 {
	private static String localizedKey = "dd.MM.yyyy'T'KK:mm:ss";
	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern(localizedKey);
	public static void main(String[] args) {
		LocalDateTime datetime = LocalDateTime.now();
		System.out.println("datetime: " + datetime);
		LocalDateTime anLocalDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.now());
		System.out.println("anotherLocalDateTime: " + anLocalDateTime);
		
		System.out.println("formatted: " + dtf.format(datetime));
	
		// Period : LocalDate
		// Duration : LocalTime
		//          : LocalDateTime
		
		LocalDateTime dtStart = LocalDateTime.of(2000, 1, 8, 10, 0, 0);
		LocalDateTime dtEnd   = LocalDateTime.now();
	    String duration = between(dtStart,dtEnd);
	    System.out.println("duration: " + duration);
	}
	private static String between(LocalDateTime dtStart,LocalDateTime dtEnd) {
		Objects.requireNonNull(dtStart);
		Objects.requireNonNull(dtEnd);
		
		if(dtStart.isAfter(dtEnd)) {
			throw new IllegalArgumentException("StartDate cannot exceed EndDate !!!");
		}
		LocalDate dateStart = dtStart.toLocalDate();
		LocalDate dateEnd = dtEnd.toLocalDate();
		
		LocalTime timeStart = dtStart.toLocalTime();
		LocalTime timeEnd = dtEnd.toLocalTime();
		
		Period period = Period.between(dateStart, dateEnd);
		Duration duration = Duration.between(timeStart, timeEnd);
		
		if(timeEnd.isBefore(timeStart)) {
			duration = duration.plusDays(1);
			period = period.minusDays(1);
		}
		return period.toString() + "-" + duration.toString();
		
	}
}
