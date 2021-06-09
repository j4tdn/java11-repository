package view;

import java.util.Scanner;

import java.util.regex.Pattern;

public class Ex01 {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int a = 0;
		int b = 0;
		while (true) {
			try {
				a = nhapSo("a");
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		while (true) {
			try {
				b = nhapSo("b");
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("Nghiệm của phương trình x = " + (float) -b / a);
	}

	public static int nhapSo(String value) throws Exception {
		System.out.print("Nhập Số " + value + ": ");
		String x = sc.nextLine();
		if (!Pattern.matches("[0-9]+", x)) {
			throw new Exception("Lỗi nhập sai kiểu dữ liệu");
		}
		if (value == "b" && x == "0") {
			throw new Exception("Lỗi chia cho 0");
		}
		return Integer.parseInt(x);
	}

}
