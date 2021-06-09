package exercise3;

import java.util.Scanner;

public class Exercise3 {
	public static void main(String[] args) {
		String email = "";
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Enter email: ");
			email = sc.nextLine();
			// ^: matches the start of target string;
			// [a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]: character must be in this range
			// [a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+: matches one or more characters in
			// range[...]
			// [a-zA-Z0-9.-]+: similar above
			// $: matches the end of target string
			if (email.matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
				System.out.println("Email is OK.");
				return;
			} else {
				System.out.println("Email is invalid. Please enter again!");
			}
		} while (true);
	}
}
