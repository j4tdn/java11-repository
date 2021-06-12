package datetime;

import java.util.Calendar;

import utils.DateUtils;

public class Ex03 {
	public static void main(String[] args) {

		int [] weekdays  = {1, 2, 3, 4, 5, 6, 7};
		
		for(int weekday : weekdays) {
		String wdAsStr = DateUtils.getWeekDayAsString(weekday);
		System.out.println("number of "+ wdAsStr + " : " +  nofWeekDays(5, 2021, weekday));
		}
	}
	
	private static int nofWeekDays(int month, int year, int weekday) {
		Calendar dayStart = Calendar.getInstance(); // 12.06.2021
		dayStart.set(year, month, 1); //01.08.2022
		
		Calendar dayEnd = Calendar.getInstance(); // 12.06.2021 => 30
		dayEnd.set(year, month, dayStart.getActualMaximum(Calendar.DAY_OF_MONTH)); // 31.08.2022
		
		int count = 0;
		
		while(!dayStart.after(dayEnd)) {
			int tmp = dayStart.get(Calendar.DAY_OF_WEEK);
			if(tmp == weekday) {
				count++;
			}
			dayStart.add(Calendar.DAY_OF_MONTH, 1);
		}
		
		return count;
	}

}



