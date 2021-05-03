package baitap;

public class Bai03 {
	public static void main(String[] args) {
		int input = 121;
		if (laSoDx(input)) {
			System.out.println(timSoDx(input) + " la so doi xung");
		} else {
			System.out.println(timSoDx(input) + " khong phai so doi xung");
		}
	}

	private static boolean laSoDx(int input) {
		return (input == timSoDx(input));
	}

	private static int timSoDx(int input) {
		int SoDx = 0;
		int Digit;
		while (input != 0) {
			Digit = input % 10; 
			SoDx = SoDx * 10 + Digit;
			input /= 10;
		}
		return SoDx;
	}
}
