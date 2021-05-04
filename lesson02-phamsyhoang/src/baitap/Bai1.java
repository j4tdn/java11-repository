package baitap;

import java.util.Scanner;

public class Bai1 {

	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.print("Nhap n: ");
		int n = ip.nextInt();
		if (LaLuyThua2(n)) {
			System.out.println(n + " la luy thua cua 2");
		} else {
			System.out.println(n + " khong la luy thua cua 2");
		}
	}

	private static boolean LaLuyThua2(int n) {
		while (n > 0 && n % 2 == 0) {
			n /= 2;
		}
		if (n == 1) {
			return true;
		}
		return false;

	}

}
