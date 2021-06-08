package ex02;

import java.util.Scanner;
import java.util.regex.Pattern;

public class App {
	public static void main(String[] args) {

		String regex = "(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[~!@#%^&*()-_+=\\[\\]\\{\\}\\|;:,\\.<>/\\?]).{8,256}";
		String pass;
		boolean check = false;
		Scanner sc = new Scanner(System.in);

		while (true) {

			try {
				System.out.print("Enter password: ");
				pass = sc.nextLine();
				check = Pattern.matches(regex, pass);
				if (check) 
				{
					System.out.println("Password is correct");
					break;
				}
				else System.out.println("Password is incorrect!");

			} catch (RuntimeException e) {
				e.printStackTrace();
			}
		}
	}
}
