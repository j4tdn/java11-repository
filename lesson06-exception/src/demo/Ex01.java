package demo;

import java.time.LocalDate;
import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		System.out.println("Main Start");
		Scanner ip = new Scanner(System.in);
		System.out.print("Enter year of birth : ");
		int yob = ip.nextInt();
		
		System.out.println("Age :" + (LocalDate.now().getYear() - yob + 1));
		System.out.println("Main End");
	}
}
