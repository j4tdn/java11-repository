package datetime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import utils.DateUtils;

public class Ex02 {
	
	private static final String DDMMYYY = "dd/MM/YYY";
	private static DateFormat df = new SimpleDateFormat(DDMMYYY);
	
	public static void main(String[] args) {
		// 21.06.2021
		// Locale: Country, Language
		
		//Locale.setDefault(new Locale("vi", "VN"));
		System.out.println("dafault locale: "+ Locale.getDefault());
	
		Calendar c = Calendar.getInstance(new Locale("vi", "VN"));
		c.set(Calendar.DAY_OF_MONTH, 16);
		// 16.06.2021
		int firstDayOfWeek = c.getFirstDayOfWeek();
		System.out.println("firstDayOfWeek: " + firstDayOfWeek);
	
		c.add(Calendar.DAY_OF_MONTH, c.getFirstDayOfWeek() - c.get(Calendar.DAY_OF_WEEK));
		System.out.println("date: " + df.format(c.getTime()));
		
		c.set(Calendar.YEAR, 2020);
		System.out.println("isLeapYear: " + DateUtils.isLeapYear(c.get(Calendar.YEAR)));
	}
}
