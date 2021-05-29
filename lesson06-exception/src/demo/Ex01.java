package demo;

import java.time.LocalDate;
import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		
		System.out.println("main start");
		
		System.out.println("Enter year of birth: ");
		//int yearOfBirth = ip.nextInt();
		int yearOfBirth = Integer.parseInt(ip.nextLine());
		
		System.out.println("Age: " + (LocalDate.now().getYear() - yearOfBirth +1));
	
		System.out.println("main end");
	}

}
