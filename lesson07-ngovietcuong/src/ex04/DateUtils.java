package ex04;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.sql.rowset.serial.SQLOutputImpl;

public class DateUtils {
	private static final String TIME = "dd/MM/yyy HH'H':mm'M':ss's'";
    private static DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern(TIME);
	public static DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("HH'H':mm'M':ss's'");
	private static String[] weekdays = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };

	public static String getWeekDayAsString(int weekDayAsNumber) {
	  return weekdays[weekDayAsNumber - 1];
  }
	
	public static String timeNewYork() {
		LocalDateTime l1 = LocalDateTime.now(ZoneId.of("America/New_York"));
		return dtf.format(l1);
	}

	public static int dayInMonth() {
		Calendar c = Calendar.getInstance();
		return c.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
	
	public static void lastDayOfMonth() {
		Calendar c = Calendar.getInstance();
		c.set(c.DAY_OF_MONTH, c.getActualMaximum(c.DAY_OF_MONTH));
		System.out.println("Ngay cuoi cung cua thang hien tai : " 
									+ df.format(c.getTime()));			
	}
	
	public static void dayFirstLastOfWeek() {
		Calendar c = Calendar.getInstance();
		int fdow = c.getFirstDayOfWeek();
		c.add(Calendar.DAY_OF_MONTH, fdow - c.get(Calendar.DAY_OF_WEEK) );
		System.out.println("Ngay dau tien va cuoi cua tuan hien tai : " 
							+ c.get(Calendar.DAY_OF_MONTH) + " va "
							+ ((c.get(Calendar.DAY_OF_MONTH)) + 7 ));
	
	}
	

	
	public static void add8Hour() {
		LocalTime l = LocalTime.now();
		System.out.println("Thoi gian hien tai sau khi them 8h : " 
									+ dtf1.format(l.plusHours(8)));
	
	}
	
	public static void period() {
		LocalDate start = LocalDate.of(2001, 9, 12);
		LocalDate end = LocalDate.now();
		
		Period p = Period.between(start, end);
		System.out.println("Khoang cach tu " 
		            + start.getMonthValue() + "/" + start.getYear()
		            + " den "
		            + end.getMonthValue() + "/" + end.getYear() + " la : "
		            + p.getMonths() + " month , " + p.getYears() + " year");
		
	}
	
	public static void checkAfter20Days() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_YEAR, 20);
		System.out.println("Sau khi them 20 ngay thi ngay hien tai la : "
				+ "ngay " + c.get(Calendar.DAY_OF_MONTH) 
				+ " , thu " + getWeekDayAsString(c.get(Calendar.DAY_OF_WEEK) ) );
		
	}

	public static void age() {
		LocalDate start = LocalDate.of(2001, 9, 12);
		LocalDate end = LocalDate.now();
		
		Period p = Period.between(start, end);
		System.out.println("Tuoi cua toi : " 
		       + p.getDays() + " day ," + p.getMonths() + " month , " + p.getYears() + " year");
		
	}
	
	public static int numberOfMonths() {
		Calendar c = Calendar.getInstance();
		int number = 12 - ( c.get(Calendar.MONTH) + 1 );
		return number;
	}

	
}
