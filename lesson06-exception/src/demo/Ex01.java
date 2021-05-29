package demo;

import java.time.LocalDate;
import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		
		Scanner ip = new Scanner(System.in);
		System.out.println("Enter year of birth: ");
		int yob = ip.nextInt(); // input missmatchexception
		
		System.out.println("Age: " + (LocalDate.now().getYear() - yob + 1));
	}
	
}
