package demo;

import java.time.LocalDate;
import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		System.out.println("Start");
		Scanner ip = new Scanner(System.in);
		System.out.println("Enter yob: ");
		int yob = 0;
		int count = 0;
		while (true) {
			try {
				// int yob = ip.nextInt(); //InputMismatchException
				yob = Integer.parseInt(ip.nextLine()); // NumberFormatException
				break;
			} catch (NumberFormatException e) {
				// contains exception info & root cause
				// System.out.println(e.getMessage());
				// e.printStackTrace();
				System.out.println("Invalid number " + ++count + "times");
				if(count == 3) {
					System.out.println("Wrong entering times exceed 3 times");
				}
			}
		}
		
		if(yob != 0) {
			System.out.println("Age: " + (LocalDate.now().getYear() - yob + 1));
		}
		System.out.println("End");
	}
}
