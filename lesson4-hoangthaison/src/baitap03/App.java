package baitap03;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i; int j;
		System.out.println("Nhập n ");
		int n = Integer.parseInt(sc.nextLine());
		int [][]a = new int [100][100];
			
		for( i = 0; i < n; i++) {
			for( j = 0; j <= i ; j++) {
				if(i == j || j == 0) {
					a[i][j] = 1;
					System.out.print("  \t"+a[i][j]);
				}
				else {
					a[i][j] = a[i-1][j-1] + a[i-1][j];
					System.out.print("  \t"+a[i][j]);
				}
			}
			System.out.println("\n");
		}
	}
}
