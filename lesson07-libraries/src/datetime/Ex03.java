package datetime;

import java.util.Calendar;

import utils.DateUtils;

public class Ex03 {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		int[] weekdays = { 1, 2, 3, 4, 5, 6, 7 };

		for (int weekday : weekdays) {
			String wdAsStr = DateUtils.getWeekDayAsString(weekday);
			System.out.println("Number of " + wdAsStr + ": " + nofWeekDays(5, 2021, weekday));
		}
	}

	private static int nofWeekDays(int month, int year, int weekday) {
		Calendar dayStart = Calendar.getInstance();
		dayStart.set(year, month, 1);

		Calendar dayEnd = Calendar.getInstance();
		dayEnd.set(year, month, dayStart.getActualMaximum(Calendar.DAY_OF_MONTH));

//		System.out.println("dayStart " + DateUtils.toString(dayStart.toString()));
//		System.out.println("dayEnd " + DateUtils.toString(dayEnd.toString()));

		int count = 0;
		while (!dayStart.after(dayEnd)) {
			int tmp = dayStart.get(Calendar.DAY_OF_WEEK);
			if (tmp == weekday) {
				count++;
				dayStart.add(Calendar.DAY_OF_MONTH, 7);
			} else {
				dayStart.add(Calendar.DAY_OF_MONTH, 1);
			}
		}

		return count;
	}
}
