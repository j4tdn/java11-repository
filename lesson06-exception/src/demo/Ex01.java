package demo;

import java.time.LocalDate;
import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		System.out.println("Main start");
		Scanner ip = new Scanner(System.in);
		int count = 0;
		int y = 0;
		while (true) {
			try {
				// InputMismatchException
				// int y = ip.nextInt();
				System.out.print("Enter year of birth: ");
				y = Integer.parseInt(ip.nextLine());
				System.out.println("===========OK==========");
				break;
			} catch (NumberFormatException e) {
				// contains exception information and root cause
				// e.printStackTrace();
				// System.out.println(e.getMessage());
				System.out.println("Invalid number " + ++count +"times !!!");
				if (count == 3) {
					System.out.println("Wrong entering time exceed 3 times >> OUT");
					break;
				}
			}
		}
		if (y != 0) {
			System.out.println("Age: " + (LocalDate.now().getYear() - y + 1));
		}
		System.out.println("Main end");
	}
}
