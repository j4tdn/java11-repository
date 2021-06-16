package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.TimeZone;

public class LocalDateTimeUtils {
	private static String[] weekday = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
	private static String[] months = { "January", "February", "March", "April", "May", "June", "July", "August",
			"September", "October", "November", "December" };
	private static final String DATE_PATTERN = "dd/MM/yyyy KK:mm:ss a EEEE";
	private static final String DATE_PATTERN_DAY = "dd/MM/yyyy EEEE";
	private static final String DATE_PATTERN_TIME = "KK:mm:ss a EEEE";
	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern(DATE_PATTERN);
	private static DateTimeFormatter dftD = DateTimeFormatter.ofPattern(DATE_PATTERN_DAY);
	private static DateTimeFormatter dftT = DateTimeFormatter.ofPattern(DATE_PATTERN_TIME);

	private LocalDateTimeUtils() {

	}

	public static String getMonthAsString(int month) {
		return months[month];
	}

	public static String getWeekDayAsString(int weekDayAsNumber) {
		return weekday[weekDayAsNumber - 1];
	}

	public static String toString(LocalDateTime date) {
		return dtf.format(date);
	}

	public static String toStringD(LocalDate date) {
		return dftD.format(date);
	}

	public static String toStringT(LocalTime time) {
		return dftT.format(time);
	}

	public static LocalDate[] getAllWeekdayInYear(int year, DayOfWeek weekday) {
		LocalDate[] arrDate = new LocalDate[100];
		LocalDate dayStart = LocalDate.of(year, Month.JANUARY, 1);
		LocalDate dayEnd = LocalDate.of(year, Month.DECEMBER, dayStart.lengthOfMonth());
		int index = 0;

		while (!dayStart.isAfter(dayEnd)) {
			if (dayStart.getDayOfWeek() == weekday) {
				arrDate[index++] = dayStart;
				dayStart = dayStart.plusDays(7);
			} else {
				dayStart = dayStart.plusDays(1);
			}
		}

		return Arrays.copyOfRange(arrDate, 0, index);
	}

	public static void showAllWeekday(int year, DayOfWeek weekday) {
		LocalDate[] arrDate = getAllWeekdayInYear(year, weekday);
		for (int i = 0; i < arrDate.length; i++) {
			System.out.println(toStringD(arrDate[i]));
		}
	}

	public static LocalDate getLastWeekDay(int year, DayOfWeek weekday) {
		LocalDate[] arrDate = getAllWeekdayInYear(year, weekday);
		return arrDate[arrDate.length - 1];
	}

	public static String between(LocalDateTime dateStart, LocalDateTime dateEnd) {
		Objects.requireNonNull(dateStart);
		Objects.requireNonNull(dateEnd);

		if (dateStart.isAfter(dateEnd)) {
			throw new IllegalArgumentException("StartDate cannot exceed EndDate !!!");
		}

		LocalDate dayStart = dateStart.toLocalDate();
		LocalDate dayEnd = dateEnd.toLocalDate();

		LocalTime timeStart = dateStart.toLocalTime();
		LocalTime timeEnd = dateEnd.toLocalTime();

		Period period = Period.between(dayStart, dayEnd);
		Duration duration = Duration.between(timeStart, timeEnd);

		if (timeEnd.isBefore(timeStart)) {
			duration = duration.plusDays(1);
			period = period.minusDays(1);
		}

		return period.getYears() + "Y " + period.getMonths() + "M " + period.getDays() + "D " + duration.toHoursPart()
				+ "h " + duration.toMinutesPart() + "m " + duration.toSecondsPart() + "s ";
	}

	public static LocalDate[] nofWeekDays(int year, Month month, DayOfWeek weekday) {
		LocalDate[] arrDate = new LocalDate[100];
		LocalDate dateStart = LocalDate.of(year, month, 1);
		LocalDate dateEnd = LocalDate.of(year, month, dateStart.lengthOfMonth());
		int i = 0;
		while (!dateStart.isAfter(dateEnd)) {
			if (dateStart.getDayOfWeek() == weekday) {
				arrDate[i++] = dateStart;
				dateStart = dateStart.plusDays(7);
			} else {
				dateStart = dateStart.plusDays(1);
			}
		}

		return Arrays.copyOfRange(arrDate, 0, i);
	}

