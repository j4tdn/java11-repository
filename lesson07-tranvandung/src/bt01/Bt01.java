package bt01;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Year;
import java.util.Calendar;

import utils.DateUtils;

public class Bt01 {
	public static void main(String[] args) {
		System.out.println("Sunday Of Year");
		getAllSunDaysInYear(2021);
		System.out.println("==LastSunday Of Year==");
		LocalDate lastDay = LocalDate.of(2021, 12, 31);
		System.out.println(lastDay + " " + lastDay.getDayOfWeek());
		if(lastDay.getDayOfWeek()==DayOfWeek.MONDAY) {
			System.out.println("LastSunday is: " + lastDay.minusDays(1));
		}
		if(lastDay.getDayOfWeek()==DayOfWeek.TUESDAY) {
			System.out.println("LastSunday is: " + lastDay.minusDays(2));
		}
		if(lastDay.getDayOfWeek()==DayOfWeek.WEDNESDAY) {
			System.out.println("LastSunday is: " + lastDay.minusDays(3));
		}
		if(lastDay.getDayOfWeek()==DayOfWeek.THURSDAY) {
			System.out.println("LastSunday is: " + lastDay.minusDays(4));
		}
		if(lastDay.getDayOfWeek()==DayOfWeek.FRIDAY) {
			System.out.println("LastSunday is: " + lastDay.minusDays(5));
		}
		if(lastDay.getDayOfWeek()==DayOfWeek.SATURDAY) {
			System.out.println("LastSunday is: " + lastDay.minusDays(6));
		}
		if(lastDay.getDayOfWeek()==DayOfWeek.SUNDAY) {
			System.out.println("LastSunday is: " + lastDay);
		}
		
	}

	private static void getAllSunDaysInYear(int year) {
		Calendar dayStart = DateUtils.getCalendar(year, 0, 1);
		Calendar dayEnd   = DateUtils.getCalendar(year, 11, 31);
		while (!dayStart.after(dayEnd)) {
			int tmp = dayStart.get(Calendar.DAY_OF_WEEK);
			if (tmp == Calendar.SUNDAY) {
				System.out.println(DateUtils.toString(dayStart.getTime()));
			}
			dayStart.add(Calendar.DAY_OF_MONTH, 1);
		}

	}
}