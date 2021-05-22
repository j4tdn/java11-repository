package ex03;

public class Ex03 {
	public static void main(String[] args) {
		
		System.out.println(isPowerOf(8, 2));
		System.out.println(isPowerOf(4, 64));
	}

	public static boolean isPowerOf(int a, int b) {
		if (a < b) {
			int temp = a;
			a = b;
			b = temp;
		}
		while ((a % b == 0)) {
			a = a / b;
		}
		if (a != 1)
			return false;
		else
			return true;
	}
}
