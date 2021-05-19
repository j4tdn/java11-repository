package bai3;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		int n;
		Scanner ip = new Scanner(System.in);
		System.out.print("n = ");
		n = ip.nextInt() + 1;
		display(n);
	}

	private static int pascal(int k, int n) {
		if (k == 0 || k == n) {
			return 1;
		}
		return pascal(k, n-1) + pascal(k-1, n-1);
	}
	
	private static void display(int n) {
		for(int i = 0; i <= n; i++) {
			for(int j = 0; j <= i; j++) 
				System.out.print(pascal(j, i) + " ");
				System.out.println("");
			
		}
	}
}
