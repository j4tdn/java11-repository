package Input;

import java.util.Random;

public class Ex02Random {
	public static void main(String[] args) {
		Random rd = new Random();
		int bound =20;
		int a =66;
		int b=88;
		int r1 = rd.nextInt();
		int r2 = rd.nextInt(bound);
		int r3 = a+rd.nextInt(b-a+1);
		System.out.println("r1 "+r1);
		System.out.println("r2 "+r2);
		System.out.println("r3 "+r3);
		
		String[] texts = {"x","y","z","t"};
		System.out.println("array random: "+ texts[rd.nextInt(texts.length)]);
		int rd4 =100 + rd.nextInt(900);
		System.out.println("r4 = "+rd4);
		
		String r5 = "" +rd.nextInt(10)+ rd.nextInt(10)+rd.nextInt(10);
		System.out.println("r5: "+r5);
		
	}
}
