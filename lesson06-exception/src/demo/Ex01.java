package demo;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		System.out.println("Main start");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter age: ");
		int yob = scanner.nextInt();
		System.out.println("Age: " + (LocalDate.now().getYear() - yob + 1));
		System.out.println("Main end");
	}
}
