package ex03;

import java.util.Scanner;
import java.util.regex.Pattern;

public class App {
	public static void main(String[] args) {
		String regex = "[^@][0-9a-zA-Z]*@([a-z]+\\.[a-z]+|[a-z]+\\.[a-z]+\\.[a-z]+)";
		String mail;
		boolean check = false;
		Scanner sc = new Scanner(System.in);
		while (true) {

			try {
				System.out.print("Enter password: ");
				mail = sc.nextLine();
				check = Pattern.matches(regex, mail);
				if (check) 
				{
					System.out.println("Email is correct");
					break;
				}
				else System.out.println("Email is incorrect!");

			} catch (RuntimeException e) {
				e.printStackTrace();
			}
		}
	}
}
