package java08;

import java.time.LocalDate;
import java.time.temporal.IsoFields;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class Ex03{

	public static void main(String[] args) {
		getInformationOfTheDay();
		System.out.println(validateDate(31, 7, 2020));
	}

	private static void getInformationOfTheDay() {
		LocalDate now = LocalDate.now();
		System.out.format("It is day number %d of the year %d day lest\n", now.getDayOfYear(),
				now.lengthOfYear() - now.getDayOfYear());
		TemporalField weekOfYear = WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear();
		System.out.format("It is %s number %d out of %d in %d \n", now.getDayOfWeek(), now.get(weekOfYear),
				IsoFields.WEEK_OF_WEEK_BASED_YEAR.rangeRefinedBy(now).getMaximum(), now.getYear());

		System.out.format("It is %s number %s out of %s in %s \n", now.getDayOfWeek(),
				now.get(WeekFields.of(Locale.getDefault()).dayOfWeek()),
				now.get(WeekFields.of(Locale.getDefault()).weekOfMonth()), now.getYear());

		System.out.format("Year %s has %s days \n", now.getYear(), now.lengthOfYear());
		System.out.format("%s %d has %d days\n", now.getMonth(), now.getYear(), now.lengthOfMonth());

	}

	private static boolean validateYear(int year) {
		if (year > 1000 && year < 2999) {
			return true;
		} else {
			return false;
		}
	}

	private static boolean validateDate(int day, int month, int year) {
		LocalDate now = LocalDate.of(year, month, day);
		System.out.println(now.lengthOfMonth());
		if (day > 0 && day <= now.lengthOfMonth()) {
			System.out.format("date %d month %d year %d is validate\n", day, month, year);
			return true;
		} else {
			System.out.format("date %d month %d year %d is not validate\n", day, month, year);
			return false;
		}
	}
}
