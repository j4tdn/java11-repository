package ex01;

import java.time.DayOfWeek;
import java.time.LocalDate;

import utils.LocalDateTimeUtils;

public class Ex01Java08 {
	public static void main(String[] args) {		
		LocalDate date = LocalDate.now();
		
		LocalDateTimeUtils.showAllWeekday(date.getYear(), DayOfWeek.SUNDAY);
		System.out.println("LastSunDay : " +
		LocalDateTimeUtils.toStringD(LocalDateTimeUtils.getLastWeekDay(date.getYear(), DayOfWeek.SUNDAY)));

	}
}
