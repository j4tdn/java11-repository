package ex03;

import java.time.LocalDate;

import utils.LocalDateTimeUtils;

public class Ex03Java08 {
	public static void main(String[] args) {
		LocalDate date = LocalDate.of(1995, 9, 25);
		LocalDateTimeUtils.DateInfo(date);
	}
}
