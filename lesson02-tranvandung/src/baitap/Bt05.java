package baitap;

import java.util.Scanner;

public class Bt05 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.print("nhap so a: ");
		int a = ip.nextInt();
		System.out.println("chuyen doi nhi phan cua a la:" + Integer.toBinaryString(a));
	}
}
