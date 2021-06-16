package ex04;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Objects;

import utils.DateUtils;
import utils.LocalDateTimeUtils;

public class App {
	public static void main(String[] args) {
		System.out.println("Current time in New York: " + LocalDateTimeUtils.toString(currentTime()));
		System.out.println("Number of days in current month: " + dateOfMonth());
		endOfMonth();
		blWeek_WeekOfYear();
		add8Hours();
		System.out.println(
				"Distance between 2 timelines: " + datePeriod(LocalDate.of(2021, 1, 2), LocalDate.of(2022, 4, 2)));
		after20Days();
		System.out.println("remaining months of the year: " + remainingMonth());
		System.out.println("Age of you current: " + yearOld(LocalDate.of(1999, 10, 28)));
	}

	private static LocalDateTime currentTime() {
		LocalDateTime datetime = LocalDateTime.now(ZoneId.of("America/New_York"));
		return datetime;
	}

	private static int dateOfMonth() {
		Calendar dateCurrent = Calendar.getInstance();
		int maxDay = dateCurrent.getActualMaximum(Calendar.DAY_OF_MONTH);
		return maxDay;
	}

	private static void endOfMonth() {
		Calendar dateCurrent = Calendar.getInstance();
		int cnod = dateCurrent.get(Calendar.DAY_OF_MONTH);
		int ldom = dateCurrent.getActualMaximum(Calendar.DAY_OF_MONTH);
		for (int i = 0; i <= ldom; i++) {
			if (cnod == ldom) {
				System.out.println("The last day of the present: " + DateUtils.toString(dateCurrent.getTime()));
			}
			cnod++;
			dateCurrent.add(Calendar.DAY_OF_MONTH, 1);
		}
	}

	private static void blWeek_WeekOfYear() {
		Calendar dateCurrent = Calendar.getInstance();
		int fdow = dateCurrent.getFirstDayOfWeek();
		int weekend = fdow + 6;
		dateCurrent.set(Calendar.DAY_OF_WEEK, fdow);
		System.out.println("First day of week: " + DateUtils.toString(dateCurrent.getTime()));

		dateCurrent.set(Calendar.DAY_OF_WEEK, weekend);
		System.out.println("Weekend : " + DateUtils.toString(dateCurrent.getTime()));

		int woy = dateCurrent.get(Calendar.WEEK_OF_YEAR);
		System.out.println("Week of year: " + woy);
	}

	private static void add8Hours() {
		LocalDateTime dateCurrent = LocalDateTime.now().plusHours(8);
		System.out.println("Add 8 hours to the current time: " + LocalDateTimeUtils.toString(dateCurrent));
	}

	private static String datePeriod(LocalDate dStart, LocalDate dEnd) {
		Objects.requireNonNull(dStart);
		Objects.requireNonNull(dEnd);

		Period period = Period.between(dStart, dEnd);

		return period.getYears() + "Y " + period.getMonths() + "M";
	}
	
	private static void after20Days() {
		LocalDate dateCurrent = LocalDate.now().plusDays(20);
		DateTimeFormatter df = DateTimeFormatter.ofPattern("EEE'-'dd");
		System.out.println("After 20 days is the day: " + df.format(dateCurrent));
	}
	
	private static int remainingMonth() {
		int dateCurrent = LocalDate.now().getMonthValue();
		int rmonth = LocalDate.MAX.getMonthValue() - dateCurrent;
		return rmonth;
	}
	
	private static String yearOld(LocalDate born) {
		Objects.requireNonNull(born);
		LocalDate dateCurrent = LocalDate.now();
		
		Period period = Period.between(born, dateCurrent);
		return period.getYears() + "Y " + period.getMonths() + "M " + period.getDays() + "D";
	}
}
