package demo;

import java.time.LocalDate;
import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		
		System.out.println("Main Start");
		System.out.println("Enter year of birth: ");
		//int yob = ip.nextInt(); // InputMismatException
		int yob = Integer.parseInt(ip.nextLine()); // NumberFormatExeption
		
		System.out.println("Age: " + (LocalDate.now().getYear() - yob + 1));
		System.out.println("Main End");
	}
}
