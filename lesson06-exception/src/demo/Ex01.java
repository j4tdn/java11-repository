package demo;

import java.time.LocalDate;
import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		System.out.println("Main start");
		Scanner scanner = new Scanner(System.in);
		int count = 0;
		int yob = 0;
		while (true) {
			try {
				System.out.print("\nEnter year of birth: ");
				yob = Integer.parseInt(scanner.nextLine());
				break;
			} catch (NumberFormatException e) {
//				System.out.println("Hello Exception");
//				e.printStackTrace();
//				System.out.println(e.getMessage());
				System.out.println("Ivalid number! " + ++count + " times");
				if (count >= 3) {
					System.out.println("Wrong entering times exceed 3 times ");
					break;
				}
			}
		}
		scanner.close();
		System.out.println("Age: " + (LocalDate.now().getYear() - yob + 1));
		System.out.println("Main end");
	}
}
