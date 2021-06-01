package demo;

import java.time.LocalDate;
import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		System.out.println("main start");
		Scanner ip = new Scanner(System.in);
		int count = 0;
		int yob = 0;
		while (true) {
			try {
				System.out.println("enter year of birth: ");
				yob = Integer.parseInt(ip.nextLine());
				break;

			} catch (NumberFormatException e) {
				// contains exception information and root cause
				// 1:e.printStackTrace(); //ro nhat
			} // 2: System.out.println(e.getMessage());

			System.out.println("invalid number !!! " + ++count + " time");
			if (count == 3) {
				System.out.println("========");
				System.out.println("wrong entering times exceed time>>out");
				break;
			}
		}

		if (yob != 0) {
			System.out.println("age: " + (LocalDate.now().getYear() - yob + 1));
		}
		System.out.println("main end");

	}
}
