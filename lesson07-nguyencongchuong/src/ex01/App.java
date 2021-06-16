package ex01;

import java.util.Calendar;

import utils.DateUtils;

public class App {
	public static void main(String[] args) {
		getAllSundaysInYear(2021);
		getLastSunday(2021);
	}

	private static void getAllSundaysInYear(int year) {
		Calendar dayStart = DateUtils.getCalendar(year, 0, 1);
		Calendar dayEnd = DateUtils.getCalendar(year, 11, 31);

		
		while (!dayStart.after(dayEnd)) {
			int tmp = dayStart.get(Calendar.DAY_OF_WEEK);
			if (tmp == Calendar.SUNDAY) {
				System.out.println(DateUtils.toString(dayStart.getTime()));
			}
			dayStart.add(Calendar.DAY_OF_YEAR, 1);
		}
	}
	
	private static void getLastSunday(int year) {
		Calendar dayStart = DateUtils.getCalendar(year, 11, 24);
		Calendar dayEnd = DateUtils.getCalendar(year, 11, 31);
		
		while (!dayStart.after(dayEnd)) {
			int tmp = dayEnd.get(Calendar.DAY_OF_WEEK);
			if(tmp == Calendar.SUNDAY) {
				System.out.println("Last Sunday of the year: " + DateUtils.toString(dayEnd.getTime()));
			}
			dayEnd.add(Calendar.DAY_OF_WEEK, -1);
		}
	}
}
