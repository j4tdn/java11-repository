package ex06;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.print("Nhập vị trí thứ K cần tìm: ");
		int k = ip.nextInt();
		String s = "1234567891011121314";
		location(k, s);
	}

	private static void location(int k, String s) {
		int count = 0;
		while (s.length() < 1000) {
			s = s.concat(s);
		}
		System.out.println("Giá trị thứ K trong chuỗi là: " + s.charAt(k));
	}
}
