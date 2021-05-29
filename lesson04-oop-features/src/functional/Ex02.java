package functional;

public class Ex02 {
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		System.out.println("amount of odd num: " + count (a,num -> num % 2 != 0));
		System.out.println("amount of even num: " + count (a,num -> num % 2 == 0));
		System.out.println("amount of power of 3: " + count (a,num -> num % 3 == 0));
	}
	
	private static int count(int[] input, Condition con) {
		int count = 0;
		for (int i = 0; i < input.length; i++) {
			if(con.test(input[i])) {
				count++;
			}
		}
		return count;
	}
}
