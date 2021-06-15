package localdatetime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Ex03 {
	
	private static String LocalizedKey = "dd.MM.yyyy 'T' KK:mm:ss a"; //cach them ki tu vo de k bi loi 'T'
	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern(LocalizedKey);
	
	public static void main(String[] args) {
	//Date and Time
		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println("date Time: " + dateTime);
		
		LocalDateTime anotheDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.now());
		System.out.println("anotherLocalDateTime: " + anotheDateTime);
		
		System.out.println("formated: " + dtf.format(dateTime));
		
		//chuyen doi sang Date
		//dateTime.toLocalDate();

		
		//Period: cho LocalDay
		//Duration: cho LocalTime
		//			: LocalDateTime (chua co) -> ket hop 2 cai tren lai
		
		LocalDateTime dtStart = LocalDateTime.of(2021, 10, 8, 10, 24, 10);
		LocalDateTime dtEnd = LocalDateTime.of(2021, 10, 10, 8, 22, 30);
		
		String duration = between(dtStart, dtEnd);
		
		System.out.println("duration: " + duration);
	}
		
	private static String between(LocalDateTime dtStart, LocalDateTime dtEnd ) {
		Objects.requireNonNull(dtStart);
		Objects.requireNonNull(dtEnd);
		
		if(dtStart.isAfter(dtEnd)) {
			throw new IllegalArgumentException("Start Date cannot exceed End Date!!!");
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
		
		return period.toString() + '-' + duration.toString();
	}
}
