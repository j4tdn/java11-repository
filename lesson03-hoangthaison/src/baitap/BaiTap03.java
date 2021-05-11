package baitap;

import java.util.Scanner;

public class BaiTap03 {
	public static void main(String[] args) {
		int kt =0;

		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap so hang so cot");
		System.out.println("So hang:"); 
		int n = Integer.parseInt(sc.nextLine());
		System.out.println("So Cot: ");
		int m = Integer.parseInt(sc.nextLine());
		int A[][] = new int[n][m];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				System.out.println("A[" +i+ "][" +j+ "] = " );
				A[i][j] = Integer.parseInt(sc.nextLine());
			}
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(A[i][j] == min(A,i,m) && A[i][j] == max(A,n,j)) {
					
					System.out.println("Phần tử yên ngựa: A[" +i+ "][" +j+ "] = "+A[i][j]);
					kt ++;
				}
				
			}
		}
	}
	 private static int max(int A[][], int sh, int sc) {
		 int k, max = A[0][sc];
		 for(k = 1; k < sh; k++) {
			 if(A[k][sc] > max)
				 max = A[k][sc];
		 }
		 return max;
	 }
	 private static int min(int A[][], int sh, int sc) {
		 int k, min = A[sh][0];
		 for(k = 1; k < sc; k++) {
			 if(A[sh][k] < min)
				 min = A[sh][k];
		 }
		 return min;
	 }

}
