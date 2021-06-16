package ex01;

import java.util.Calendar;

import utils.DateUtils;

public class Ex01Java07 {

	public static void main(String[] args) {
		DateUtils.showAllWeekday(2021, Calendar.SUNDAY);
		System.out.println("LastSunday :" + DateUtils.toStringYMH(DateUtils.getLastSunday(2021, Calendar.SUNDAY)));
	}

	

}
