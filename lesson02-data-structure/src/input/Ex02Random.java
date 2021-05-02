package input;

import java.util.Random;

public class Ex02Random {
	public static void main(String[] args) {
		Random rd = new Random();

		System.out.println("rand: " + rd.nextBoolean());

		// random a number from a to b;

		int a = 5;
		int b = 10;

		int ab = a + rd.nextInt(b - a);

		System.out.println(ab);

	}
}
