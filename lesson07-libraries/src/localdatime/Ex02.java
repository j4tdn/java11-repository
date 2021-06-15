package localdatime;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Ex02 {
	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("KK:mm:ss a	");
	
	public static void main(String[] args) {
		LocalTime time = LocalTime.now().withHour(10);
		System.out.println("time: " + time);
		
		
		LocalTime anotherTime = LocalTime.of(22, 22, 44);
		System.out.println("anotherTime: " + anotherTime);
		
		System.out.println("formated: " + dtf.format(time));
		
		Duration duration =  Duration.between(time, anotherTime);
		System.out.println("duration: " + duration);
		System.out.println("toString: " + duration.toHoursPart()   + "H"
										+ duration.toMinutesPart() + "M"
										+ duration.toSecondsPart() + "S");
	}
}
