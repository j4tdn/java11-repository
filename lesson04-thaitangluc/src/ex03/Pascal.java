package ex03;

import java.util.Scanner;

public class Pascal {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		int n = ip.nextInt();
		int[][] arr = new int[n+1][n+2];
		for(int i = 0; i<=n; i++) {
			for(int j = 0; j<=i+1; j++) {
				if(j==0 || j == i+1) {
					arr[i][j] = 1;
				}
				else {
					arr[i][j] = arr[i-1][j-1] + arr[i-1][j];			
					}
				System.out.print(arr[i][j]+ " ");
			}
			System.out.println();
		}
	}
}
