package homework;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.util.Objects;

import utils.Utils;

public class Ex02 {
	public static void main(String[] args) {
		
		LocalDateTime dtStart = LocalDateTime.of(2021, 5, 1, 0, 0);
		LocalDateTime dtEnd = LocalDateTime.of(2022, 10, 1, 0, 0);
		
		String duration = toDating(dtStart, dtEnd);
		System.out.println("when did you start dating: " + dtStart);
		System.out.println("to Dating: " + duration);
		System.out.println(dtStart.getDayOfWeek());
		
		System.out.println("=========================================");
		
		LocalDateTime dtBreakEnd = LocalDateTime.of(2018, Month.JUNE, 16, 0, 0);
		String durationTime = toBreakup(dtBreakEnd, LocalDateTime.now());
	
		System.out.println("Breakup time: " + durationTime);
		
		System.out.println("==================================");
		
		
	}
	
	private static String toDating(LocalDateTime dtStart, LocalDateTime dtEnd) {
		Objects.requireNonNull(dtStart);
		Objects.requireNonNull(dtEnd);
		
		if(dtStart.isAfter(dtEnd)) {
			throw new IllegalArgumentException("Start Date can not exceed End date");
		}
		
		LocalDate dateStart = dtStart.toLocalDate();
		LocalDate dateEnd = dtEnd.toLocalDate();
		
		LocalTime timeStart = dtStart.toLocalTime();
		LocalTime timeEnd = dtEnd.toLocalTime();
		
		Period period = Period.between(dateStart, dateEnd);
		Duration duration = Duration.between(timeStart, timeEnd);
		
		if(timeEnd.isBefore(timeStart)) {
			duration = duration.plusDays(1);
			period.minusDays(1);
		}
		return period.toString() + " " + duration.toString();
	}
	
	private static String toBreakup(LocalDateTime dtBreakEnd, LocalDateTime localDateTime ) {
		Objects.requireNonNull(dtBreakEnd);
		
		if(LocalDateTime.now().isBefore(dtBreakEnd)) {
			throw new IllegalArgumentException("Breakup day can not exceed Time now");
		}
		LocalDate dateNow = LocalDate.now();
		LocalTime timeNow = LocalTime.now();
		
		LocalDate dateEnd = dtBreakEnd.toLocalDate();
		LocalTime timeEnd = dtBreakEnd.toLocalTime();
		
		Period period = Period.between(dateEnd, dateNow);
		Duration duration = Duration.between(timeEnd, timeNow);
		
		if(timeEnd.isBefore(timeNow)) {
			duration = duration.plusDays(1);
			period.minusDays(1);
			
		}
		return period.toString() + " " +duration.toString();
	}
	
}
