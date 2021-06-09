package view;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Ex02 {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String password = "";
		while (true) {
			try {
				password = nhap();
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("Mật khẩu: " + password);
	}

	private static String nhap() throws Exception {
		System.out.print("Nhập mật khẩu của bạn: ");
		String input = sc.nextLine();
		if (input.length() < 8 || input.length() > 256) {
			throw new Exception("Mật khẩu có độ dài từ 8 -> 256");
		}
		if (!Pattern.matches(".*(?=.*[a-z]).*", input)) {
			throw new Exception("Mật khẩu có ít nhất 1 chữ thường");
		}
		if (!Pattern.matches(".*(?=.*[A-Z]).*", input)) {
			throw new Exception("Mật khẩu có ít nhất 1 chữ hoa");
		}
		if (!Pattern.matches(".*(?=.*[0-9]).*", input)) {
			throw new Exception("Mật khẩu có ít nhất 1 chử số");
		}
		if (!Pattern.matches(".*[\\p{Punct}}].*", input)) {
			throw new Exception("Mật khẩu có ít nhất 1 ký tự đặc biệt");
		}
		return input;
	}
}
