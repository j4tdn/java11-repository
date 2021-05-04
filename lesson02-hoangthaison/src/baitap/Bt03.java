package baitap;

import java.util.Scanner;

public class Bt03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Nhap x: ");
		int x  = Integer.parseInt(sc.nextLine());	
		if(check(x)) System.out.println("ok");
		else System.out.println("ko");
	}
	private static Boolean check(int x) {
		int k = x;
		int f=0;
		while(x != 0) {
			int digit = x % 10;
			f = f * 10 + digit;
			x /= 10;
		}
		return f==k;

	}

}
