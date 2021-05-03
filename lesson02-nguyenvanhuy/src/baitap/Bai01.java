package baitap;

public class Bai01 {
	public static void main(String[] args) {
		int input = 4;
		System.out.println("la luy thua cua 2: " + ltcua2(input));
	}

	private static boolean ltcua2(int input) {
		return (input & (input - 1)) == 0;
	}
}
