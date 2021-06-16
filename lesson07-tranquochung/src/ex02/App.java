package ex02;

import java.util.Calendar;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import utils.DateTimeUtils;

/**
 * The Ultimate Relationship Calculator
 * 
 * @author professor
 *
 */
public class App {
	public static void main(String[] args) {
		String dayStart;
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter Start Dating: ");
		dayStart = scanner.nextLine();

		dayLove(dayStart);

	}

	private static void dayLove(String daystartLove) {
		Calendar today = Calendar.getInstance();
		Calendar dayStart = DateTimeUtils.toCalendar(DateTimeUtils.toDate(daystartLove));

		if (dayStart.after(today)) {
			throw new RuntimeException("Love cannot greated than today !");
		}

		long loveInMils = dayStart.getTimeInMillis();
		long todayInMils = today.getTimeInMillis();

		long duration = todayInMils - loveInMils;

		long days = TimeUnit.MILLISECONDS.toDays(duration);
		duration -= TimeUnit.DAYS.toMillis(days);

		long hours = TimeUnit.MILLISECONDS.toHours(duration);
		duration -= TimeUnit.HOURS.toMillis(hours);

		long minutes = TimeUnit.MILLISECONDS.toMinutes(duration);
		duration -= TimeUnit.MINUTES.toMillis(minutes);

		long seconds = TimeUnit.MILLISECONDS.toSeconds(duration);
		duration -= TimeUnit.SECONDS.toMillis(seconds);

		System.out.println(days + " D " + hours + " H " + minutes + " M " + seconds + " S " + duration + " MS ");
	}
}
