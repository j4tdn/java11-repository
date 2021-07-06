package mainipulation;

public class Ex02 {
	public static void main(String[] args) {
		int[] digits = {1,2,3,7,4,5};
		reverse(digits);
		for (int i : digits) {
			System.out.print(i + " ");
		}

	}
	private static void reverse(int[] digits) {
		for(int i =0; i < digits.length/2; i++) {
			int tmp = digits[i];
			digits[i] = digits[digits.length - i-1];
			digits[digits.length-i-1] =tmp;
		}
	}
}
