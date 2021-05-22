package bai3;

public class LuyThua {
	public static void main(String[] args) {
		int a = 2;
		int b = 8;

		System.out.println("(" + a + ", " + b + ")" + "(" + isPowerOf(a, b) + ")");

	}

	public static boolean isPowerOf(int a, int b) {

		if (a == b) {
			return true;
		}

		if (a > b) {
			while (a % b == 0) {
				a = a / b;
			}
			if (a == 1)
				return true;
			return false;
		}

		if (a < b) {
			while (b % a == 0) {
				b = b / a;
			}
			if (b == 1)
				return true;
			return false;
		}
		return false;

	}
}
