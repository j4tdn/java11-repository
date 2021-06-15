package localdatetime;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * 
 * Demo with Local Date
 * Pattern: Builder pattern: dung cho viec khoi tao doi tuong, khi doi tuong do co nhieu thuoc tinh.
 * co the lua chon cac thuoc tinh trong do. 
 *
 */
public class Ex01 {
	public static void main(String[] args) {
		LocalDate date = LocalDate.now()
									.withMonth(8) //set gia tri
									.withYear(2022);
		
		System.out.println("date: " + date);
		//So sanh J7 va J8: 
		//J7 phu thuoc vao Eporch (phai tim Eporch truoc xong chuyen doi, va chi den ngay gio phut giay,
		//k the den thang va nam dc. -> bat tien
		
		LocalDate anotherDate = LocalDate.of(2022,Month.AUGUST , 15)
										.plusWeeks(2);
		
		//anotherDate.plusWeeks(1); //tao ra 1 doi tuong moi cho nen cho sysout ra van ra kq cu	
		
		System.out.println("anotherDate: " + anotherDate);
		
		Period period = Period.between(date, anotherDate);
		System.out.println("period :" + period);
		System.out.println("toString: " + period.getYears() + " Y " 
										+ period.getMonths() + " M "	
										+ period.getDays() + " D ");
		
		//format
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		System.out.println("formated: " + dtf.format(date));
		}
}
