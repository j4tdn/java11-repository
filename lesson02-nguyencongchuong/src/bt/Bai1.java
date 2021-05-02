package bt;

import java.util.Scanner;

public class Bai1 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.print("Nhập vào n: ");
		int n = ip.nextInt();

//		System.out.println(n + " là lũy thừa của 2: " + luyThua2(n));
		boolean luyThua2 = luyThua2(n);

		if (luyThua2) {
			System.out.println(n + " là lũy thừa của 2.");
		} else {
			System.out.println(n + " không phải là lũy thừa của 2.");
		}
	}

	private static boolean luyThua2(int n) {
		if (n == 1) {
			return true;
		}
		int x = n / 2;
		int y = n % 2;
		if (y == 1) {
			return false;
		}
		return luyThua2(x);
	}

}