	public static void DateInfo(LocalDate date) {
		Objects.requireNonNull(date);
		System.out.println(
				date.getDayOfMonth() + " " + date.getMonth() + " " + date.getYear() + " is a " + date.getDayOfWeek());
		System.out.println("Additional facts : ");

		int dayLeft = date.lengthOfYear() - date.getDayOfYear();
		System.out.println("It is day number " + date.getDayOfYear() + " of the year " + dayLeft + " days left");
		int i = 0;
		LocalDate[] days = getAllWeekdayInYear(date.getYear(), date.getDayOfWeek());
		for (i = 0; i < days.length; i++) {
			if (days[i].getDayOfMonth() == date.getDayOfMonth() && days[i].getMonth() == date.getMonth()) {
				break;
			}
		}
		System.out.println("It is " + date.getDayOfWeek() + " number " + (i + 1) + " out of " + days.length + " in "
				+ date.getYear());

		LocalDate[] arrDays = nofWeekDays(date.getYear(), date.getMonth(), date.getDayOfWeek());
		int i1 = 0;

		for (i1 = 0; i1 < arrDays.length; i1++) {
			if (arrDays[i1].getDayOfMonth() == date.getDayOfMonth()) {
				break;
			}
		}

		System.out.println("It is " + date.getDayOfWeek() + " number " + (i1 + 1) + " out of " + arrDays.length + " in "
				+ date.getMonth() + " " + date.getYear());

		System.out.println("Year " + date.getYear() + " has " + date.lengthOfYear() + " days");
		System.out.println(date.getMonth() + " " + date.getYear() + " has " + date.lengthOfMonth() + " days");
	}

	public static void lastDayOfMonth(LocalDateTime date) {
		Objects.requireNonNull(date);
		int lastDay = date.toLocalDate().lengthOfMonth();
		date = date.withDayOfMonth(lastDay);
		System.out.println("lastDayOfMonth : " + toString(date));
	}

	public static int countWeek(LocalDateTime date) {
		Objects.requireNonNull(date);
		LocalDate dayStart = LocalDate.of(date.getYear(), Month.JANUARY, 1);

		int dowS = dayStart.getDayOfWeek().getValue();
		int fdow = DayOfWeek.SUNDAY.getValue();

		if (fdow != dowS) {
			dayStart = dayStart.plusDays(fdow + (7 - dowS));
		}

		int dowD = date.getDayOfWeek().getValue();
		date = date.plusDays(fdow - dowD);

		LocalDate dayEnd = LocalDate.of(date.getYear(), Month.DECEMBER, date.toLocalDate().lengthOfMonth());

		int count = 0;
		while (!dayStart.isAfter(dayEnd)) {
			count++;
			dayStart = dayStart.plusDays(7);
			if (dayStart.getMonth() == date.getMonth() && dayStart.getDayOfMonth() == date.getDayOfMonth()) {
				count++;
				break;
			}
		}
		return count;
	}

	public static LocalDateTime addH(LocalDateTime date, int hour) {
		Objects.requireNonNull(date);
		date = date.plusHours(hour);
		return date;
	}

	public static LocalDateTime addD(LocalDateTime date, int day) {
		Objects.requireNonNull(date);
		date = date.plusDays(day);
		return date;
	}

	public static int remainMonthInY(LocalDateTime date) {
		return Month.DECEMBER.getValue() - date.getMonthValue();
	}

	public static int age(LocalDateTime date, int yearBirthday) {
		if (yearBirthday > date.getYear()) {
			throw new DateException("YearBirthday cannot be  greater than current year !!!");
		}
		return date.getYear() - yearBirthday;
	}
}
