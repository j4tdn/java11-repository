package baitap;

import java.util.Scanner;

public class Bt04 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.print("nhap so luong day so: ");
		int n = ip.nextInt();
		int oddmax = 0;
		for (int i = 0; i < n; i++) {
			int x = ip.nextInt();
			if (x % 2 != 0)
				if (x > oddmax) {
					oddmax = x;
				}
		}
		System.out.println("so le max la: " + oddmax);
	}
}