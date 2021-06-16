package ex03;

import java.util.Calendar;

import utils.DateTimeUtils;

public class App {
	public static void main(String[] args) {
		String ip = "25/09/1995";
		Calendar c = DateTimeUtils.toCalendar(DateTimeUtils.toDate(ip));
		int dayMaxOfYear = c.getActualMaximum(Calendar.DAY_OF_YEAR);
		int dayOfYear = c.get(Calendar.DAY_OF_YEAR);

		System.out
				.println("It is day number " + dayOfYear + " of the year " + (dayMaxOfYear - dayOfYear) + " days left");

		int dayMaxYear = c.getActualMaximum(Calendar.DAY_OF_YEAR);
		System.out.println("Year " + c.get(Calendar.YEAR) + " has " + dayMaxYear + " days");

		int dayMaxMonth = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println("September:  " + c.get(Calendar.YEAR) + " has " + dayMaxMonth + " days ");
	}
}
