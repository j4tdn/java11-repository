package data;

public class Ex08Array {
	public static void main(String[] args) {
		// declairation (khai bao)
		int[] digits = {10,20,30};
		// int[] digits = new int[3]; // [0, 0, 0]
		// digits[0] = 10;
		// digits[1] = 20;
		// digits[2] = 30;
		// digits[2] = 30; out of bound exception
		
		System.out.println("length: " + digits.length);
		System.out.println("digits[1]: " + digits[1]);
		
		for (int i =0; i<digits.length; i ++) {
			System.out.println(digits[i]);
		}
	}
}
