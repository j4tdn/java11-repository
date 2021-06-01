package demo;

import java.time.LocalDate;
import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		System.out.println("Main start");
		
		Scanner ip = new Scanner(System.in);
		System.out.println("Enter year of birth: ");
		//int yob = ip.nextInt(); // input Mismatch Exception
		
		int yob = Integer.parseInt(ip.nextLine()); //Number format Exception
		System.out.println("age: " + (LocalDate.now().getYear() - yob + 1));
		System.out.println("Main end");
	}
}
