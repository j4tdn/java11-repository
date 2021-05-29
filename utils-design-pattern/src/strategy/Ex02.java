package strategy;

public class Ex02 {
	public static void main(String[] args) {
		int[] a = { 1, 3, 4, 5, 2, 6, 7, 8, 9 };
		
		//input -> execution
		Condition c1 = num -> num % 5 == 0;
		System.out.println("amount off odd numbs: " + count(a, num -> num % 2 != 0));
		System.out.println("amount off even numbs: " + count(a, num -> num % 2 == 0));
		System.out.println("amount off power of 3: " + count(a, num -> num % 3 == 0));

	}

	// strategy pattern
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
