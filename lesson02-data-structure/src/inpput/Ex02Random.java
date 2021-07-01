package inpput;

import java.util.Random;

public class Ex02Random {
	public static void main(String[] args) {
		// random an integer
		int bound = 20;
		int a = 66;
		int b = 88;
		Random rd = new Random();
		int r1 = rd.nextInt();// Integer.min - Integer.max 
		int r2 = rd.nextInt(bound); // 0 -(bound-1)
		//a - b
		int r3 = 66 + rd.nextInt(b-a+1); //a-b
		
		System.out.println("r1: " + r1);
		System.out.println("r2: " + r2);
		System.out.println("r3: " + r3);
		
		//random 1 element in array
		String[] texts = {"x", "y", "z", "t"};
		System.out.println("array random: "+texts[rd.nextInt(texts.length)]);
		
		//random a number has 3 digits
		int r4 = 100 + rd.nextInt(900);
		System.out.println("r4: "+ r4);
		
		//random a sequence has 3 character of digit
		//123 125 636
		String r5 = "" + rd.nextInt(10) + rd.nextInt(10) + rd.nextInt(10);
		System.out.println("r5: "+r5);
	}
}
