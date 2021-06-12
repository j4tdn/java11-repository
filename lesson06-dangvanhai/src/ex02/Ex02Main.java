package ex02;

import java.util.Scanner;

public class Ex02Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter password: ");
		while (true) {
			try {
				ValidatePassword(scanner.nextLine());
				System.out.println("=> OK");
				scanner.close();
				break;
			} catch (PasswordException e) {
				e.printStackTrace();
				System.out.println("Enter again:");
			}
		}
	}

	private static boolean ValidatePassword(String password) throws PasswordException {
		if (!password.matches(".{8,}")) {
			throw new PasswordException("At least 8 characters");
		}
		if (!password.matches(".{8,256}")) {
			throw new PasswordException("At most 256 characters");
		}
		if (!password.matches(".*([a-z]+).*")) {
			throw new PasswordException("At least 1 lowercase alpha character (a,b,c...)");
		}
		if (!password.matches(".*([A-Z]+).*")) {
			throw new PasswordException("At least 1 uppercase alpha character (A,B,C...)");
		}
		if (!password.matches(".*([0-9]+).*")) {
			throw new PasswordException("At least 1 number (1,2,3...)");
		}
		if (!password.matches(".*[~!@#$%^&*\\(\\)\\-_=\\+\\]\\[}{|;:,.<>]+.*")) {
			throw new PasswordException("At least 1 special character");
		}
		return true;
	}
}
