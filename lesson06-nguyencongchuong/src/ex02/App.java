package ex02;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
	public static void main(String[] args) {
		while (true)
			try {
				System.out.println(password());
				break;
			} catch (PassException e) {
				System.out.println(e.getMessage());
			}

	}

	private static String password() throws PassException {
		int countLowerCase = 0;
		int countUpperCase = 0;
		int countDigit = 0;
		String print = "Đăng ký tài khoản thành công!";
		Scanner ip = new Scanner(System.in);
		System.out.print("Nhập mật khẩu: ");
		String pass = ip.nextLine();
		if (pass.length() < 8 || pass.length() > 256) {
			throw new PassException("Mật khẩu phải từ 8 đến 256 ký tự!");
		}

		for (int i = 0; i < pass.length(); i++) {
			if (Character.isLowerCase(pass.charAt(i))) {
				countLowerCase++;
			}
		}
		for (int i = 0; i < pass.length(); i++) {
			if (Character.isUpperCase(pass.charAt(i))) {
				countUpperCase++;
			}
		}
		for (int i = 0; i < pass.length(); i++) {
			if (Character.isDigit(pass.charAt(i))) {
				countDigit++;
			}
		}

		if (countLowerCase < 1) {
			throw new PassException("Mật khẩu phải có ít nhất 1 ký tự thường!");
		}
		if (countUpperCase < 1) {
			throw new PassException("Mật khẩu phải có ít nhất 1 ký tự hoa!");
		}
		if (countDigit < 1) {
			throw new PassException("Mật khẩu phải có ít nhất 1 ký tự số!");
		}

		// regex
		Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(pass);
		boolean b = m.find();

		if (!b) {
			throw new PassException("Mật khẩu phải có ít nhất 1 ký tự đặc biệt!");
		}
		return print;
	}
}
