package exception;

import java.time.LocalDate;
import java.util.Scanner;

public class Ex03 {
	
	private static Scanner ip = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		// Enter your year of birth => Calculate your age
		
		String ageText = "";
		while(true) {
			System.out.println("Enter your year of birth: ");
			ageText = ip.nextLine();
			// REGular EXpression = regex
			// \d: digit [0-9]
			// + : amount 1, n number
			if(ageText.matches("\\d+")) {
				break;
			}
			System.out.println("--- Invalid Age ---");
		}
		
		int age = Integer.parseInt(ageText);
		
		int currentYear = LocalDate.now().getYear();
		System.out.println("Your age: " + (currentYear - age + 1));
		
		
	}
}
