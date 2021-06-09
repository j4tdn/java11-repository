package ex03;

import java.util.Scanner;

public class Email {
	public static void main(String[] args) {
		String email;
		Scanner ip = new Scanner(System.in);
		while (true) {
			try {
				System.out.println("Enter Email: ");
				email = ip.nextLine();
				checkEmail(email);
				break;
			} catch (EmailException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private static void checkEmail(String email) throws EmailException {
		int count = 0;
		for (int i = 0; i < email.length(); i++) {
			if (email.charAt(i) == '@')
				count++;
		}
		if (count == 0 || count > 1)
			throw new EmailException("Invalid Email !!");
		if (email.startsWith("@") || email.endsWith("@"))
			throw new EmailException("Invalid Email !!");
		System.out.println("Correct!!");
	}
}
