package exception;

import java.time.LocalDate;
import java.util.Scanner;

public class Ex02 {
	private static Scanner ip = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter your age: ");
		int age = -1;
		while (true) {
			try {
				age = Integer.parseInt(ip.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("--- Invaliad Age ---");
			}
		}
		
		int currentYear = LocalDate.now().getYear();
		System.out.println("your age: " + (currentYear - age + 1));
		System.out.println("Thread main end !");
	}
}
