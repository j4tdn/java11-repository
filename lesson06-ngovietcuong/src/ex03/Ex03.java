package ex03;

import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		while (true) {
			try {
				System.out.print("Nhap dia chi email: ");
				String email = ip.nextLine();
				test(email);
				System.out.println("Nhap thanh cong");
				break;
			} catch (EmailException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private static boolean onlyOne(String ip) {
		int count = 0;
		for (int i = 0; i < ip.length(); i++) {
			if (ip.charAt(i) == '@') {
				count++;
			}
			if (count > 1) {
				return false;
			}
		}
		return true;
	}

	private static boolean firstLast(String ip) {
		if (ip.charAt(0) == '@' || ip.charAt(ip.length() - 1) == '@') {
			return false;
		}
		return true;
	}

	public static void test(String ip) {
		if (ip.length() < 8 || ip.length() > 256) {
			throw new EmailException("Nhap it nhat 8 ky tu va nhieu nhat 256 ky tu");
		}
		if (firstLast(ip) == false) {
			throw new EmailException("Ky tu @ khong the o dau tien hoac cuoi cung");
		}
		if (onlyOne(ip) == false) {
			throw new EmailException("Dia chi email chua duy nhat 1 ky tu @");
		}
		
	}
}
