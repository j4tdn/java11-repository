package ex03;

import java.time.LocalDate;

public class App_Java08 {
	public static void main(String[] args) {
		LocalDate date = LocalDate.of(1995, 9, 25);
		funtion(date);
	}

	private static void funtion(LocalDate date) {
		System.out.println(
				date.getDayOfMonth() + " " + date.getMonth() + " " + date.getYear() + " is a " + date.getDayOfWeek());
		System.out.println("It is day number " + date.getDayOfYear() + " of the year, " + (date.lengthOfYear() - date.getDayOfYear())
				+ " days left");
		dayInYear(date);
		dayInMonth(date);
		System.out.println("Year " + date.getYear() + " has " + date.lengthOfYear() + " days" );
		System.out.println(date.getMonth() + " " + date.getYear() + " has " + date.lengthOfMonth() + " days");
	}

	private static void dayInMonth(LocalDate date) {
		LocalDate dayStart = LocalDate.of(date.getYear(), date.getMonthValue(), 1);
		LocalDate dayEnd = LocalDate.of(date.getYear(), date.getMonthValue(), date.lengthOfMonth());
		int count = 0;
		int dim = 0;
		while (!dayStart.isAfter(dayEnd)) {
			if (dayStart.getDayOfWeek() == date.getDayOfWeek()) {
				count++;
				dim++;
				if (dayStart.equals(date)) {
					System.out.print("It is " + date.getDayOfWeek() + " number " + count);
				}
			}
			dayStart = dayStart.plusDays(1);
		}
		System.out.println(" out of " + dim + " in " + date.getMonth() + " " + date.getYear());
	}

	private static void dayInYear(LocalDate date) {
		LocalDate dayStart = LocalDate.of(date.getYear(), 1, 1);
		LocalDate dayEnd = LocalDate.of(date.getYear(), 12, 31);
		int count = 0;
		int diy = 0;
		while (!dayStart.isAfter(dayEnd)) {
			if (dayStart.getDayOfWeek() == date.getDayOfWeek()) {
				count++;
				diy++;
				if (dayStart.equals(date)) {
					System.out.print("It is " + date.getDayOfWeek() + " number " + count);
				}
			}
			dayStart = dayStart.plusDays(1);
		}
		System.out.println(" out of " + diy + " in " + date.getYear());
	}
	
}
