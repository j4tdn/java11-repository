package java07;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Ex03 {

	public static void main(String[] args) {
		// getInformationOfTheDay();
		System.out.println(validateYear(1020));
		System.out.println(validateDate(2, 2021));
	}

	private static void getInformationOfTheDay() {
		DateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy");
		DateFormat dfDayOfWeek = new SimpleDateFormat("EEEE");
		DateFormat dfMonthOfYear = new SimpleDateFormat("MMMM");
		Calendar cal = Calendar.getInstance();
		System.out.println(sdfDate.format(cal.getTime()));
		System.out.format("It is day number %d of the year %d day lest\n", cal.get(Calendar.DAY_OF_YEAR),
				cal.getActualMaximum(Calendar.DAY_OF_YEAR) - cal.get(Calendar.DAY_OF_YEAR));

		System.out.format("It is %s number %s out of %s in %s \n", dfDayOfWeek.format(cal.getTime()),
				cal.get(Calendar.WEEK_OF_YEAR), cal.getActualMaximum(Calendar.WEEK_OF_YEAR), cal.get(Calendar.YEAR));

		System.out.format("It is %s number %s out of %s in %s\n", dfDayOfWeek.format(cal.getTime()),
				cal.get(Calendar.WEEK_OF_MONTH), cal.getActualMaximum(Calendar.WEEK_OF_MONTH),
				dfMonthOfYear.format(cal.getTime()), cal.get(Calendar.YEAR));

		System.out.format("Year %s has %s days \n", cal.get(Calendar.YEAR), cal.getActualMaximum(Calendar.DAY_OF_YEAR));

		System.out.format("%s %d has %d days\n", dfMonthOfYear.format(cal.getTime()), cal.get(Calendar.YEAR),
				cal.getActualMaximum(Calendar.DAY_OF_MONTH));
	}

	private static boolean validateYear(int year) {
		if (year > 1000 && year < 2999) {
			return true;
		} else {
			return false;
		}
	}

	private static boolean isLeapYear(int year) {
		if (year % 4 == 0 && year % 100 == 0) {
			return true;
		} else {
			return false;
		}
	}

	private static boolean validateDate(int month, int year) {
		int day = 29;
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			if (day > 0 && day <= 31) {
				System.out.format("date %d month %d year %d is validate\n", day, month, year);
				return true;
			} else {
				System.out.format("date %d month %d year %d is not validate\n", day, month, year);
				return false;
			}
		case 4:
		case 6:
		case 9:
		case 11:
			if (day <= 30 && day > 0) {
				System.out.format("date %d month %d year %d is validate\n", day, month, year);
				return true;
			} else {
				System.out.format("date %d month %d year %d is not validate\n", day, month, year);
				return false;
			}
		case 2:
			if (isLeapYear(year)) {
				if (day <= 29 && day > 0) {
					System.out.format("Ngay %d thang %d nam %d hop le\n", day, month, year);
					return true;
				} else {
					System.out.format("date %d month %d year %d is not validate\n", day, month, year);
					return false;
				}
			} else {
				if (day <= 28 && day > 0) {
					System.out.format("Ngay %d thang %d nam %d hop le\n", day, month, year);
					return true;
				} else {
					System.out.format("date %d month %d year %d is not validate\n", day, month, year);
					return false;
				}
			}
		default:
			return false;
		}
	}
}