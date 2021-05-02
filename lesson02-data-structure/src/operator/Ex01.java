package operator;

public class Ex01 {
	public static void main(String[] args) {
		// is even number
		int number = 10;
		boolean isEven = (isEven(number));

		if (isEven) {
			System.out.println(number + " is even number");
		} else
			System.out.println(number + " is odd number");

		// && ||
		if (number % 2 == 0 && number % 10 == 0) {
			System.out.println("true");
		}

		// Condition operator ?:
		System.out.println("===============");
		System.out.println(number + " is " + ((number % 2 == 0) ? "even" : "odd"));

	}

	private static boolean isEven(int number) {
		return (number % 2 == 0);
	}

	// i++ vs ++i
	// int i = 5
	// i++ = ++i =6
	// print i++ => 5
	// print ++i => 6

}
