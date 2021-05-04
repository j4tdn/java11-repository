package baitap;

import java.util.Scanner;

public class Bai3 {

	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.print("Nhap n: ");
		int n = ip.nextInt();
		if (laSoDoiXung(n)) {
			System.out.println(n + " la so doi xung");
		} else {
			System.out.println(n + " khong phai la so doi xung");
		}
	}

	private static int SoDao(int n) {
		int sodao = 0, a;
		while (n != 0) {
			a = n % 10;
			sodao = (sodao * 10) + a;
			n = n / 10;
		}
		return sodao;
	}

	private static boolean laSoDoiXung(int input) {
		return input == SoDao(input) ;
			
	}

}
