package Input;

import java.util.Random;

public class Ex02Ramdom { 
	public static void main(String[] args) {
		Random rd = new Random();
		System.out.println("Ramdom: " + rd.nextInt());
		int a = 5;
		int b = 10;
		int ab = a + rd.nextInt(b-a);
		
	}
}
