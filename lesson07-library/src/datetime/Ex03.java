package datetime;

import java.util.Calendar;

import utils.DateUtils;

public class Ex03 {
	public static void main(String[] args) {
		//count number of SUNDAYs in this month	
		//System.out.println("number of sundays:" + nofWeekDays(5, 2021, Calendar.SUNDAY));
	int[] weekdays = {1,2,3,4,5,6,7};
	for (int weekday:weekdays) {
		String wdAsStr = DateUtils.getWeekDayAsString(weekday);
		System.out.println("number of " + wdAsStr + ":" + nofWeekDays(5, 2021, weekday));
		}
	}
	
	//month = 8, year 2021
	//weekday = 1(Sunday) 2(Monday)
	private static int nofWeekDays(int month, int year, int weekday) {
		Calendar dayStart = Calendar.getInstance();	//ngay hien tai 12.06.2021
		dayStart.set(year, month, 1); //01.08.2021 
		
		Calendar dayEnd = Calendar.getInstance(); //12.06.2021 => 30 ngay
		dayEnd.set(year, month, dayStart.getActualMaximum(Calendar.DAY_OF_MONTH) ); //31.08.2021
		//dayEnd.add(Calendar.DAY_OF_MONTH,1); //cong 1 de sang ngay 1 thang moi	
		//a<=b <=>tuong duong vs !a>b
		
	//	System.out.println("day Start: " + DateUtils.toString(dayStart.getTime()));
	//	System.out.println("day End: " + DateUtils.toString(dayEnd.getTime()));
		
		
		//number of day_of_week
		int count = 0;
		//
		while(!dayStart.after(dayEnd)) { //before, after bat dau chay tu den truoc (sau) < dayEng
		//System.out.println("day Start: " + DateUtils.toString(dayStart.getTime()));
			int tmp = dayStart.get(Calendar.DAY_OF_WEEK);
			if (tmp == weekday) {
				count++;
				dayStart.add(Calendar.DAY_OF_MONTH, 7);
			}
			else {
				dayStart.add(Calendar.DAY_OF_MONTH, 1);
			}
//			dayStart.add(Calendar.DAY_OF_MONTH,1);
		}
		
		return count;
	}

}

