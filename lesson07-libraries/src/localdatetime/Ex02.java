package localdatetime;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Demo with Local time
 * Pattern: Builder Pattern
 * @author PC
 *
 */
public class Ex02 {
	
	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("KK:mm:ss a");
	
	public static void main(String[] args) {
		LocalTime time = LocalTime.now().withHour(21);
		System.out.println("Time: " + time);
		LocalTime anotherTime = LocalTime.of(22, 22, 44);
		System.out.println("anotherTime: " + anotherTime);
		
		System.out.println("formatted: " + dtf.format(time));
		
		Duration duration = Duration.between(time, anotherTime);
		System.out.println("duration: " + duration);
		System.out.println("duration: " + duration.toHoursPart() + "H"
				+ duration.toMinutesPart() + "M"
				+ duration.toSecondsPart() + "S");
	}
}
