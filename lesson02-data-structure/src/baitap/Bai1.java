package baitap;

import java.util.Scanner;

public class Bai1 {

	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		int n;
		do {
			System.out.print("Nhap n: ");
			n = ip.nextInt();
			if (n <= 0) {
				System.out.println("Nhap sai. Moi nhap lai!\n");
				continue;
			}
			if (LaLuyThua2(n)) {
				System.out.println(n + " la luy thua cua 2");
			} else {
				System.out.println(n + " khong la luy thua cua 2");
			}
		} while (n <= 0);
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
