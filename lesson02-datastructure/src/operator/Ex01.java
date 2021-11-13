package operator;

public class Ex01 {
	public static void main(String[] args) {
		// Toan tu 1 ngoi
		int number = 8;

		int result = number++ + 10;
		System.out.println(result);
		System.out.println(number);

		// ! phủ định
		System.out.println(!true);

		boolean isEven = isEvent(10); // true
		if (isEven) {
			System.out.println("Số chẵn");
		} else if (!isEven) {
			System.out.println("Số lẻ");
		}

		// condition operator

		System.out.println("======================");
		int a = 2, b = 3;
		if (a > 1 && b++ > 3) {
			System.out.println("Good condition!!!");
		}
		System.out.println("b: " + b);

		System.out.println("======================");
		int c = 2, d = 3;
		if (c > 1 || d++ > 3) {
			System.out.println("Good condition!!!");
		}
		System.out.println("d: " + d);
	}

	public static boolean isEvent(int input) {
		return input % 2 == 0;
	}

}