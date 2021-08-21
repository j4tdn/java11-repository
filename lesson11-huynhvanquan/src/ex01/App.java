package ex01;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter n :");
		n = sc.nextInt();
		for(int i = 1; i <= 2*n - 1; i++) {
			for (int j = 1; j <= 2*n -1; j++) {
				if (i < n && i < j && j < 2*n - i) {
					System.out.format("%" + (String.valueOf(j).length() + 1) + "s", " ");
					continue;
				}
				if (i == n) {
					System.out.format("%" + (String.valueOf(j).length() + 1) +"d", j);
					continue;
				}
				if (i > n && 2*n -i < j && j < i) {
					System.out.format("%" + (String.valueOf(j).length() + 1) +"s", " ");
					continue;
				}
				System.out.format("%" + (String.valueOf(j).length() + 1) + "s", j);
			}
			System.out.println();
		}
		
	}
}
