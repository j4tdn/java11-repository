package java07;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class Ex04{
	private static DateFormat df = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");

	public static void main(String[] args) {
		getTimeInNewYork();
		totalDayOfMonths();
		lastDateOfMonth();
		firstAndLastDayOfWeek();
		getTimeInNewYork();
		totalDayOfMonths();
		lastDateOfMonth();

		firstAndLastDayOfWeek();
		weekInYear();
		System.out.println();
		addMore8Hour();

		Calendar current = Calendar.getInstance();
		Calendar history = Calendar.getInstance();
		history.set(Calendar.YEAR, 1998);
		history.set(Calendar.MONTH, 11);
		duration(history, current);
		after20days();
		remainMonthInYear();
	}

	private static void getTimeInNewYork() {
		Calendar calNewYork = Calendar.getInstance();

		TimeZone tz = TimeZone.getTimeZone("America/New_York");

		df.setTimeZone(tz);

		System.out.println(df.format(calNewYork.getTime()));

	}

	private static void totalDayOfMonths() {
		Calendar cal = Calendar.getInstance();
		System.out.println("2. " + cal.getActualMaximum(Calendar.DAY_OF_MONTH));
	}

	private static void lastDateOfMonth() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		System.out.println("3. " + df.format(cal.getTime()));
	}

	private static void firstAndLastDayOfWeek() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, 1);
		System.out.println("4. " + df.format(cal.getTime()));

		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		System.out.println("4. " + df.format(cal.getTime()));

	}

	private static void weekInYear() {
		Calendar cal = Calendar.getInstance();
		System.out.println("5. " + cal.get(Calendar.WEEK_OF_YEAR));
	}

	private static void addMore8Hour() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.HOUR, 8);
		System.out.println("6. " + df.format(cal.getTime()));
	}

	private static void duration(Calendar start, Calendar end) {
		int year = end.get(Calendar.YEAR) - start.get(Calendar.YEAR);
		int month = Math.abs(end.get(Calendar.MONTH) - start.get(Calendar.MONTH));
		System.out.println("7. " + year + " year " + month + " month");

	}

	private static void after20days() {
		Calendar cal = Calendar.getInstance();
		System.out.println("8. " + df.format(cal.getTime()));
		cal.add(Calendar.DATE, 20);
		System.out.println("8. " + df.format(cal.getTime()));
	}

	private static void remainMonthInYear() {
		Calendar cal = Calendar.getInstance();
		System.out.println("9. " + (12 - cal.get(Calendar.MONTH) - 1));
	}

	private static void age() {
		Calendar current = Calendar.getInstance();
		Calendar dayOfBirth = Calendar.getInstance();
		duration(dayOfBirth, current);
	}
}