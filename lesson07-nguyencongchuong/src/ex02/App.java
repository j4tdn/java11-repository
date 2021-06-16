package ex02;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.util.Objects;

public class App {
	public static void main(String[] args) {
		LocalDateTime dtStart = LocalDateTime.of(2021, 2, 14, 23, 45, 0);
		LocalDateTime dtEnd = LocalDateTime.now();
			
		datingTime(dtStart, dtEnd);
		
	}
	
	private static void datingTime(LocalDateTime dtStart, LocalDateTime dtEnd) {
		Objects.requireNonNull(dtStart);
		Objects.requireNonNull(dtEnd);
		
		if(dtStart.isAfter(dtEnd)) {
			throw new IllegalArgumentException("StartDate cannot exceed EndDate !!!");
			
		}
		
		LocalDate dStart = dtStart.toLocalDate();
		LocalDate dEnd = dtEnd.toLocalDate();
		
		LocalTime tStart = dtStart.toLocalTime();
		LocalTime tEnd = dtEnd.toLocalTime();
		
		Period period = Period.between(dStart, dEnd);
		Duration duration = Duration.between(tStart, tEnd);
		
		if(tEnd.isBefore(tStart)) {
			period = period.minusDays(1);
			duration = duration.plusDays(1);
		}
		
		System.out.println(period.getYears()  + "Y" 
						 + period.getMonths() + "M"
						 + period.getDays()	  + "D"
						 + " " +
						 + duration.toHoursPart()   + "H"
						 + duration.toMinutesPart() + "M"
						 + duration.toSecondsPart() + "S"
						 );
	}
}
