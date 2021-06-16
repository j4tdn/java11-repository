package ex03;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class UtilsJava7 {
	private UtilsJava7() {}

	public static int countDay(Calendar c, String mode) {
		int countDay = 0;
		Calendar tmp = Calendar.getInstance();
		if (mode.equals("YEAR")) {
			tmp.set(c.get(Calendar.YEAR), 0, 1);
		}
		if (mode.equals("MONTH")) {
			tmp.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), 1);
		}

		while (!tmp.after(c)) {
			if (tmp.get(Calendar.DAY_OF_WEEK) == c.get(Calendar.DAY_OF_WEEK)) {
				++countDay;
				tmp.add(Calendar.DAY_OF_MONTH, 7);
				continue;
			}
			tmp.add(Calendar.DAY_OF_MONTH, 1);
		}
		return countDay;
	}

	public static int countDayLeft(Calendar c) {
		return (new GregorianCalendar()).isLeapYear(c.get(Calendar.YEAR)) ? 
				 366 - c.get(Calendar.DAY_OF_YEAR) : 
			     365 - c.get(Calendar.DAY_OF_YEAR);
	}
	public static int countAllDay(Calendar c, String mode) {
		int countDay = 0;
		Calendar tmp = Calendar.getInstance();
		Calendar dayEnd = Calendar.getInstance();
		if (mode.equals("YEAR")) {
			tmp.set(c.get(Calendar.YEAR), 0, 1);
			dayEnd.set(c.get(Calendar.YEAR), 11, 31);
		}
		if (mode.equals("MONTH")) {
			tmp.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), 1);
			dayEnd.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.getActualMaximum(Calendar.DATE));
		}
		while (!tmp.after(dayEnd)) {
			if (tmp.get(Calendar.DAY_OF_WEEK) == c.get(Calendar.DAY_OF_WEEK)) {
				++countDay;
				tmp.add(Calendar.DAY_OF_MONTH, 7);
				continue;
			}
			tmp.add(Calendar.DAY_OF_MONTH, 1);
		}
		return countDay;
	}

	public static int allDaysInYear(Calendar c) {
		return (new GregorianCalendar()).isLeapYear(c.get(Calendar.YEAR)) ? 366 : 365;
	}

	public static Calendar input() {
		int day, month, year;
		Calendar c = Calendar.getInstance();

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

				c.set(year, month - 1, day, 23, 59);
				return c;
			} catch (RuntimeException e) {
				System.out.println("Your input is invalid! Please enter again!");
			}
		}
	}
}
