package exercises;

import java.util.Scanner;

public class Ex05 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.print("Nhap number : ");
		int n = ip.nextInt();
		System.out.println(n +"(10) ->" + n +"(2) : " + binary(n));
		
	}
	
	// 10 -> 2
	private static int binary(int n) {
		int i = 1, T = 0,  tmp = 0;
		while( n != 0) {
			tmp = n % 2; 
			n = n / 2;
			T = T + i * tmp;
			i = i * 10;
		}
		return T;
	}
}
