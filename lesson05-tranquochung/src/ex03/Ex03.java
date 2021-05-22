package ex03;

public class Ex03 {
	public static void main(String[] args) {
		System.out.println(isPowerOf(2, 8));
	}

	public static boolean isPowerOf(int a, int b) {
		int tmp = 0;
		if (b > a) {
			tmp = a;
			a = b;
			b = tmp;
		}
		tmp = b;
		do {
			b *= tmp;
			if (b == a)
				return true;
		} while (b < a);
		return false;
	}
}
