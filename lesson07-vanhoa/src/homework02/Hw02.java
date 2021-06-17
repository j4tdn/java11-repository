package homework02;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.util.Objects;

public class Hw02 {
	
	public static void main(String[] args) {
		LocalDateTime firstDate = LocalDateTime.of(2013, 10, 24, 20, 13, 56);
		LocalDateTime c = LocalDateTime.now();
		System.out.println("Time in love: " + between(firstDate, c));
		System.out.println("Ngay dau hen ho la ngay thu may? " + firstDate.getDayOfWeek());
		
	}
	
	private static String between(LocalDateTime dtStart, LocalDateTime dtNow) {
		Objects.requireNonNull(dtStart);
		Objects.requireNonNull(dtNow);
		if(dtStart.isAfter(dtNow)) {
			throw new IllegalArgumentException("Start date cannot exceed End date");
		}
		LocalDate dateStart = dtStart.toLocalDate();
		LocalDate dateNow  = dtNow.toLocalDate();
		
		LocalTime timeStart = dtStart.toLocalTime();
		LocalTime timeNow = dtNow.toLocalTime();
		
		Period period = Period.between(dateStart, dateNow);
		Duration duration = Duration.between(timeStart, timeNow);
		
		if(timeNow.isBefore(timeStart)) {
			duration = duration.plusDays(1);
			period = period.minusDays(1);
		}
		String toString = period.getYears()  + "years\n"
				+ period.getMonths() + "months\n"
				+ period.getDays()   + "days\n"
				+ duration.toHoursPart() + "hours\n"
				+ duration.toMinutesPart()+ "minutes\n"
				+ duration.toSecondsPart() + "seconds";
		
		return toString;
	}
}
