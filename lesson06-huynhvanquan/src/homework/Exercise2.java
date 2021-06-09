package homework;

import java.util.Scanner;

// Check password - Regular Expression
public class Exercise2 {
	public static void main(String[] args) {
		String password = "";
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("Enter password: ");
			password = sc.nextLine();
			try {
				// ^: matches the start of target string;
				// $: matches the end of target string
				// .: matches one any character except line-break and unicode character
				// {8, 256}: range [8,256], $: Matches the end of target string
				// => match string have 8-256 characters
				if (!password.matches("^.{8,256}$")) {
					throw new ExceptionLength();
				}

				// .: matches one any character except line-break and unicode character
				// .*: have one or more of any characters
				// [0-9]: have digit in range [0;9]
				// ".*[0-9].*": Have one or more digits from first position to last position
				// => match string have one or more digit
				if (!password.matches(".*[0-9].*")) {
					throw new ExceptionDigit();
				}

				// Similar above
				// ".*[a-z].*": Have zero or more alphabets from first position to last position
				// => match string have one or more alphabet
				if (!password.matches(".*[a-z].*")) {
					throw new ExceptionLowercase();
				}

				// Similar above
				if (!password.matches(".*[A-Z].*")) {
					throw new ExceptionUppercase();
				}

				// Similar above
				// matches one or more special character from first position to last position
				// => match string have one or more specical character
				if (!password.matches(".*[!@#\\$%\\^&\\*-_=+|`~;:<>,./].*")) {
					throw new ExceptionSpeChar();
				}
				System.out.println("Password is OK!");
				return;
			} catch (ExceptionLength e) {
				System.out.println("Password must have 8-256 characters.");
			} catch (ExceptionDigit e) {
				System.out.println("Password must have at least 1 number.");
			} catch (ExceptionLowercase e) {
				System.out.println("Password must have at least 1 lowercase character.");
			} catch (ExceptionUppercase e) {
				System.out.println("Password must have at least 1 uppercase character.");
			} catch (ExceptionSpeChar e) {
				System.out.println("Password must have at least 1 special character.");
			}
			System.out.println("Please enter again!");
		}

	}

}
