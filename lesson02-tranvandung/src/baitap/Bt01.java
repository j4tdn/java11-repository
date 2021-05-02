package baitap;

import java.util.Scanner;

public class Bt01 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.print("nhap so : ");
		int n = ip.nextInt();
		if (exponential(n)) {
			System.out.println(n + " la luy thua cua 2");
		} else {
			System.out.println(n + " khong la luy thua cua 2");
		}

	}

	// tinh luy thua
	private static boolean exponential(int n) {
		for (int i = 1; i < n; i++) {
			if (Math.pow(2, i) == n) {
				return true;
			}
		}
		return false;

	}
}