package ex02;

import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		int[][] a = {{1, 2, 3}, {4 ,5, 6}, {7, 8, 9}};
		changeMatrix();
	}
	private static void changeMatrix(){
		int x = 0, y = 0;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] arr = new int[n][m];
	    for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < m; j++)
			{
				arr[i][j] = sc.nextInt();
			}
		}
	    System.out.println("Mang truoc khi thay doi: ");
	    for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < m; j++)
			{
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	    
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(arr[i][j] == 0) {  //0;2
						x = i;
						y = j;
				}
			}
		}
		for (int p = 0; p < n; p++) {
			arr[x][p] = 0;
		}
		for (int q = 0; q < m; q++) {
			arr[q][y] = 0;
		}
		
		System.out.println("Mang sau khi thay doi: ");
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < m; j++)
			{
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
		
	}

}
