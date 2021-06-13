package utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class DateUtils {
	private static final String DATE_PATTERN = "dd/MM/yyyy";
	private static final String DATE_TIME_PATTERN = "dd/MM/yyyy HH:mm:ss EEEE";
	private static String[] months = { "JAN", "FEB", "FEB", "MAR", "APR", "MAY", "JUNE", "JULY", "AUG", "SEP", "OCT",
			"NOV", "DEC" };
	private static String[] weekdays = { "SUN", "MON", "TUE", "WEB", "THUR", "FRI", "SAT" };
	private static DateFormat df = new SimpleDateFormat(DATE_PATTERN);
	private static DateFormat dtf = new SimpleDateFormat(DATE_TIME_PATTERN);
	private static GregorianCalendar gc = new GregorianCalendar();

	private DateUtils() {
	}

	public static boolean isLeapYear(int year) {
		return gc.isLeapYear(year);
	}

	public static String getWeekDayAsString(int weekDayAsNumber) {
		// 1 - 7
		//
		//
		return weekdays[weekDayAsNumber - 1];
	}

	public static Date toDate(Calendar c) {
		Objects.requireNonNull(c);
		return c.getTime();
	}

	/**
	 * Convert to Date from given text with format dd/MM/yyyy
	 * 
	 * @param text input
	 * @return converted Date
	 */
	public static Date toDate(String text) {
		if (text == null || text.isEmpty()) {
			throw new IllegalArgumentException();
		}
		Date date = null;
		try {
			date = df.parse(text);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * Convert to Calendar from given date E.g: 10.10.1990 >> Epoch time. 01.01.1970
	 * >> Date Calendar
	 * 
	 * @param date
	 * @return converted Calendar
	 */
	public static Calendar toCalendar(Date date) {
		Objects.requireNonNull(date);
		Calendar c = Calendar.getInstance();
		// long dateInMillis = date.getTime();
		// c.setTimeInMillis(dateInMillis);
		c.setTime(date);
		return c;
	}

	/**
	 * Get calendar from given year, month, day
	 * 
	 * @param year
	 * @param month
	 * @param day
	 * @return calendar
	 */
	public static Calendar setCalendar(int year, int month, int day) {
		Calendar c = Calendar.getInstance();
		c.set(year, month, day);
		return c;
	}

	/**
	 * Convert to String from given date with format dd/MM/yyyy HH:mm:ss EEEE
	 * 
	 * @param date
	 * @return
	 */
	public static String toString(Date date) {
		Objects.requireNonNull(date);
		return df.format(date);
	}
	
	/**
	 * 
	 * @param year
	 * @param weekday
	 */
	
	public static void getAllWeekDaysInYear (int year, int weekday) {
		Calendar dayStart = Calendar.getInstance();
		dayStart.set(year, 0, 1);
		
		Calendar dayEnd = Calendar.getInstance();
		dayEnd.set(year, 11, 31);	
		
		int count = 0;
		
		while (!dayStart.after(dayEnd)) {
			if (dayStart.get(Calendar.DAY_OF_WEEK) == weekday) {
				System.out.println(toString(dayStart.getTime()));
				dayStart.add(Calendar.DAY_OF_YEAR, 7);
				count++;
			}
			else {
				dayStart.add(Calendar.DAY_OF_YEAR, 1);
			}
			
			if (dayStart.compareTo(dayEnd) > 0) {
				int day = dayStart.get(Calendar.DAY_OF_YEAR);
				dayStart.set(Calendar.DAY_OF_YEAR, day - 7);
				System.out.println("The Last Sunday is: " + toString(dayStart.getTime()));
				break;
			}
		}
		
		System.out.println("Total of Sundays in year: " + count);
	}
	
	public static void printDaysLove(String dayLove) {
		Calendar today = Calendar.getInstance();
		Calendar dayStart = toCalendar(toDate(dayLove));
		
		if(dayStart.after(today)) {
			throw new RuntimeException("born cannot greated than today!");
		}
		
		long startInMillis = dayStart.getTimeInMillis();
		long todayInMillis = today.getTimeInMillis();
		
		long duration = todayInMillis - startInMillis;
		
		long days = TimeUnit.MILLISECONDS.toDays(duration);
		duration -= TimeUnit.DAYS.toMillis(days);
		
		long hours = TimeUnit.MILLISECONDS.toHours(duration);
		duration -= TimeUnit.HOURS.toMillis(hours);
		
		long minutes = TimeUnit.MILLISECONDS.toMinutes(duration);
		duration -= TimeUnit.MINUTES.toMillis(minutes);
		
		long seconds = TimeUnit.MILLISECONDS.toSeconds(duration);
		duration -= TimeUnit.SECONDS.toMillis(seconds);
		
		System.out.println(days + "D "
				+ hours + "H "
				+ minutes + "M "
				+ seconds + "S "
				+ duration + "MS"
			);
	}
}