package data;

public class Ex08Array {
	public static void main(String[] args) {
		// declaration
		
		int[] digit = {10,20,30};
//		int[] digit = new int[3];
//		digit[0] = 10;
//		digit[1] = 20;
//		digit[2] = 30;
//		digit[3]=30;

		System.out.println("length: " + digit.length);
		System.out.println("length[1]: " + digit[1]);
		for (int i = 0; i < digit.length; i++) {
			System.out.println(digit[i]);
		}
	}
}
