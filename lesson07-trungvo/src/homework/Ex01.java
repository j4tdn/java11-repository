package homework;

import java.util.Calendar;

import utils.Utils;

public class Ex01 {
	public static void main(String[] args) {
		 System.out.println("Sundays in year: " + getAllSundaysInYear(2021)); 
		 System.out.println("===========================================");
		 System.out.println("Last Sunday of year: ");
		 getLastSunday(2021);
		
	}
	
	
	private static int getAllSundaysInYear(int year) {
		Calendar dayStart = Calendar.getInstance();
		dayStart.set(year, Calendar.JANUARY, 1);
		
		Calendar dayEnd = Calendar.getInstance();
		dayEnd.set(year, Calendar.DECEMBER, 31);
		
		int count = 0;
		while(!dayStart.after(dayEnd)) {
			if(dayStart.get(Calendar.DAY_OF_WEEK) ==1) {
				count++;
				System.out.println(Utils.toString(dayStart.getTime()));
				dayStart.add(Calendar.DAY_OF_YEAR, 7);
			}else {
				dayStart.add(Calendar.DAY_OF_YEAR, 1);
			}
			
		}
		return count;
	}
	
	private static void getLastSunday(int year) {
		Calendar dayStart = Calendar.getInstance();
		dayStart.set(year, Calendar.JANUARY, 1);
		
		Calendar dayEnd = Calendar.getInstance();
		dayEnd.set(year, Calendar.DECEMBER, 31);
		
		while(!dayStart.after(dayEnd)) {
			if(dayEnd.get(Calendar.DAY_OF_WEEK) ==1) {
				System.out.println(Utils.toString(dayEnd.getTime()));
				//dayStart.add(Calendar.DAY_OF_YEAR, 7);
				
				break;
			}else {
				dayEnd.add(Calendar.DAY_OF_YEAR, -1);
			}
			
		}
	}
}

