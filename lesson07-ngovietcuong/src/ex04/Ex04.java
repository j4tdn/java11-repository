package ex04;

import java.util.Calendar;


public class Ex04 {
	public static void main(String[] args) {
		System.out.println("Thoi gian hien tai o New York : " 
	                                 + DateUtils.timeNewYork());
		System.out.println("Thang hien tai co " 
	                                 + DateUtils.dayInMonth() + " ngay");
		DateUtils.lastDayOfMonth();
		DateUtils.dayFirstLastOfWeek();
     	DateUtils.add8Hour();
		DateUtils.period();
		DateUtils.checkAfter20Days();
		System.out.println("So thang con lai trong nam tu thoi diem hien tai : "
									 + DateUtils.numberOfMonths());
		DateUtils.age();
		
}

}
