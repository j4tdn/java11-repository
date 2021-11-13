package datatime;

import java.util.Calendar;
import java.util.Date;

import utils.DateUtils;

public class Ex03 {
	public static void main(String[] args) {
		// Print all curent weekdays
		Calendar c = Calendar.getInstance();// 24.06.2021
		c.set(Calendar.MONTH, Calendar.FEBRUARY);
		c.set(Calendar.YEAR, 2020);

		System.out.println("Year ActualMaxDays: " + c.getActualMaximum(Calendar.DAY_OF_YEAR));
		System.out.println(" ActualMaxDays: " + c.getActualMaximum(Calendar.DAY_OF_MONTH));
		System.out.println("MaxDays: " + c.getActualMaximum(Calendar.DAY_OF_MONTH));
		// get first day of week
		c.add(Calendar.DAY_OF_MONTH, c.getFirstDayOfWeek() - c.get(Calendar.DAY_OF_WEEK));

		System.out.println(c);
		System.out.println("==============================================");
		printWeekdays(c);
		//printDaysInMonth(c);
		Date date = DateUtils.toDate("");
		System.out.println("Date: "+date);
	}

	private static void printWeekdays(Calendar c) {

		int day = 1;
		while (day <= 7) {
			System.out.println(DateUtils.format(c));
			c.add(Calendar.DAY_OF_MONTH, 1);
			day++;
		}
	}

	private static void printDaysInMonth(Calendar c) {
		int daysInMonth = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		int day = 1;
		while (day <= daysInMonth) {
			System.out.println(c);
			c.add(Calendar.DAY_OF_MONTH, 1);
			day++;
		}
	}
}
