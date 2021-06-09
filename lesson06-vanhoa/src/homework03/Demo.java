package homework03;

import java.util.Scanner;

public class Demo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String email;

		System.out.println("=================*Email*===============");
		while (true) {
			try {
				System.out.print("Enter your email: ");
				email = sc.nextLine();
				incorrectEmail(email);
				break;
			} catch (EmailException e) {
				e.printStackTrace();
			}
		}

	}

	public static boolean incorrectEmail(String email) throws EmailException {
		int countAt = 0;
		for (int i = 0; i < email.length(); i++) {
			if (email.charAt(i) == '@') {
				countAt++;
			}
		}
		if (countAt != 1) {
			throw new EmailException("The email you entered is not valid");
		}
		if (email.charAt(0) == '@' || email.charAt(email.length()) == '@') {
			throw new EmailException("The email you entered is not valid");
		}
		return true;
	}
}
