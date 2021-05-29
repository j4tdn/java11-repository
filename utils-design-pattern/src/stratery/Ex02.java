package stratery;

public class Ex02 {
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println("amout of odd numbs: " + count(a, num -> num % 2 != 0));
		System.out.println("amout of even numbs: " + count(a, num -> num % 2 == 0));
		System.out.println("amout of power of 3: " + count(a, num -> num % 3 == 0));
	}

	// Strategy pattern
	private static int count(int[] input, Condition con) {
		int count = 0;

		for (int i = 0; i < input.length; i++) {
			// Strategy
			if (con.test(input[i])) {
				count++;
			}
		}
		return count;
	}
}
