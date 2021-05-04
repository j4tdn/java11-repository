package Java11;

import java.util.Scanner;

public class Bt3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 0;
		while (true) {
			System.out.print("Nhap so bat ky: ");
			n = Integer.parseInt(sc.nextLine());
			System.out.println(check(n));
		}
	}

	public static boolean check(int n) {
		int tmp = n;
		int a = 0;
		while (tmp > 0) {
			a = a * 10 + tmp % 10;
			tmp = tmp / 10;
		}
		return a == n;
	}
}