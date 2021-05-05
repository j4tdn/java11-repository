package baitap;

import java.util.Random;

public class bai07_c1 {
	public static void main(String[] args) {
		Random rd = new Random();
		
		int a= 20 + rd.nextInt(30-20)+1;
		
		int b = 20 + rd.nextInt(30-20)+1;
		while(b==a) {
			b=20 + rd.nextInt(30-20)+1;
		}
		
		int c = 20 + rd.nextInt(30-20)+1;
		while(c==a||c==b) {
			c=20 + rd.nextInt(30-20)+1;
		}
		
		int d = 20 + rd.nextInt(30-20)+1;
		while(d==a||d==b||d==c) {
			d=20 + rd.nextInt(30-20)+1;
		}
		
		int e = 20 + rd.nextInt(30-20)+1;
		while(e==a||e==b||e==c||e==d) {
			e=20 + rd.nextInt(30-20)+1;
		}
		
		System.out.println(a+" "+b+" "+c+" "+d+" "+e);
	}

}
