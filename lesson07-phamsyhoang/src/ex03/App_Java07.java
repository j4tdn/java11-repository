package ex03;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class App_Java07 {

	private static String[] months = { "JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST",
			"SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER" };
	private static String[] weekdays = { "SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY" };
	private static SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		c.set(1995, 8,25);
		funtion(c);
	}

	private static void funtion(Calendar c) {
		String weekday = weekdays[c.get(Calendar.DAY_OF_WEEK)-1];
		System.out.println(c.get(Calendar.DAY_OF_MONTH) + " " + months[c.get(Calendar.MONTH)] + " "
				+ c.get(Calendar.YEAR) + " is a " + weekday);
		System.out.println("It is day number " + c.get(Calendar.DAY_OF_YEAR) + " of the year, "
				+ (c.getActualMaximum(Calendar.DAY_OF_YEAR) - c.get(Calendar.DAY_OF_YEAR)) + " days left");
		System.out.println("It is " +weekday+ " number " + c.get(Calendar.WEEK_OF_YEAR)+ " out of " + c.getActualMaximum(Calendar.WEEK_OF_YEAR) + " in 1995");
		
		dayInMonth(c);
		
		System.out.println("Year " + c.get(Calendar.YEAR) + " has " + c.getActualMaximum(Calendar.DAY_OF_YEAR) + " days" );
		System.out.println(months[c.get(Calendar.MONTH)] + " " + c.get(Calendar.YEAR) + " has " + c.getActualMaximum(Calendar.DAY_OF_MONTH) + " days");
	}

	private static void dayInMonth(Calendar c) {
		Calendar dayStart = Calendar.getInstance();
		Calendar dayEnd = Calendar.getInstance();
		dayStart.set(c.get(Calendar.YEAR), (c.get(Calendar.MONTH)), 1);
		dayEnd.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.getActualMaximum(Calendar.DAY_OF_MONTH));
		int count=0;
		int dim=0;
		
		while(!dayStart.after(dayEnd)) {
			if(dayStart.get(Calendar.DAY_OF_WEEK)==c.get((Calendar.DAY_OF_WEEK))) {
				count++;
				dim++;
				if (dayStart.get(Calendar.DATE)==c.get(Calendar.DATE)) {
					System.out.print("It is " + weekdays[c.get(Calendar.DAY_OF_WEEK)-1] + " number " + count);
				}
			}
			
			dayStart.add(Calendar.DAY_OF_MONTH, 1);
		}
		System.out.println(" out of " + dim + " in " + months[c.get(Calendar.MONTH)] + " " + c.get(Calendar.YEAR));
	
	}
}
