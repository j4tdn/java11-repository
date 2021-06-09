package exercises;

import exception.MyException;

public class Ex02 {
	public static void main(String[] args) {

		String email = "phuongthao@gmail.com";
		String name = "thao";

		String pass = "Hihi@123";

		try {
			chekPass(name, email, pass);
			System.out.println("Your pass is set succrssfully");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private static boolean chekPass(String name, String email, String pass) throws MyException {
		if (pass.contains(email) || pass.contains(name)) {
			throw new MyException("Your pass must not contain your name or email");
		}
		if (pass.length() < 8) {
			throw new MyException("Your pass at least 8 character");
		}
		if (pass.length() > 256) {
			throw new MyException("Your pass at most 256 character");
		}
		if (!pass.matches(".*[a-z].*")) {
			throw new MyException("Your pass at least 1 lowercase alphabetic character !");
		}
		if (!pass.matches(".*[A-Z].*")) {
			throw new MyException("Your pass at least 1 uppercase alphabetic character !");
		}
		if (!pass.matches(".*[0-9].*")) {
			throw new MyException("Your pass at least 1 number !");
		}
		if (!pass.matches(".*[^A-Za-z0-9].*")) {
			throw new MyException("Your pass at least 1 special character !");
		}

		return true;
	}
}
