package functional;

public class Ex02 {
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Condition c = x -> x % 3 == 0;
		System.out.println("amount of odd numbers: " + count(array, x -> x % 2 != 0));
		System.out.println("amount of even numbers: " + count(array, x -> x % 2 == 0));
		System.out.println("amount of power of 3: " + count(array, c));
	}
	
	// strategy pattern
	private static int count(int[] input, Condition c) {
		int count = 0;

		for (int i = 0; i < input.length; i++) {
			// strategy
			if (c.test(input[i])) {
				count++;
			}
		}
		return count;
	}
}
