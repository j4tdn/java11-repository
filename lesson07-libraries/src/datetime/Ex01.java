package datetime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import utils.DateUtils;


public class Ex01 {
	String[] months = {"JAN"};
	
	private static DateFormat df = new SimpleDateFormat("dd/MM/yyyy EEEE" );
	public static void main(String[] args) {
		// JAVA07 : Month 0 - 11 => JAN - DEC
		
		Date date = new Date();
		System.out.println("date :" + date);
		
	//	Locale.setDefault(Locale.FRANCE);
		Calendar c = Calendar.getInstance();
		System.out.println("calendar : "+ c);
		System.out.println("=================");
		int day = c.get(Calendar.DAY_OF_MONTH);
		int month = c.get(Calendar.MONTH);
		int year = c.get(Calendar.YEAR);
	
		System.out.println("d/m/y :" + day  + "/" + (month + 1) + "/" + year);
		int hour12 = c.get(Calendar.HOUR);
		int hour24 = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);
		System.out.println("h:m:ss >> " + hour12 + " : " + minute + " : " + second + " " + Calendar.AM);
		
		// set time
	//	c.set(Calendar.MONTH, Calendar.JULY);
		
		// number of days in month , year
		int daysInMonth = c.getActualMaximum(Calendar.DAY_OF_MONTH); // 30
		int dom = c.getMaximum(Calendar.DAY_OF_MONTH); // 31 MAX MONTH
		System.out.println(daysInMonth);
		System.out.println(dom);
		System.out.println(Calendar.WEEK_OF_MONTH);
		
		int dow = c.get(Calendar.DAY_OF_WEEK);
		System.out.println("days of week  : " + dow);
		
		
		// first days of week
		int fow = c.getFirstDayOfWeek();
		System.out.println("first day of week : " + fow);
		
		// fdow_num  = current_day - fdow + dow   
		
		c.add(Calendar.DAY_OF_MONTH, fow -  c.get(Calendar.DAY_OF_WEEK));
		System.out.println("c :" + c);
		
		int index = 1;
		while(index <= 7) {
			System.out.println(df.format(c.getTime()));
			c.add(Calendar.DAY_OF_MONTH, 1);
			index ++;
		}
		
		c.set(Calendar.YEAR, 2020);
		System.out.println("IsLeapYear : " + DateUtils.isLeapYear(Calendar.YEAR));
		
		System.out.println("FROM EPOCH : " + c.getTimeInMillis());
	}
}
