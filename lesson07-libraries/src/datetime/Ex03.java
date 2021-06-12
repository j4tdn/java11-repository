package datetime;

import java.util.Calendar;

import utils.DateUtils;

public class Ex03 {
   public static void main(String[] args) {
	   // Count number of SUNDAYS in this month
	Calendar c = Calendar.getInstance();
	int nowds = nofweekDays(7,2022, 1);
   int[] weekdays = {1,2,3,4,5,6,7};
   for(int weekday : weekdays) {
	   String wdAsStr = DateUtils.getWeekDayAsString(weekday);
	   System.out.println("number of: " + wdAsStr + ": " + nofweekDays(5, 2021, weekday));   
   }
   }
   
   // month = 6
   // weekday = 1 (Sunday)
   private static int nofweekDays(int month,int year,int weekday) {
	   Calendar dayStart = Calendar.getInstance();
	   dayStart.set(year, month,1);
	 
	   Calendar dayEnd = Calendar.getInstance();
	   dayEnd.set(year,month,dayStart.getActualMaximum(Calendar.DAY_OF_MONTH));
	   System.out.println("dayStart: " + DateUtils.toString(dayStart.getTime()));
	   System.out.println("dayEnd: " + DateUtils.toString(dayEnd.getTime()));
	   
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
