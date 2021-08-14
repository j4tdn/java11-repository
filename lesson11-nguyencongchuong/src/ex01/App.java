package ex01;

public class App {
	public static void main(String[] args) {
		int n = 3;
		int column = 2 * n - 1;
		for (int i = 1; i <= n - 1; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j);
			}
			int xy = 2 * (n - i) - 1;
			for (int x = 1; x <= xy; x++) {
				System.out.print(" ");
			}
			for (int y = column - i + 1; y <= column; y++) {
				System.out.print(y);
			}
			System.out.println();
		}
		for (int i = 1; i <= column; i++) {
			System.out.print(i);
		}
		System.out.println();
		for (int i = n - 1; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j);
			}
			int xy = 2 * (n - i) - 1;
			for (int x = 1; x <= xy; x++) {
				System.out.print(" ");
			}
			for (int y = column - i + 1; y <= column; y++) {
				System.out.print(y);
			}
			System.out.println();
		}
	}
}
