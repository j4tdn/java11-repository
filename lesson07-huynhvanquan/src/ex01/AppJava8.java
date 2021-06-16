package ex01;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AppJava8 {
	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		List<String> list = new ArrayList<String>();

		list = getAllDayInYear(2021, "SUNDAY");
		System.out.println("All days in year:\n======");
		for (int i = 0; i < list.size(); i++) {
			System.out.println((i + 1) + ". " + list.get(i));
		}
		System.out.println("Last date: " + getLastDayInYear(2021, "SUNDAY"));
	}

	public static List<String> getAllDayInYear(int year, String dateStr) {
		List<String> list = new ArrayList<String>();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dayStart = LocalDate.of(year, 1, 1);
		LocalDate dayEnd = LocalDate.of(year, 12, 31);

		while (!dayStart.isAfter(dayEnd)) {
			if (String.valueOf(dayStart.getDayOfWeek()).equals(dateStr)) {
				list.add(dtf.format(dayStart));
				dayStart = dayStart.plusDays(7);
			} else {
				dayStart = dayStart.plusDays(1);
			}
		}
		return list;
	}

	public static String getLastDayInYear(int year, String dateStr) {
		int count = 0;
		LocalDate dayEnd = LocalDate.of(year, 12, 31);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		while (count <= 7) {
			if (String.valueOf(dayEnd.getDayOfWeek()).equals(dateStr)) {
				return dtf.format(dayEnd);
			}
			dayEnd = dayEnd.plusDays(-1);
			++count;
		}
		return dtf.format(dayEnd);
	}

}
