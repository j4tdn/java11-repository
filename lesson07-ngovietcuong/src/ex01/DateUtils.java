package ex01;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import javax.swing.text.DateFormatter;

public class DateUtils {

	private static DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

	public static Calendar toCalendar(int year, int month, int day) {
		Calendar c = Calendar.getInstance();
		c.set(year, month, day);
		return c;
	}

	public static void getAllSundaysInYear() {
		Calendar dayStart = Calendar.getInstance();
		dayStart.set(dayStart.get(Calendar.YEAR), Calendar.JANUARY, 1);

		Calendar dayEnd = Calendar.getInstance();
		dayEnd.set(dayStart.get(Calendar.YEAR), Calendar.DECEMBER, 31);

		System.out.println("Cac ngay chu nhat trong nam " + dayStart.get(Calendar.YEAR));

		while (!dayStart.after(dayEnd)) {
			if (dayStart.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
				System.out.println(df.format(dayStart.getTime()));
				dayStart.add(Calendar.DAY_OF_MONTH, 7);
			} else {
				dayStart.add(Calendar.DAY_OF_MONTH, 1);
			}

		}

	}

	public static void getLastSunday(int year) {
		Calendar dayStart = Calendar.getInstance();
		dayStart.set(year, Calendar.DECEMBER , 1);

		Calendar dayEnd = Calendar.getInstance();
		dayEnd.set(year, Calendar.DECEMBER , 31);

		System.out.println("Ngay chu nhat cuoi cung cua nam " + dayStart.get(Calendar.YEAR));
		
		while (!dayStart.after(dayEnd)) {
			if (dayStart.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
				dayStart.add(Calendar.DAY_OF_MONTH, 7);
			} else {
				dayStart.add(Calendar.DAY_OF_MONTH, 1);
			}
         }
		dayStart.add(Calendar.DAY_OF_MONTH, - 7);
		System.out.println(df.format(dayStart.getTime()));
	}

}
