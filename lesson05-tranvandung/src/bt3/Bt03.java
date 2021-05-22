package bt3;

import java.util.Scanner;

public class Bt03 {
	public static void main(String[] args) {
		System.out.println("(8,2)" + " " + isPowerOf(8, 2));
	}

	public static boolean isPowerOf(int a, int b) {
		int temp = a / b;
		boolean temp2 = false;
		while (a > 0) {
			if (a % b == 0 && temp % b == 0) {
				temp2 = true;
			}
			a /= b;
			temp = a / b;
		}
		return temp2;
	}
}
