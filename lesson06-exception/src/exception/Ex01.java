package exception;

import java.time.LocalDate;
import java.util.Scanner;

public class Ex01 {
	
	private static Scanner ip = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		// Enter your year of birth => Calculate your age
		
		System.out.println("Enter your year of birth: ");
		int age = ip.nextInt();
		
		int currentYear = LocalDate.now().getYear();
		System.out.println("Your age: " + (currentYear - age + 1));
		
		
	}
}
