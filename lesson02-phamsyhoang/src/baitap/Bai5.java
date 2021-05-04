package baitap;

import java.util.Scanner;
import java.util.Stack;

public class Bai5 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.print("Nhập số cần chuyển đổi: ");
		int n = ip.nextInt();
		String(n);
	}

	private static void String(int n) {
		System.out.print("Số " + n + " ở hệ cơ số 2 là: ");
		Stack st = new Stack();
		int a;
		String b[];
		while (n > 0) {
			a = n % 2;
			n = n / 2;
			st.push(a);
		}
		while (!st.empty()) {
			System.out.print(st.pop());
		}
	}
}
