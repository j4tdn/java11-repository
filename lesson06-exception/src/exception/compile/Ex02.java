package exception.compile;

import java.time.LocalDate;
import java.util.Scanner;

public class Ex02 {
	private static Scanner ip = new Scanner(System.in);
	public static void main(String[] args) {
		int age = -1;
		while(true)
		{
			try
			{
				System.out.println("Enter your year of birth: ");
				age = Integer.parseInt(ip.nextLine());
				break;
			}catch (NumberFormatException e) {
				System.out.println("---Invaliad Age ---");
			}
		}
		int currentYear = LocalDate.now().getYear();
		System.out.println("your age: "+(currentYear-age+1));
		System.out.println("thread main end !");
	}
}
