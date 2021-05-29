package functional;

public class Ex01 {
	public static void main(String[] args) {
		int a = 5;
		int b = 10;
		Functional f1 = (num1, num2) -> num1 + num2;
		System.out.println("sum: " + cal(a, b, f1));
		System.out.println("sub: " + cal(10, 5, (num1, num2) -> num1 - num2));
		System.out.println("mul: " + cal(3, 5, (num1, num2) -> num1 * num2));
		System.out.println("div: " + cal(15, 3, (num1, num2) -> num1 / num2));
	}

	// strategy pattern
	private static int cal(int a, int b, Functional f) {
		return f.func(a, b);
	}

}
