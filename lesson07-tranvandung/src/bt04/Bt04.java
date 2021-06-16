package bt04;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;

import utils.DateUtils;

public class Bt04 {
	private static SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy EEE");

	public static void main(String[] args) {
		// 1:nowtime in NewYork
		System.out.println("==1==");
		LocalDateTime datetime = LocalDateTime.now(ZoneId.of("America/New_York"));
		System.out.println("America/New_York Time: " + datetime);
		
		// 2:Number days in month
		System.out.println("==2==");
		Calendar c = Calendar.getInstance();
		System.out.println("daysInMonth: " + c.getActualMaximum(Calendar.DAY_OF_MONTH));
		
		//3:LastDayOfMonth
		System.out.println("==3==");
		Calendar nowDate = Calendar.getInstance();
		int d  = nowDate.get(Calendar.DAY_OF_MONTH);
		int ld = nowDate.getActualMaximum(Calendar.DAY_OF_MONTH);
		for (int i = 0; i <= ld; i++) {
			if (d == ld) {
				System.out.println("The Last Day Of Month: " + DateUtils.toString(nowDate.getTime()));
			}
			d++;
			nowDate.add(Calendar.DAY_OF_MONTH, 1);
		}
		
		//4:firstday and lastday in week
		System.out.println("==4==");
		Calendar nowDate1 = Calendar.getInstance();
		int fdow = nowDate1.getFirstDayOfWeek();
		int weekend = fdow + 6;
		
		nowDate1.set(Calendar.DAY_OF_WEEK, fdow);
		System.out.println("First day of week: " + DateUtils.toString(nowDate1.getTime()));

		nowDate1.set(Calendar.DAY_OF_WEEK, weekend);
		System.out.println("End day of week : " + DateUtils.toString(nowDate1.getTime()));
		
		//5:nowtime in week of year
		System.out.println("==5==");
		int woy = nowDate1.get(Calendar.WEEK_OF_YEAR);
		System.out.println("Now Week of year: " + woy);
		
		//6:plus 8 hours to nowtime
		System.out.println("==6==");
		LocalDateTime nowtime = LocalDateTime.now();
		System.out.println("time after plus: " + nowtime.plusHours(8));
		
		//7,9:Period time
		System.out.println("==7==");
		LocalDate date = LocalDate.now();
		System.out.println("date: " + date);

		LocalDate anotherDate = LocalDate.of(2021, 12, 31);
		System.out.println("anotherDate:" + anotherDate);

		
		Period period =Period.between(date, anotherDate);
		System.out.println("period: " + period);
		System.out.println("toString: " + period.getYears() + "Year"
										+ period.getMonths()+ "Months"
										+ period.getDays()  + "Days");
		
		//8:time after 20 days
		System.out.println("==8==");
		LocalDate htDay = LocalDate.now();
		System.out.println("Date after 20 days: " + htDay.plusDays(20) + " " + htDay.getDayOfWeek());
		
		//10:my age
		System.out.println("==10==");
		LocalDate date1 = LocalDate.now();
		System.out.println("date: " + date1);

		LocalDate anotherDate1 = LocalDate.of(1999, 2, 4);
		System.out.println("anotherDate:" + anotherDate1);

		
		Period period1 =Period.between(anotherDate1,date1);
		System.out.println("period: " + period1);
		System.out.println("toString: " + period1.getYears() + "Year"
										+ period1.getMonths()+ "Months"
										+ period1.getDays()  + "Days");
		
	}
}
