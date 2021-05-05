package input;

import java.util.Random;

public class Ex02Random {
	public static void main(String[] args) {
		Random rd = new Random();
		//random a number < 10
		System.out.println(rd.nextInt(10));
		
		//random a number from a to b
		int a = 5;
		int b = 10;
		int ab = a + rd.nextInt(b-a) + 1;
		System.out.println("ab: " + ab);
		
	}
}
