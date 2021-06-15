package localdatetime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Ex03 {

	private static String LocalizedKed = "dd.MM.yyy KK:mm:ss a";
	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern(LocalizedKed);

	public static void main(String[] args) {
		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println("datetime: " + dateTime);

		LocalDateTime anotherDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.now());
		System.out.println("anotherDateTime: " + anotherDateTime);

		System.out.println("formatted: " + dtf.format(dateTime));

		// Period : LocalDate
		// Duration: LocalTime
		// : LocalDateTime

		LocalDateTime dtStart = LocalDateTime.of(2021, 10, 8, 10, 20, 10);
		LocalDateTime dtEnd = LocalDateTime.of(2021, 10, 10, 8, 22, 30);
		
		String duration = between(dtStart, dtEnd);
		System.out.println("duration: " + duration);
	}
	
	private static String between(LocalDateTime dtStart, LocalDateTime dtEnd) {
		Objects.requireNonNull(dtStart);
		Objects.requireNonNull(dtEnd);
		
		if(dtStart.isAfter(dtEnd)) {
			throw new IllegalArgumentException("Start date cannot exceed End date");	
		}
		
		LocalDate dateStart = dtStart.toLocalDate();
		LocalDate dateEnd   = dtEnd.toLocalDate();
		
		LocalTime timeStart = dtStart.toLocalTime();
		LocalTime timeEnd   = dtEnd.toLocalTime();
		
		Period period = Period.between(dateStart, dateEnd);
		Duration duration = Duration.between(timeStart, timeEnd);
		
		if(timeEnd.isBefore(timeStart)) {
			duration = duration.plusDays(1);
			period = period.minusDays(1);
		}
		
		return period.toString() + '_' + duration.toString();
	}
}
