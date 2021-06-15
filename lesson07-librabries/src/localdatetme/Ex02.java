package localdatetme;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/*
 * Demo with Local Time
 * Pattern Builder Pattern
 */
public class Ex02 {
	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("KK:mm:SS");
	public static void main(String[] args) {
		LocalTime time = LocalTime.now().withHour(10);
		LocalTime anothertime = LocalTime.of(22, 22, 44);
		
		System.out.println("time: " + time);
		System.out.println("anothertime: " + anothertime);
		System.out.println("formatted: " + dtf.format(time));
		
		Duration duration = Duration.between(time, anothertime);
		System.out.println("duration: " + duration); // neu khong dung part no ra tong
		System.out.println("toString: " + duration.toHoursPart() + "H "
				+duration.toMinutesPart() + "M "
				+duration.toSecondsPart() + "S");
		
	}

}
