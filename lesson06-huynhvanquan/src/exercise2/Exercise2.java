package exercise2;

import java.util.Scanner;

public class Exercise2 {
	public static void main(String[] args) {
		String password = "";
		Scanner sc = new Scanner(System.in);
		while (true) {
			try {
				System.out.print("Enter password: ");
				password = sc.nextLine();
				processPasswordException(password);
				System.out.println("Password is OK!");
				return;
			} catch (PasswordException e) {
				System.out.println(e.getMessage());
				System.out.println("Please enter again!");
			}
		}
	}

	public static void processPasswordException(String password) throws PasswordException {
		// ^: matches the start of target string;
		// $: matches the end of target string
		// .: matches one any character except line-break and unicode character
		// {8, 256}: range [8,256], $: Matches the end of target string
		// => match string have 8-256 characters
		if (!password.matches("^.{8,256}$")) {
			throw new PasswordException("Password must have 8-256 characters.");
		}
		
		// .: matches one any character except line-break and unicode character
		// .*: have one or more of any characters
		// [0-9]: have digit in range [0;9]
		// ".*[0-9].*": Have one or more digits from first position to last position
		// => match string have one or more digit
		if (!password.matches(".*[0-9].*")) {
			throw new PasswordException("Password must have at least 1 number.");
		}
		
		// Similar above
		// ".*[a-z].*": Have zero or more alphabets from first position to last position
		// => match string have one or more alphabet
		if (!password.matches(".*[a-z].*")) {
			throw new PasswordException("Password must have at least 1 lowercase character.");
		}
		
		// Similar above
		if (!password.matches(".*[A-Z].*")) {
			throw new PasswordException("Password must have at least 1 uppercase character.");
		}
		
		// Similar above
		// matches one or more special character from first position to last position
		// => match string have one or more specical character
		if (!password.matches(".*[!@#%&*].*")) {
			throw new PasswordException("Password must have at least 1 special character.");
		}
	}
}
