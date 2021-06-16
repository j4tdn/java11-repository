package ex02;

import java.util.Calendar;
import java.util.Scanner;
import utils.DateUtils;

public class Ex02Java07 {
	static Scanner ip = new Scanner(System.in);

	public static void main(String[] args) {
		Calendar dayStart = Calendar.getInstance();
		Calendar dayEnd = Calendar.getInstance();
		DateUtils.inputDating(dayStart, dayEnd);

	}


}
