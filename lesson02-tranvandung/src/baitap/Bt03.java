package baitap;

import java.util.Scanner;

public class Bt03 {
	public static void main(String[] args) {
		if (symmetry()) {
			System.out.println("la so doi xung");
		} else {
			System.out.println("khong la so doi xung");
		}
	}

	// kiem tra so doi xung
	private static boolean symmetry() {
		Scanner ip = new Scanner(System.in);
		System.out.print("nhap so: ");
		int n = ip.nextInt();
		int tmp = n % 10;
		if(n < 10) {
			return false;
		}
		for (int i = n / 10; i > 0; i /= 10) {
			tmp = tmp * 10 + i % 10;
		}
		if (tmp != n) {
			return false;
		} else {
			return true;
		}
	}
}
