package Java11;

import java.util.Scanner;

public class Bt06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 0;
		while (true) {
			System.out.print("Nhap vi tri SNT can kt: ");
			n = Integer.parseInt(sc.nextLine());
			System.out.println("So " + n + " trong he co so 2 = " + prime(n));
		}
	}

	private static int prime(int n) {
		int count = 0;
		int i = 2;
		while (count < n) {
			if (isPrime(i)) {
				count++;
			}
			if (count == n) {
				return i;
			}
			i++;
		}
		return i;
	}

	private static boolean isPrime(int i) {
		for (int j = 2; j <= Math.sqrt(i); j++) {
			if (i % j == 0) {
				return false;
			}
		}
		return true;
	}

}
