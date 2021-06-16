package ex01;

import java.util.Calendar;

import utils.DateTimeUtils;

public class Ex01 {
	public static void main(String[] args) {
		getAllSundaysInYear(2021);

		System.out.print("Last Sunday is : ");
		getLastSunDay(2021);
	}

	private static void getAllSundaysInYear(int year) {
		Calendar dayStart = Calendar.getInstance();
		dayStart.set(year, 0, 1);

		Calendar dayEnd = Calendar.getInstance();
		dayEnd.set(year, 11, 31);

		while (!dayStart.after(dayEnd)) {
			if (dayStart.get(Calendar.DAY_OF_WEEK) == 1) {
				System.out.println(DateTimeUtils.toString(dayStart.getTime()));
				dayStart.add(Calendar.DAY_OF_YEAR, 7);
			} else {
				dayStart.add(Calendar.DAY_OF_YEAR, 1);
			}
		}
	}

	private static void getLastSunDay(int year) {
		Calendar dayStart = Calendar.getInstance();
		dayStart.set(year, 0, 1);

		Calendar dayEnd = Calendar.getInstance();
		dayEnd.set(year, 11, 31);

		while (!dayStart.after(dayEnd)) {
			if (dayEnd.get(Calendar.DAY_OF_WEEK) == 1) {
				System.out.println(DateTimeUtils.toString(dayEnd.getTime()));
				break;
			} else {
				dayEnd.add(Calendar.DAY_OF_YEAR, -1);
			}
		}

	}
}
