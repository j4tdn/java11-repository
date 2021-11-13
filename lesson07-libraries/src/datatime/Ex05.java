package datatime;

import java.util.Calendar;

public class Ex05 {
	public static void main(String[] args) {
		int month = Calendar.OCTOBER;
		int year = 2022;
		Calendar c = Calendar.getInstance();
		c.set(year, month, 1);
		int daysInMonth = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		int firstWeekDayOfMonth = c.get(Calendar.DAY_OF_WEEK);

		System.out.println("daysInMonth: " + daysInMonth);
		System.out.println("firstWeekDayOfMonth: " + firstWeekDayOfMonth);
		int weekday = Calendar.SUNDAY;
		int fiveDays[] = null;

		switch (daysInMonth) {
		case 31:
			fiveDays = new int [3];
			fiveDays[0] =c.get(Calendar.DAY_OF_WEEK);
			c.add(Calendar.DAY_OF_MONTH, 1);
			fiveDays[1] =c.get(Calendar.DAY_OF_WEEK);
			c.add(Calendar.DAY_OF_MONTH, 1);
			fiveDays[2] =c.get(Calendar.DAY_OF_WEEK);
			break;
		case 30:
			fiveDays = new int [2];
			fiveDays[0] =c.get(Calendar.DAY_OF_WEEK);
			c.add(Calendar.DAY_OF_MONTH, 1);
			fiveDays[1] =c.get(Calendar.DAY_OF_WEEK);
			break;
		case 29:
			fiveDays = new int [1];
			fiveDays[0] = c.get(Calendar.DAY_OF_WEEK);
			break;
		}
		System.out.println("test: "+nofWeekdays(weekday,fiveDays));
	}

	private static int nofWeekdays(int weekday, int[] fiveDays) {
		for(int day: fiveDays)
		{
			System.out.println("fivedays: "+day);
			if(weekday==day)
			{
				return 5;
			}
		}
		return 4;
	}
}
