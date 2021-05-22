package view;

public class Ex03 {
	public static void main(String[] args) {
		int a = 2;
		int b = 10;
		int c = a > b ? a : b;
		a = a + b - c;
		while (c > 0) {
			if (c % a != 0) {
				System.out.println("FALSE ");
				break;
			}
			c /= a;
			if (c == 1) {
				System.out.println("TRUE ");
				break;
			}
		}
	}

}
