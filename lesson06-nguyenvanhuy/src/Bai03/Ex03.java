package Bai03;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exception.EmailException;

public class Ex03 {
	public static void main(String[] args) {
		while (true) {
			try {
				System.out.println(validateEmail());
				break;
			} catch (EmailException e) {
				// TODO: handle exception
				// e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}
	}

	public static String validateEmail() throws EmailException {
		Scanner sc = new Scanner(System.in);
		System.out.print("Input your email: ");
		String email = sc.nextLine();
		
		Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher m = pattern.matcher(email);
		boolean check = m.find();

		if (!check) {
			throw new EmailException("Email invalid");
		}
		return "Email Valid";
	}
}