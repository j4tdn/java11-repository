package baitap;

import java.util.Scanner;

public class bai05 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		int n;

		do {
			System.out.print("Nhập số cần chuyển đổi: ");
			n = ip.nextInt();
			if (n < 0) {
				System.out.println("Nhap sai. Moi nhap lai!\n");
				continue;
			}
			CoSo2(n);
		} while (n < 0);
	}

	private static void CoSo2(int n) {
		System.out.print("Số " + n + " ở hệ cơ số 2 là: ");
		int arr[] = new int[50];
		int i = 0;
		while (n > 0) {
			arr[i++] = n % 2;
			n = n / 2;
		}
		for (int j = i - 1; j >= 0; j--) {
			System.out.print(arr[j]);
		}
	}

}
