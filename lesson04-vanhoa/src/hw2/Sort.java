package hw2;

import java.util.Random;

public class Sort {
	public static void main(String[] args) {
		int n = 30;
		int[] a = new int[n];
		Random rd = new Random();
		for(int i = 0; i < n; i++) {
			a[i] = 1 + rd.nextInt(100);
			System.out.printf("%-5d", a[i]);
			if((i+1) % 19 == 0) {
				System.out.println();
			}
		}
		sort(a, n);
		System.out.println("\n====================================================");
		for (int i = 0; i < n; i++) {
			System.out.printf("%-5d", a[i]);
			if((i+1) % 19 == 0) {
				System.out.println();
			}
		}
		
	}
	public static void sort(int[] a, int n) {
		int tmp = 0;
		int s = 0;
		int f = n - 1;
		for (int i = 0; i < n; i++) {
			if(a[i] % 7 == 0 && a[i] % 5 != 0) {
				tmp = a[i];
				a[i] = a[s];
				a[s] = tmp;
				s++;
			}
		}
		for (int i = f; i > 1; i--) {
			if(a[i] % 5 == 0 && a[i] % 7 != 0) {
				tmp = a[i];
				a[i] = a[f];
				a[f] = tmp;
				f--;
			}
		}
	}
	
}
