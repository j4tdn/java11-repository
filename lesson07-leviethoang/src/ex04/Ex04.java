package ex04;

import java.util.Calendar;

import utils.DateUtils;

public class Ex04 {

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		System.out.println("Date now : " + DateUtils.toString(c.getTime()));
		System.out.println("TimeZone : " + c.getTimeZone().getID());
		System.out.println("TimeZone Name : " + c.getTimeZone().getDisplayName());

		System.out.println("===========================");
		Calendar cal = Calendar.getInstance();
		DateUtils.dateOfNY(cal);
		System.out.println("============================");
		System.out.println("Number days of Month : " + DateUtils.nubDaysOfMonth(c));
		DateUtils.lastDayOfMonth(c);
		DateUtils.FirstLastDaysInW(c);
		System.out.println("The current week is the " + DateUtils.countWeek(c) + " week");
		DateUtils.addH(c, 8);
		Calendar a = Calendar.getInstance();
		Calendar b = Calendar.getInstance();
		DateUtils.distanceDate(a, b);
		DateUtils.addD(c, 20);
		System.out.println("Remaining months of the year is :  " + DateUtils.remainMonthInY(c) + " months");
		System.out.println("Your age is : "  + DateUtils.age(c, 2000));
	}




}
