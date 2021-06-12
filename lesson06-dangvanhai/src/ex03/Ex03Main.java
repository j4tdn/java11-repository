package ex03;

import java.util.Scanner;

public class Ex03Main {
	public static void main(String[] args) throws EmailException {
		Scanner scanner = new Scanner(System.in);
		String email = "";

		System.out.print("Enter email: ");
		while (true) {
			email = scanner.nextLine();
			try {
				validateEmail(email);
				System.out.println("=> OK");
				break;
			} catch (EmailException e) {
				e.printStackTrace();
				System.out.println("Enter email again: ");
			}
		}

		scanner.close();
	}

	private static boolean validateEmail(String email) throws EmailException {
		// ^[a-zA-Z0-9]+ : one or more of alphabet, number character
		// (\\.[a-zA-Z0-9]+)* : zero or more word after each dot character
		// @{1} : contains the at sign character
		// ([a-zA-Z0-9]+\\.)+ : one or more sub domain
		// [a-zA-Z]{2,} : top level domain contains only alphabet character. At least
		// contains two characters
		String regex = "^[a-zA-Z0-9]+(\\.[a-zA-Z0-9]+)*@{1}([a-zA-Z0-9]+\\.)+[a-zA-Z]{2,}$";
		
		boolean check = email.matches(regex);
		if (!check) {
			throw new EmailException("Invalid");
		}
		
		return check;
	}
}
