package ex01;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AppJava7 {
	private static String[] dayList = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };
	static DateFormat df = new SimpleDateFormat("EEEE dd/MM/yyyy");

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list = getAllDayInYear(2021, "FRI");
		System.out.println("All days in year:\n======");
		for (int i = 0; i < list.size(); i++) {
			System.out.println((i + 1) + ". " + list.get(i));
		}
		System.out.println("Last date: " + getLastDay(2021, "FRI"));
	}

	/***
	 * Get all dates in year
	 * 
	 * @param year input
	 * @param date input
	 * @return dayList output
	 */
	private static List<String> getAllDayInYear(int year, String dateStr) {
		Calendar dayStart = Calendar.getInstance();
		Calendar dayEnd = Calendar.getInstance();
		int dateNum = 0;
		List<String> list = new ArrayList<String>();

		dayStart.set(year, 0, 1);
		dayEnd.set(year, 11, 31);
		for (int i = 1; i <= 7; i++) {
			if (dayList[i].equals(dateStr)) {
				dateNum = i + 1;
				break;
			}
		}
		while (dayStart.get(Calendar.DAY_OF_WEEK) != dateNum) {
			dayStart.add(Calendar.DAY_OF_MONTH, 1);
		}
		while (!dayStart.after(dayEnd)) {
			list.add(df.format(dayStart.getTime()));
			dayStart.add(Calendar.DAY_OF_MONTH, 7);
		}
		return list;
	}

	/***
	 * Get last date of year
	 * 
	 * @param year    input
	 * @param dateStr input
	 * @return day info
	 */
	private static String getLastDay(int year, String dateStr) {
		Calendar dayEnd = Calendar.getInstance();
		int dayNum = 0;
		dayEnd.set(year, 11, 31);
		for (int i = 1; i <= 7; i++) {
			if (dayList[i].equals(dateStr)) {
				dayNum = i + 1;
				break;
			}
		}
		while (dayEnd.get(Calendar.DAY_OF_WEEK) != dayNum) {
			dayEnd.add(Calendar.DAY_OF_MONTH, -1);
		}
		return df.format(dayEnd.getTime());
	}
}
