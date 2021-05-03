package homework;

public class Ex02 {
	
	// Viết chương trình tính tổng S = 4! +7! + 12! + 18!

	public static void main(String[] args) {
		int a = 4, b = 7, c = 12, d = 18;

		long fa = 1, fb = 1, fc = 1, fd = 1;

		for (int i = 1; i <= a; i++) {
			fa *= i;
		}
		for (int i = 1; i <= b; i++) {
			fb *= i;
		}
		for (int i = 1; i <= c; i++) {
			fc *= i;
		}
		for (int i = 1; i <= d; i++) {
			fd *= i;
		}

		long sum = fa + fb + fc + fd;
		System.out.println("sum = " + sum);
	}
}