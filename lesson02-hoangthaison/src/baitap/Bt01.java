package baitap;

import java.util.Scanner;

public class Bt01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap x");
		int x  = Integer.parseInt(sc.nextLine());
		if(check(x)) {
			System.out.println("là luy thua");
		}else System.out.println("k phai luy thua cua 2");
		
		
		
	}
	private static Boolean check (int x) {
		for(int i =0;i< x;i++)
		{
		    if( Math.pow(2, i)==x) return true;
		}
		return false;
	}

}
