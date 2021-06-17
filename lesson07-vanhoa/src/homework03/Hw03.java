package homework03;

import java.time.LocalDate;

public class Hw03 {
	public static void main(String[] args) {
		LocalDate date = LocalDate.of(1999, 06, 19);
		System.out.println(date + "is a " + date.getDayOfWeek());
		additionalFacts(date);
	}

	private static void additionalFacts(LocalDate date) {
		int dayLeft = date.lengthOfYear() - date.getDayOfYear();
		System.out.println("It is day number " + date.getDayOfYear() + " of the year " + dayLeft + " day left");

		int countYear = 0;
		int countMonth = 0;
		for (int i = 1; i <= date.getDayOfYear(); i++) {
			LocalDate f = LocalDate.ofYearDay(date.getYear(), i);
			if (f.getDayOfWeek() == date.getDayOfWeek()) {
				countYear++;
			}
		}
		System.out.println("It is " + date.getDayOfWeek() + " number " + countYear + " out of 52 in " + date.getYear());

		for (int i = 1; i <= date.getDayOfMonth(); i++) {
			LocalDate f = LocalDate.of(date.getYear(), date.getMonth(), i);
			if (f.getDayOfWeek() == date.getDayOfWeek()) {
				countMonth++;
			}
		}
		System.out.println("It is " + date.getDayOfWeek() + " number " + countMonth + " in " + date.getMonth() + " "
				+ date.getYear());
		if (date.isLeapYear()) {
			System.out.println("Year " + date.getYear() + " has 366 days");
		} else {
			System.out.println("Year " + date.getYear() + " has 365 days");
		}
		System.out.println(date.getMonth() + " " + date.getYear() + " has " + date.lengthOfMonth() + " days");
	}
}
