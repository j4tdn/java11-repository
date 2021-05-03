package input;

import java.util.Random;

public class Ex02Random {
	public static void main(String[] args) {
		Random rd = new Random();
		//while (true) {
		//	System.out.println("rand: " + rd.nextBoolean());
		//}
		System.out.println("rand: " + rd.nextBoolean());
		// random a number < a=20
		int rand = rd.nextInt(20); // nếu để while thì sẽ lỗi vì vòng lặp
		
		// random a number from a to b
		// a=5 b=10 => [6,7,8,9]
		int a = 5;
		int b = 10;
		int ab = a + rd.nextInt(b-a) + 1;
		System.out.println("ab: " + ab);
	}
}
