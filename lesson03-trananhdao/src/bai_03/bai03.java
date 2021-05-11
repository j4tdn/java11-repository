package bai_03;

import java.util.Scanner;

public class bai03 {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int c, r;

		System.out.print("moi nhap hang: ");
		r = Integer.parseInt(s.nextLine());
		System.out.print("moi nhap cot: ");
		c = Integer.parseInt(s.nextLine());

		int[][] a = new int[c][r];

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print("a[" + i + "][" + j + "]: ");
				a[i][j] = Integer.parseInt(s.nextLine());

			}
		}
		in(a, c, r);
		if(diemYenNgua(a, c, r)==0)
		{
		System.out.println(" khong co diem yen ngua! ");
		}
		else {
			System.out.println("diem yen ngua: ");
			System.out.println(diemYenNgua(a, c, r));
		}
	}

	public static void in(int a[][], int c, int r) {

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {

				System.out.print(a[i][j] + " ");

			}
			System.out.println("\n");
		}

	}

	public static int diemYenNgua(int a[][], int c, int r) {
		int max, min, cc;
		for (int I = 0; I < r; I++) {
			max = a[I][0];
			cc = 0;
			for (int j = 1; j < r; j++) {
				if (a[I][j] > max) {
					max = a[I][j];
					cc = j;
				}
			}
			min = a[0][cc];
			for (int i = 1; i < r; i++) {
				if (min > a[i][cc]) {
					min = a[i][cc];
				}
			}
			if (max == min) {
				
				return a[I][cc];
			} 
		}
		return 0;
	}

}
