package exercises;

import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.print("Nhap n : ");
		int n = ip.nextInt();
		if(isDX(n)) {
			System.out.println(n + " la so doi xung");
		}else {
			System.out.println(n + " khong phai la so doi xung");
		}
	}
	
	private static boolean isDX(int number) {
		int T = 0, n = number;
		int tmp = 0;
		while(n != 0) {
			tmp = n % 10;
			n = n / 10;
			T = T*10 + tmp;
		}
		return T == number;
	}
}
