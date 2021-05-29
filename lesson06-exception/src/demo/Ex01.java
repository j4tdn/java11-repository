package demo;

import java.time.LocalDate;
import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		System.out.println("Main start");
		Scanner ip = new Scanner(System.in);
		
		System.out.print("Enter year of birth: ");
		//int y = ip.nextInt();
		int y = Integer.parseInt(ip.nextLine());
		
		System.out.println("Age: " + (LocalDate.now().getYear() - y + 1));
		System.out.println("Main end");
	}
}
