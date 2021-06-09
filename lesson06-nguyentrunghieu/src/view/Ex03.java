package view;

import java.util.Scanner;
import java.util.regex.Pattern;

import exception.EmailException;

public class Ex03 {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String email = "";
		while (true) {
			try {
				email = nhap();
				break;
			} catch (EmailException e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("Email: " + email);
	}

	private static String nhap() {
		System.out.print("Nhập email: ");
		String email = sc.nextLine();
		int emailLength = endWith(email);
		if (emailLength == 0) {
			throw new EmailException();
		}
		String startWith = email.substring(0, email.length() - emailLength);
		if (!Pattern.matches("[a-zA-Z0-9.]+", startWith)) {
			throw new EmailException();
		}
		return email;
	}

	private static int endWith(String email) {
		String[] endWith = { "@gmail.com", "@gmail.com.vn" };
		for (String e : endWith) {
			if (email.endsWith(e) && email.length() > e.length()) {
				return e.length();
			}
		}
		return 0;
	}
}
