package input;

import java.util.Random;

public class Ex02Random {
	public static void main(String[] args) {
		Random rd = new Random();
		int rand = rd.nextInt(20);
		
		int a = 5;
		int b = 10;
		int ab = a + rd.nextInt(b-a);
		

			System.out.println("rand " + rd.nextInt());
		
		// random a number form a to b 
		// a=5 b=10
		//random a< number 20;
		
	}
}
