package datetime;

import java.util.Calendar;
import utils.DateUtils;

public class Ex04 {
	public static void main(String[] args) {
		// Count number of Sunday(s) in this month
		countNofSundays(Calendar.MARCH, 2021);
	}

	// month: 3 && year: 2018
	private static int countNofSundays(int month, int year) {
		int count = 0;

		Calendar start = Calendar.getInstance(); // 28.06.2021
		start.set(year, month, 1); // 01.06.2021

		Calendar end = Calendar.getInstance();// 28.06.2021
		end.set(year, month, start.getActualMaximum(Calendar.DAY_OF_MONTH));

		for (Calendar date = start; !date.after(end); date.add(Calendar.DAY_OF_MONTH, 1)) {
			if (date.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
				System.out.println(DateUtils.format(date));
				count++;
			}
		}

		return count;
	}
}
