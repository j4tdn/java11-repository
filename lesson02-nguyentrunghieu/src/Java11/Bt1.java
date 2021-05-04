package Java11;

import java.util.Scanner;

public class Bt1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 0;
		while (true) {
			System.out.print("Nhap so nguyen duong: ");
			n = Integer.parseInt(sc.nextLine());
			System.out.println(check(n));
		}
	}

	public static boolean check(int n) {
		if (n == 1) {
			return true;
		}
		if (n % 2 != 0) {
			return false;
		}
		return check(n /= 2);
	}
}
