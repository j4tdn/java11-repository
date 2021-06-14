package ex03;

import java.util.Calendar;

import utils.DateUtils;

public class App {
	public static void main(String[] args) {
		String inputDay = "14/03/2021";
		Calendar c = DateUtils.toCalendar(DateUtils.toDate(inputDay));
		int dayMaxOfYear = c.getActualMaximum(Calendar.DAY_OF_YEAR);
		int weeksday = c.get(Calendar.DAY_OF_WEEK);
		int month = c.get(Calendar.MONTH);
		int year = c.get(Calendar.YEAR);
		
		System.out.println("It is day number " + c.get(Calendar.DAY_OF_YEAR) + " of the year " + (dayMaxOfYear - c.get(Calendar.DAY_OF_YEAR)) + " days left");
		DateUtils.getIndexDayOfyear(c, weeksday);
		DateUtils.getAllWeekDaysInMonth(c, weeksday);
		System.out.println("Year " + c.get(Calendar.YEAR) + " has " + c.getActualMaximum(Calendar.DAY_OF_YEAR) + " days");
		System.out.println(DateUtils.getMonthAsString(month) + " " + year + " has " + c.getActualMaximum(Calendar.DAY_OF_MONTH) + " days");
	}
}
