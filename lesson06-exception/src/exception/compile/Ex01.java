package exception.compile;

import java.time.LocalDate;
import java.util.Scanner;

public class Ex01 {
	private static Scanner ip = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter your year of birth: ");
		int age = Integer.parseInt(ip.nextLine());
		int currentYear = LocalDate.now().getYear();
		System.out.println("your age: "+(currentYear-age+1));
	}
}
