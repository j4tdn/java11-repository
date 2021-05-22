package bai3;

public class App {
	public static void main(String[] args) {
		int a1 = 8, b1 = 2;
		int a2 = 6, b2 = 2;
		int a3 = 20, b3 = 4;
		int a4 = 64, b4 = 4;
		System.out.println(isPowerOf(a1, b1));
		System.out.println(isPowerOf(a2, b2));
		System.out.println(isPowerOf(a3, b3));
		System.out.println(isPowerOf(a4, b4));
	}

	public static boolean isPowerOf(int a, int b) {
		int temp = 1;
		for (int i = 1; i < a; i++) {
			temp = temp * b;
			if (temp == a) {
				return true;
			}
		}
		return false;
	}
}
