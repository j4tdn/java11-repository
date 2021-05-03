package baitap;

public class Bai04 {
	public static void main(String[] args) {
		int [] digits = {5, 1, 9, 11, 20, 19, 17, 21, 30};
		int max = 0;
		System.out.println("so le lon nhat: " + soleLN(digits, max));
	}
	
	private static int soleLN (int[] digits, int max) {
		for (int i = 0; i < digits.length; i++) { 
			if (digits[i] % 2 != 0 && digits[i] > max) {
				max = digits[i];
			}
		}
		return max;
	}
}
