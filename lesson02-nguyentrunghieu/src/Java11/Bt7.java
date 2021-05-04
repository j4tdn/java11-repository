package Java11;

import java.util.Random;

public class Bt7 {
	public static void main(String[] args) {
		number();
	}
	static void number() {
		for (int i = 0; i < 5; i++) {
			Random rd = new Random();
			int random = rd.nextInt((10)+1) + 20;
			System.out.println("Random number is: " + random);
		}
	}
}