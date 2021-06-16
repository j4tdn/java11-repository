package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class DateUtils {
	private static String[] weekday = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
	private static String[] months = { "January", "February", "March", "April", "May", "June", "July", "August",
			"September", "October", "November", "December" };
	private static final String DATE_PATTERN_TIME = "dd/MM/yyyy HH:mm:ss a EEEE";
	private static final String DATE_PATTERN = "dd/MM/yyyy EEEE";
	private static DateFormat dft = new SimpleDateFormat(DATE_PATTERN_TIME);
	private static DateFormat df = new SimpleDateFormat(DATE_PATTERN);

	private static Scanner ip = new Scanner(System.in);

	private DateUtils() {

	}

	public static String getMonthAsString(int month) {
		return months[month];
	}

	public static String getWeekDayAsString(int weekDayAsNumber) {
		return weekday[weekDayAsNumber - 1];
	}

	public static String toString(Date date) {
		return dft.format(date);
	}

	public static String toStringYMH(Date date) {
		return df.format(date);
	}

	public static Date[] getAllWeekdaysInYear(int year, int weekday) {
		Date[] arrDate = new Date[100];

		Calendar dayStart = Calendar.getInstance();
		dayStart.set(year, Calendar.JANUARY, 1);

		Calendar dayEnd = Calendar.getInstance();
		dayEnd.set(year, Calendar.DECEMBER, dayEnd.getActualMaximum(Calendar.DAY_OF_MONTH));
		int index = 0;

		while (!dayStart.after(dayEnd)) {
			if (dayStart.get(Calendar.DAY_OF_WEEK) == weekday) {
				arrDate[index++] = dayStart.getTime();
				dayStart.add(Calendar.DAY_OF_MONTH, 7);
			} else {
				dayStart.add(Calendar.DAY_OF_MONTH, 1);
			}
		}
		return Arrays.copyOfRange(arrDate, 0, index);
	}
	
	public static Date getLastSunday(int year, int weekday) {
		Date[] arrDate = DateUtils.getAllWeekdaysInYear(year, weekday);
		return arrDate[arrDate.length - 1];
	}

	public static void showAllWeekday(int year, int weekday) {
		Date[] arrDate = DateUtils.getAllWeekdaysInYear(year, weekday);
		for (int i = 0; i < arrDate.length; i++) {
			System.out.println(df.format(arrDate[i]));
		}
	}

	public static void inputDate(Calendar date) throws DateException {
		System.out.print("Input year : ");
		int year = Integer.parseInt(ip.nextLine());
		System.out.print("Input month : ");
		int month = Integer.parseInt(ip.nextLine());
		System.out.print("Input day : ");
		int day = Integer.parseInt(ip.nextLine());

		if (year > date.get(Calendar.YEAR) || year <= 0) {
			throw new DateException("Year cannot be greater than current year");
		}
		if (month < 0 || month > 12) {
			throw new DateException("INVALID MONTH !!!!");
		}
		if (day < 0 || day > date.getActualMaximum(Calendar.DAY_OF_MONTH)) {
			throw new DateException("INVALID DAY !!!!");
		}

		date.set(year, month - 1, day);
	}

	public static void inputDating(Calendar dayStart, Calendar dayEnd) {
		while (true) {
			try {
				DateUtils.inputDate(dayStart);
				break;
			} catch (DateException e) {
				e.getMessage();
				System.out.println("=========================");
				System.out.println("Entering a valid date : ");
			}
		}
		System.out.println("Are you break up ? ");
		System.out.println("Enter 1 for YES || 2 for NO");
		int chon;
		while (true) {
			chon = Integer.parseInt(ip.nextLine());
			if (chon == 1 || chon == 2) {
				break;
			}
			System.out.println("Enter 1 for YES || 2 for NO");
		}
		switch (chon) {
		case 1: {
			while (true) {
				try {
					DateUtils.inputDate(dayEnd);
					break;
				} catch (DateException e) {
					e.getMessage();
					System.out.println("=========================");
					System.out.println("Entering a valid date : ");
				}
			}
			break;
		}
		case 2: {
			break;
		}
		default:
			return;
		}

		DateUtils.DatingInformation(dayStart, dayEnd);
	}

	public static void dateInformation(Calendar date) {
		while (true) {
			try {
				DateUtils.inputDate(date);
				break;
			} catch (DateException e) {
				e.getMessage();
				System.out.println("=========================");
				System.out.println("Entering a valid date : ");
			}
		}

		System.out.println("======================================================");
		System.out.println(date.get(Calendar.DAY_OF_MONTH) + " " + DateUtils.getMonthAsString(date.get(Calendar.MONTH))
				+ " " + date.get(Calendar.YEAR) + " is a "
				+ DateUtils.getWeekDayAsString(date.get(Calendar.DAY_OF_WEEK)));
		System.out.println("Additional facts : ");

		int dayLeft = date.getActualMaximum(Calendar.DAY_OF_YEAR) - date.get(Calendar.DAY_OF_YEAR);

		System.out.println(
				"It is day number " + date.get(Calendar.DAY_OF_YEAR) + " of the year " + dayLeft + " days left");

		Date[] days = DateUtils.getAllWeekdaysInYear(date.get(Calendar.YEAR), date.get(Calendar.DAY_OF_WEEK));
		for (int i = 0; i < days.length; i++) {
			if (days[i].getDate() == date.get(Calendar.DAY_OF_MONTH)
					&& days[i].getMonth() == date.get(Calendar.MONTH)) {
				System.out.println("It is " + DateUtils.getWeekDayAsString(date.get(Calendar.DAY_OF_WEEK)) + " number "
						+ (i + 1) + " out of " + days.length + " in " + date.get(Calendar.YEAR));
				break;
			}

		}

		Date[] arrDays = DateUtils.nofWeekDays(date.get(Calendar.YEAR), date.get(Calendar.MONTH),
				date.get(Calendar.DAY_OF_WEEK));
		int i = 0;

		for (i = 0; i < arrDays.length; i++) {
			if (arrDays[i].getDate() == date.get(Calendar.DAY_OF_MONTH)) {
				break;
			}
		}

		System.out.println("It is " + DateUtils.getWeekDayAsString(date.get(Calendar.DAY_OF_WEEK)) + " number "
				+ (i + 1) + " out of " + arrDays.length + " in " + DateUtils.getMonthAsString(date.get(Calendar.MONTH))
				+ " " + date.get(Calendar.YEAR));

		System.out.println(
				"Year " + date.get(Calendar.YEAR) + " has " + date.getActualMaximum(Calendar.DAY_OF_YEAR) + " days");
		System.out.println(DateUtils.getMonthAsString(date.get(Calendar.MONTH)) + " " + date.get(Calendar.YEAR)
				+ " has " + date.getActualMaximum(Calendar.DAY_OF_MONTH) + " days");

	}

	public static void DatingInformation(Calendar DateStart, Calendar DateEnd) {

		System.out.println(
				"The date to start  is : " + DateUtils.getWeekDayAsString(DateStart.get(Calendar.DAY_OF_WEEK)));

		long duration = DateEnd.getTimeInMillis() - DateStart.getTimeInMillis();

		long days = TimeUnit.MILLISECONDS.toDays(duration);
		duration = duration - TimeUnit.DAYS.toMillis(days);

		long hours = TimeUnit.MILLISECONDS.toHours(duration);
		duration = duration - TimeUnit.HOURS.toMillis(hours);

		long minutes = TimeUnit.MILLISECONDS.toMinutes(duration);
		duration = duration - TimeUnit.MINUTES.toMillis(minutes);

		long second = TimeUnit.MILLISECONDS.toSeconds(duration);
		duration = duration - TimeUnit.SECONDS.toMillis(second);

		System.out.println(
				"You have been dating for : " + days + " days " + hours + "h: " + minutes + "m: " + second + "s");

	}

	public static Date[] nofWeekDays(int year, int month, int weekday) {
		Date[] days = new Date[100];
		Calendar dayStart = Calendar.getInstance();
		dayStart.set(year, month, 1);
		Calendar dayEnd = Calendar.getInstance();
		dayEnd.set(year, month, dayStart.getActualMaximum(Calendar.DAY_OF_MONTH));
		int i = 0;
		while (!dayStart.after(dayEnd)) {
			int tmp = dayStart.get(Calendar.DAY_OF_WEEK);
			if (tmp == weekday) {
				days[i++] = dayStart.getTime();
				dayStart.add(Calendar.DAY_OF_MONTH, 7);
			} else {
				dayStart.add(Calendar.DAY_OF_MONTH, 1);
			}
		}

		return Arrays.copyOfRange(days, 0, i);
	}

	public static void dateOfNY(Calendar cal) {
		cal = Calendar.getInstance();
		TimeZone ny = TimeZone.getTimeZone("America/New_York");
		DateFormat dfny = new SimpleDateFormat(DATE_PATTERN_TIME);
		dfny.setTimeZone(ny);
		cal.setTimeZone(ny);
		System.out.println("Time in New York : " + dfny.format(cal.getTime()));
		System.out.println("TimeZone : " + cal.getTimeZone().getID());
		System.out.println("TimeZone Name : " + cal.getTimeZone().getDisplayName());
	}

	public static int nubDaysOfMonth(Calendar date) {
		return date.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	public static void lastDayOfMonth(Calendar date) {
		int lastDay = date.getActualMaximum(Calendar.DAY_OF_MONTH);
		date.set(Calendar.DAY_OF_MONTH, lastDay);
		System.out.println("lastDayOfMonth : " + df.format(date.getTime()));
	}

	public static void FirstLastDaysInW(Calendar date) {
		date = Calendar.getInstance();
		int dow = date.get(Calendar.DAY_OF_WEEK);
		int fdow = date.getFirstDayOfWeek();
		date.add(Calendar.DAY_OF_MONTH, fdow - dow);

		System.out.println("First day of Week  now : " + df.format(date.getTime()));

		date.add(Calendar.DAY_OF_MONTH, 7);
		System.out.println("Last day of Week now : " + df.format(date.getTime()));
	}

	public static int countWeek(Calendar date) {
		date = Calendar.getInstance();
		Calendar dayStart = Calendar.getInstance();
		dayStart.set(date.get(Calendar.YEAR), Calendar.JANUARY, 1);

		int dowS = dayStart.get(Calendar.DAY_OF_WEEK);
		int fdowS = dayStart.getFirstDayOfWeek();

		if (fdowS != dowS) {
			dayStart.add(Calendar.DAY_OF_MONTH, (fdowS + (7 - dowS)));
		}

		int dowD = date.get(Calendar.DAY_OF_WEEK);
		int fdowD = date.getFirstDayOfWeek();

		date.add(Calendar.DAY_OF_MONTH, fdowD - dowD);

		Calendar dayEnd = Calendar.getInstance();
		dayEnd.set(date.get(Calendar.YEAR), Calendar.DECEMBER, dayEnd.getActualMaximum(Calendar.DAY_OF_MONTH));

		int count = 0;
		while (!dayStart.after(dayEnd)) {
			count++;
			dayStart.add(Calendar.DAY_OF_MONTH, 7);

			if (dayStart.get(Calendar.MONTH) == date.get(Calendar.MONTH)
					&& dayStart.get(Calendar.DAY_OF_MONTH) == date.get(Calendar.DAY_OF_MONTH)) {
				count++;
				break;
			}
		}
		return count;
	}

	public static void addH(Calendar date, int hour) {
		date = Calendar.getInstance();
		date.add(Calendar.HOUR_OF_DAY, hour);
		System.out.println("ADD " + hour + " hours to the current day : " + dft.format(date.getTime()));
	}

	public static void addD(Calendar date, int day) {
		date = Calendar.getInstance();
		date.add(Calendar.DAY_OF_MONTH, day);
		System.out.println("Add " + day + " days to the current day : " + df.format(date.getTime()));
	}

	public static void distanceDate(Calendar a, Calendar b) {
		while (true) {
			try {
				System.out.println("Input Date 1  ");
				DateUtils.inputDate(a);
				System.out.println("Input Date 2  ");
				DateUtils.inputDate(b);
				break;
			} catch (DateException e) {
				e.getMessage();
				System.out.println("===================");
				System.out.println("Entering a valid date !!!");
			}
		}

		DateUtils.DatingInformation(a, b);
	}

	public static int remainMonthInY(Calendar date) {
		return Calendar.DECEMBER - date.get(Calendar.MONTH);
	}

	public static int age(Calendar date, int yearBirthday) {
		if (yearBirthday > date.get(Calendar.YEAR)) {
			throw new DateException("YearBirthday cannot be  greater than current year !!!");
		}
		return date.get(Calendar.YEAR) - yearBirthday;
	}
}
