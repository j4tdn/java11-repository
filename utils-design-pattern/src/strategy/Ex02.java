package strategy;

public class Ex02 {
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		System.out.println("nums of even: " + count(a,x -> x % 2 == 0));
		System.out.println("nums of odd: " + count(a,x -> x % 2 != 0));
		System.out.println("nums of power of 3: " + count(a,x -> x % 3 == 0));
		
	}
	
	// strategy patterns
	private static int count(int[] input, Condition c) {
		int count = 0;
		
		for (int i = 0; i < input.length; i++) {
			if (c.test(input[i])) {
				count ++;
			}
		}
		
		return count;
	}
}
