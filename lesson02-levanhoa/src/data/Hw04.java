package data;

import java.util.Scanner;

public class Hw04 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.print("Enter length of sequence numbers: ");
		int n = ip.nextInt();
		int[] a = new int [n];
		System.out.println("Enter sequence numbers: ");
		for(int i = 0; i < n; i++) {
			a[i] = ip.nextInt();
		}
		int max = 0;
		for(int i = 0; i < n; i++) {
			if(isOddNumber(a[i]) && a[i]> max) {
				max = a[i];
			}
		}
		if (max == 0) {
			System.out.println("There are not odd number in ones");
		} else {
			System.out.println("Max odd number is: " + max);
		}
	}
	private static boolean isOddNumber(int n) {
		return n % 2 == 1;
	}

}
