package ex04;

import java.time.LocalDateTime;
import java.time.ZoneId;

import utils.DateUtils;
import utils.LocalDateTimeUtils;

public class Ex04Java08 {
	public static void main(String[] args) {
		LocalDateTime date = LocalDateTime.now();
		System.out.println("Time now : " + LocalDateTimeUtils.toString(date));
		
		LocalDateTime dateInNY = LocalDateTime.now(ZoneId.of("America/New_York"));
		System.out.println("Time in New York now : " + LocalDateTimeUtils.toString(dateInNY));

		System.out.println("Number days in " + date.getMonth() + " is : " + date.toLocalDate().lengthOfMonth());
		LocalDateTimeUtils.lastDayOfMonth(date);

		System.out.println("The current week is the " + LocalDateTimeUtils.countWeek(date) + " week");
		System.out.println(
				"ADD hours to the current day : " + LocalDateTimeUtils.toString(LocalDateTimeUtils.addH(date, 8)));
		System.out.println(
				"ADD days to the current day : " + LocalDateTimeUtils.toString(LocalDateTimeUtils.addD(date, 20)));
		System.out.println("Date between : " + LocalDateTimeUtils.between(dateInNY, date));
		System.out.println("Remaining months of the year is :  " + LocalDateTimeUtils.remainMonthInY(date) + " months");
		System.out.println("Your age is : " + LocalDateTimeUtils.age(date, 2000));
	}
}
