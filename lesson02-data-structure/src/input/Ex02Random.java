package input;

import java.util.Random;

public class Ex02Random {
	public static void main(String[] args) {
		Random rd = new Random();
<<<<<<< HEAD
		System.out.println("random: " + rd.nextInt());
		
		//random a number < i = 20
		int i = rd.nextInt(20);
		
		//random a number from a to b
		int a = 5;
		int b = 10;
		int ab = a + rd.nextInt(b - a);
		System.out.println("ab: " + ab);
	}
=======
		
		System.out.println("rand: " + rd.nextBoolean());
		//random a number < a = 20;
		int rand = rd.nextInt(20);
		int a = 5;
		int b = 10;
		//random a number from a to b
		//a = 5 b = 10 => [5, 6, 7, 8, 9]
		int ab = a + rd.nextInt(b - a);
		System.out.println("random: " + ab);
		
	}

>>>>>>> ba78b3a (lesson02-03 02.05.2021)
}
