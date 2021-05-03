package input;

import java.util.Random;

public class Ex02Random {
	public static void main(String[] args) {
		Random rd = new Random();
		
		System.out.println("raind: " + rd.nextBoolean());
	// random a number < a=20
	// int a = rd.nextInt(20);
	// random a number from a to b
	// a=5 b=10 => [5,6,7,8,9]
	int a = 5 ;
	int b = 10;	
	int ab = a + rd.nextInt(b-a);
	System.out.println("ab: " + ab);
	}

}
