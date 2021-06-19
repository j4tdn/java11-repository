package java8;

import java.time.DayOfWeek;
import java.time.LocalDate;

import utils.LocalDateTimeUtils;

public class Ex01 {
	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		LocalDateTimeUtils.allWeekday(date.getYear(), DayOfWeek.SUNDAY);
		System.out.println("LastSunDay : " +LocalDateTimeUtils.toString(LocalDateTimeUtils.getLastWeekday(date.getYear(), DayOfWeek.SUNDAY)));
	
	}	
}
