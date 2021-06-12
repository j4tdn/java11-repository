package exercises;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Ex03 {
	public static void main(String[] args) {
		System.out.println(inputEmail());
	}

	public static String inputEmail() {
		Scanner sc = new Scanner(System.in);
		String email = "";
		String email_partern = "[\\w&&[^0-9]][\\w.]{8,30}[@][a-zA-Z]{3,8}[.][a-z]{3,8}[.]?[a-z]*[a-z]$";
		boolean check = false;
		do {
			System.out.println("Enter your email");
			email = sc.nextLine();
			System.out.println("the name which you have entered " + email + " " + Pattern.matches(email_partern, email));
			check = Pattern.matches(email_partern, email);
		} while (!check);
		return email;
	}
}
