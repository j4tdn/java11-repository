package data;

public class Ex08Array {
	public static void main(String[] args) {
		//declaration
		int [] digits = {10, 20, 30};
//		int [] digits = new int[3];
//		digits[0] = 10;
//		digits[1] = 20;
//		digits[2] = 30;
		//digits[3] = 10; out of bound exception
		System.out.println("length: " + digits.length);
		System.out.println("digit[1]: " + digits[1]);
		for (int i = 0; i < digits.length; i++) {
			System.out.println(digits[i]);
		}
	}
}
