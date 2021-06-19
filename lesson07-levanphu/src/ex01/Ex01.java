package ex01;

import java.util.Calendar;

import utils.DateTimeUtils;

public class Ex01 {
	public static void main(String[] args) {
		System.out.println("Sundays in year: ");
		getAllSunDayInYear(2021);
		System.out.println("Last Sunday of year: ");
		getLastSunday(2021);
	}

	private static void getAllSunDayInYear(int year) {
		Calendar dayStart = Calendar.getInstance();
		dayStart.set(year, 1, 1);

		Calendar dayEnd = Calendar.getInstance();
		dayEnd.set(year, 12, 31);
		while (!dayStart.after(dayEnd)) {
			if (dayStart.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
				System.out.println(DateTimeUtils.toString(dayStart.getTime()));
				dayStart.add(Calendar.DAY_OF_YEAR, Calendar.MONDAY);
			} else {
				dayStart.add(Calendar.DAY_OF_YEAR, Calendar.SUNDAY);
			}
		}
	}

	private static void getLastSunday(int year) {
		
		Calendar dayStart = Calendar.getInstance();
		dayStart.set(year, 1, 24);

		Calendar dayEnd = Calendar.getInstance();
		dayEnd.set(year, 12, 31);
		
		while (!dayStart.after(dayEnd)) {
			int tmp = dayEnd.get(Calendar.DAY_OF_WEEK);
			if(tmp == Calendar.SUNDAY) {
				System.out.println( DateTimeUtils.toString(dayEnd.getTime()));
				break;
			}
			dayEnd.add(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		}
	}
}

