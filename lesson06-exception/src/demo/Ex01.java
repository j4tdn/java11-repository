package demo;

import java.time.LocalDate;
import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		System.out.println("Main start");
		Scanner ip = new Scanner(System.in);
		
		System.out.println("Enter year of birth: ");
		// int yob = ip.nextInt();
		int  yob = Integer.parseInt(ip.nextLine());
		System.out.println("Age: " + (LocalDate.now().getYear() - yob));
		System.out.println("Main end");
		
	}

}
