package demo;

import java.time.LocalDate;
import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		System.out.println("main start");
		Scanner ip = new Scanner(System.in);

		System.out.println("enter year of birth: ");
		//int yob = ip.nextInt(); //inputMismatchexception
		int yob = Integer.parseInt(ip.nextLine());
		System.out.println("age: " + (LocalDate.now().getYear() - yob + 1));
		System.out.println("main end");

	}
}
