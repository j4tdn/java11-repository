package ex3;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int max = 0, min = 0, index, count = 0;

		int[][] arr = new int[n][m];
		// Nhap mang
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		// Kiem tra min ngang roi kiem tra max doc
		for (int i = 0; i < n; i++) {
			min = arr[i][0];
			index = 0;
			for (int j = 0; j < m; j++) {
				if (min > arr[i][j]) {
					min = arr[i][j];
					index = j;
				}
			}
			max = min;
			for (int k = 0; k < n; k++) {
				if (max < arr[k][index]) {
					max = arr[k][index];
				}
			}
			if (min == max) {
				++count;
				break;
			}
		}
		if (count > 0) {
			System.out.println("Ma tran co phan tu yen ngua");
		} else {
			System.out.println("Ma tran khong co phan tu yen ngua");
		}
	}
}
