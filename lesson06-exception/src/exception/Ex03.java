package exception;

import java.time.LocalDate;
import java.util.Scanner;

public class Ex03 {
	private static Scanner ip = new Scanner(System.in);
	public static void main(String[] args) {
		String ageText ="";
		while(true)
		{System.out.println("Enter your age: ");
		ageText = ip.nextLine();
		if(ageText.matches("\\d+"))
			break;
			System.out.println("--- Invalid Age ---");
		}
		int age = Integer.parseInt(ip.nextLine());
		int currentYear = LocalDate.now().getYear();
		System.out.println("your age: "+(currentYear-age+1));
	}
}
