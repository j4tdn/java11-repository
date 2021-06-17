package ex01;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.Locale;
import java.util.Scanner;

public class App_Java08 {
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
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dayStart = LocalDate.of(year, 1, 1);
		LocalDate dayEnd = LocalDate.of(year, 12, 31);
		while (!dayStart.isAfter(dayEnd)) {

			if (dayStart.getDayOfWeek() == DayOfWeek.SUNDAY) {
				System.out.println(dtf.format(dayStart));
			}
			if (dayStart.getYear() > year) {
				break;
			}
			dayStart = dayStart.plusDays(1);
		}
	}

	private static void getLastSunday(int year) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dayStart = LocalDate.of(year, 1, 1);
		LocalDate dayEnd = LocalDate.of(year, 12, 31);
		while (!dayStart.isAfter(dayEnd)) {
			dayStart = dayStart.with(WeekFields.of(Locale.US).dayOfWeek(), 1L);
			dayStart = dayStart.plusDays(7);
			if (dayStart.getYear() > year) {
				dayStart = dayStart.plusDays(-7);
				System.out.println(dtf.format(dayStart));
				break;
			}
		}

	}
}
