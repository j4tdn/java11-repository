package exam;

public class Ex03 {
	public static void main(String[] args) {
		System.out.println(isPowerOf(8, 2));
		System.out.println(isPowerOf(6, 2));
		System.out.println(isPowerOf(20, 4));

	}

	public static boolean isPowerOf(int a, int b) {
		if (a == 0 || a == 1 || a == b)
			return true;
		int x = a / b;
		int y = a % b;
		if (y == 1)
			return false;

		return isPowerOf(x, b);
	}

}
