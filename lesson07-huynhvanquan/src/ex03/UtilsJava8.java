package ex03;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Scanner;

public class UtilsJava8 {
	private UtilsJava8() {
	}

	public static int countDay(LocalDate ld, String mode) {
		int countDay = 0;
		LocalDate tmp = null;
		if (mode.equals("YEAR")) {
			tmp = LocalDate.of(ld.getYear(), 1, 1);
		}
		if (mode.equals("MONTH")) {
			tmp = LocalDate.of(ld.getYear(), ld.getMonth(), 1);
		}
		while (!tmp.isAfter(ld)) {
			if (tmp.getDayOfWeek() == ld.getDayOfWeek()) {
				++countDay;
				tmp = tmp.plusDays(7);
				continue;
			}
			tmp = tmp.plusDays(1);
		}
		return countDay;
	}

	public static int countAllDay(LocalDate ld, String mode) {
		int countDay = 0;
		LocalDate tmp = null;
		LocalDate dayEnd = null;

		if (mode.equals("YEAR")) {
			tmp = LocalDate.of(ld.getYear(), 1, 1);
			dayEnd = LocalDate.of(ld.getYear(), 12, 31);
		}
		if (mode.equals("MONTH")) {
			tmp = LocalDate.of(ld.getYear(), ld.getMonth(), 1);
			dayEnd = LocalDate.of(ld.getYear(), ld.getMonth(), ld.getMonth().maxLength());
		}
		while (!tmp.isAfter(dayEnd)) {
			if (tmp.getDayOfWeek() == ld.getDayOfWeek()) {
				++countDay;
				tmp = tmp.plusDays(7);
				continue;
			}
			tmp = tmp.plusDays(1);
		}
		return countDay;
	}

	public static LocalDate input() {
		int day, month, year;
		LocalDate localDate;

		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter day, month, year: ");
			try {
				day = sc.nextInt();
				month = sc.nextInt();
				year = sc.nextInt();
				if (year <= 0) {
					throw new RuntimeException();
				}
				switch (month) {
				case 1, 3, 5, 7, 8, 10, 12:
					if (day < 1 || day > 31) {
						throw new RuntimeException();
					}
					break;
				case 4, 6, 9, 11:
					if (day < 1 || day > 30) {
						throw new RuntimeException();
					}
					break;
				case 2:
					if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
						if (day < 1 || day > 28) {
							throw new RuntimeException();
						}
					}
					if (day < 1 || day > 27) {
						throw new RuntimeException();
					}
					break;
				default:
					throw new RuntimeException();
				}

				localDate = LocalDate.of(year, month, day);
				return localDate;
			} catch (RuntimeException e) {
				System.out.println("Your input is invalid! Please enter again!");
			}
		}
	}
}
