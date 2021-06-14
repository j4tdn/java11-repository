package java7;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import utils.DateUtils;

public class Ex02Main {

	public static void main(String[] args) {
		theUltimateRelationshipCalculator();
	}

	private static void theUltimateRelationshipCalculator() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("When did you start dating? (dd/MM/yyyy) ");
		String input = scanner.nextLine();
		Calendar firstDay = DateUtils.toCalendar(input);
		System.out.println("Have they broken up yet? (yes/no)");
		String breakUp = scanner.nextLine();
		Calendar lastDay = Calendar.getInstance();
		if (breakUp.equals("yes")) {
			System.out.println("What time was you break up? (dd/MM/yyyy");
			lastDay = DateUtils.toCalendar(scanner.nextLine());
		}

		String dayOfWeek = DateUtils.getWeekDayAsString(firstDay.get(Calendar.DAY_OF_WEEK));
		System.out.println("You was start dating on " + dayOfWeek);

		System.out.println(totalTime(firstDay, lastDay));
	}

	private static String totalTime(Calendar firstDay, Calendar lastDay) {
		// Take it easier with java8
		return "";
	}

	private static boolean validateSecondAnwser(String text) {
		return true;
	}

}
