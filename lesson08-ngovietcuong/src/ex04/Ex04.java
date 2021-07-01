package ex04;

import java.util.Scanner;

public class Ex04 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);

		System.out.print("Nhap a: ");
		int a = ip.nextInt();
		System.out.print("Nhap b: ");
		int b = ip.nextInt();
		
		if(isEquivalent(a, b) == true) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}

	}

	private static boolean isPrime(int number) {
		int count = 0;
		for (int i = 1; i <= number; i++) {
			if ((number % i) == 0) {
				count++;
			}
		}
		if (count == 2) {
			return true;
		}
		return false;
	}

	public static boolean isEquivalent(int a, int b) {
		int c = 1;
		int d = 1;
		for (int i = 1; i <= a; i++) {
			if ((a % i) == 0 && isPrime(i) == true) {
				c = c * i;
			}
		}
		for (int i = 1; i <= b; i++) {
			if ((b % i) == 0 && isPrime(i) == true) {
				d = d * i;
			}
		}

		if(c == d) {
			return true;
		}
		return false;
	}
}
