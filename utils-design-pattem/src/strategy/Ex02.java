package strategy;

public class Ex02 {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		Condition c1 = num -> num % 5 == 0;

		System.out.println("Count of odd numbs: " + count(arr, num -> num % 2 != 0));
		System.out.println("Count of even numbs: " + count(arr, num -> num % 2 == 0));
		System.out.println("Count of power of 3: " + count(arr, num -> num % 3 == 0));

	}

	private static int count(int[] input, Condition con) {
		int count = 0;
		for (int i = 0; i < input.length; i++) {
			if (con.test(input[i])) {
				count++;
			}
		}
		return count;

	}
}
