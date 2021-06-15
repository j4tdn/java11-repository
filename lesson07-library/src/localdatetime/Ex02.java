package localdatetime;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *Demo with Local Time
 *Pattern: Builder Pattern 
 *
 */
public class Ex02 {
	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("KK:mm:ss: a"); //tao ham nay de format lai gio
	
	public static void main(String[] args) {
		LocalTime time = LocalTime.now().withHour(10).withMinute(39); //dung with de set time
		System.out.println(" Time: " + time);
		
		LocalTime anotherTime = LocalTime.of(22, 22, 44);
		System.out.println("another Time: " + anotherTime);
		
		System.out.println("formated: " + dtf.format(time));
		
		//tim time giua khoang 2 moc time
		Duration duration =Duration.between(time, anotherTime);
		System.out.println("Duration: " + duration);
		System.out.println("toString: " + duration.toHoursPart() + " H " 	//toHour, toMinutes thi thoi gian se + don
										+ duration.toMinutesPart() + " M " 
										+ duration.toSecondsPart() + " S ");
		
		
	}
}
