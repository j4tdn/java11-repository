package ex02;

import java.util.Calendar;
import java.util.Date;

import utils.DateUtils;

public class App {
	public static void main(String[] args) {
		String dayStart = "14/03/2021";
		Calendar c = DateUtils.toCalendar(DateUtils.toDate(dayStart));
	    System.out.println("Day start is on " + DateUtils.getWeekDayAsString(c.get(Calendar.DAY_OF_WEEK))); 
	    DateUtils.printDaysLove(dayStart);
	}
}
