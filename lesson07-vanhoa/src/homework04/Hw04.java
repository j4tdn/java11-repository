package homework04;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Hw04 {
	private static DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm:ss");
	private static DateTimeFormatter dft = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private static String[] weekdays = { "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY" };

	public static void main(String[] args) {
		// 1. Show time in NewYork
		LocalDateTime datetimeNY = LocalDateTime.now(ZoneId.of("America/New_York"));
		System.out.println("Time in New York, US now: " + df.format(datetimeNY));

		// 2. How many days are there in current month?
		LocalDate date = LocalDate.now();
		System.out.println("The days of the current month is: " + date.lengthOfMonth());

		// 3. show the last day of the current month
		LocalDate lastDayOfMonth = date.withDayOfMonth(date.lengthOfMonth());
		System.out.println("Last day of current month is: " + dft.format(lastDayOfMonth));

		// 4. show the first and last days of current week (Monday is first day)
		int num = 0;
		for (int i = 0; i < 7; i++) {
			if (String.valueOf(date.getDayOfWeek()) == weekdays[i]) {
				num = i + 1;
			}
		}
		System.out.println("The first day of week is: " + date.minusDays(num));
		System.out.println("The last day of week is: " + date.plusDays(7 - num));
		
		// 5. week of year
		LocalDate count = LocalDate.now().withDayOfYear(01);
		int countWeek = 0;
		while(count.isBefore(date)) {
			countWeek++;
			count = count.plusWeeks(1);
		}
		System.out.println("current week is " + countWeek + " of 52 in " + count.getYear());
		
		// 6. add 8 hours
		LocalDateTime datetime = LocalDateTime.now().plusHours(8);
		System.out.println("datetime add 8 hours: " + df.format(datetime));
		
		// 7. check 2 time
		LocalDate anotherDay = LocalDate.of(2022, 6, 12);
		Period period = Period.between(date, anotherDay);
		System.out.println("period: " + period.getYears() + " Y " + period.getMonths() + " M");
		
		// 8. check after 20 days
		System.out.println("after 20 days is: " + date.plusDays(20));
		
		// 9. check month left of year
		int ml = 12 - date.getMonthValue();
		System.out.println("month left of year: " + ml);
		
		// 10. calculate my age
		LocalDate birthDay = LocalDate.of(1999, 06, 19);
		Period age = Period.between(birthDay, date);
		System.out.println("my age: " + age.getYears() + "Y" + age.getMonths() + "M" + age.getDays() + "D");
		
	}
}
