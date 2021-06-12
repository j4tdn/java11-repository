package datetime;

import java.util.Calendar;

import utils.DateUtils;

public class Ex03 {
	public static void main(String[] args) {
		// Count number of SUNDAYs in this month
		int[] weekdays = {1,2,3,4,5,6,7};
		for(int weekday : weekdays) {
			System.out.println("number of " + DateUtils.getWeekDayAsString(weekday) + ":" + nofWeekDay(5, 2021, weekday));
		}
	}
	
	private static int nofWeekDay(int month, int year, int weekday) {
		Calendar dayStart = Calendar.getInstance();
		dayStart.set(year,  month, 1);
		
		Calendar dayEnd = Calendar.getInstance();
		dayEnd.set(year, month, dayStart.getActualMaximum(Calendar.DAY_OF_MONTH));
//		System.out.println("day start: " + DateUtils.toString(dayStart.getTime()));
//		System.out.println("day end: " + DateUtils.toString(dayEnd.getTime()));
		
		int count = 0;
		while(!dayStart.after(dayEnd)) {
//			System.out.println(DateUtils.toString(dayStart.getTime()));
			int tmp = dayStart.get(Calendar.DAY_OF_WEEK);
			if(tmp == weekday) {
				count ++;
				dayStart.add(Calendar.DAY_OF_MONTH, 7);
			}else {
				dayStart.add(Calendar.DAY_OF_MONTH, 1);
			}
		}
		
		return count;
	}
}