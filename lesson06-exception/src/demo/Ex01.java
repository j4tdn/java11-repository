package demo;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		System.out.println("Main start");
		Scanner ip = new Scanner(System.in);
		int count = 0;
		int yob = 0;
		boolean isa = true;
		while (true) {
			try {
				System.out.println("Enter year of birth: ");
				yob = Integer.parseInt(ip.nextLine());
				break;

			} catch (NumberFormatException e) {
				// contains exception information & root cause
				// e.printStackTrace();
				// System.out.println(e.getMessage());
				System.out.println("Invalid number " + ++count + " times");
				if (count == 3) {
					System.out.println("======================");
					System.out.println("Wrong entering times exceed 3 times >> OUT");
					break;
				}

			}
		}

		if (yob != 0) {
			System.out.println("Age: " + (LocalDate.now().getYear() - yob + 1));
		}
		System.out.println("Main end");
	}
}
