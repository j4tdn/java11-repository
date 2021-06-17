package ex01;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class App_Java07 {

	private static SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.print("Nhập năm: ");
		int year = ip.nextInt();
		System.out.println("=================================");
		System.out.println("Tất cả các ngày chủ nhật trong năm: ");
		getAllSundaysInYear(year);
		System.out.println("=================================");
		System.out.println("Ngày chủ nhật cuối cùng trong năm: ");
		getLastSunday(year);
	}

	private static void getAllSundaysInYear(int year) {
		Calendar dayStart = Calendar.getInstance();
		dayStart.set(year, 0, 1);
		Calendar dayEnd = Calendar.getInstance();
		dayEnd.set(year, 11, 31);
		while (!dayStart.after(dayEnd)) {
			int fdow = dayStart.getFirstDayOfWeek();
			dayStart.add(Calendar.DAY_OF_MONTH, fdow - dayStart.get(Calendar.DAY_OF_WEEK));
			dayStart.add(Calendar.DAY_OF_YEAR, 7);
			if (dayStart.get(Calendar.YEAR) > year) {
				break;
			}
			System.out.println(df.format(dayStart.getTime()));
		}
	}

	private static void getLastSunday(int year) {
		Calendar dayStart = Calendar.getInstance();
		dayStart.set(year, 0, 1);
		Calendar dayEnd = Calendar.getInstance();
		dayEnd.set(year, 11, 31);
		while (!dayStart.after(dayEnd)) {
			int fdow = dayStart.getFirstDayOfWeek();
			dayStart.add(Calendar.DAY_OF_MONTH, fdow - dayStart.get(Calendar.DAY_OF_WEEK));
			dayStart.add(Calendar.DAY_OF_YEAR, 7);
			if (dayStart.get(Calendar.YEAR) > year) {
				dayStart.add(Calendar.DAY_OF_YEAR, -7);
				break;
			}
		}
		System.out.println(df.format(dayStart.getTime()));
	}
}
