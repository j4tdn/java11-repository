package bai02;

import java.util.Scanner;

public class Bai02 {

	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.print("Ban muon tao bao nhieu phan tu : ");
		int sz = ip.nextInt();

		int[] A = new int[sz];

		for (int i = 0; i < A.length; i++) {
			System.out.print("Nhap phan tu thu " + (i + 1) + ":");
			A[i] = ip.nextInt();
		}
        System.out.println("\nMang vua tao la");
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println("\n==================================");
		System.out.println("Mang sau khi sap xep la");
		sapXep(A);

	}

	public static void sapXep(int[] A) {
		
		for (int i = 0; i < A.length - 1; i++) {
			for (int j = i + 1; j < A.length ; j++) {
				if (A[j] % 7 == 0 && A[j] % 5 != 0) {
					int temp = A[i];
					A[i] = A[j];
					A[j] = temp;
				}
			}
		}

		for (int i = A.length - 1; i > 0; i--) {
			for (int j = i - 1; j > 0; j--) {
				if (A[j] % 5 == 0 && A[j] % 7 != 0) {
					int temp = A[i];
					A[i] = A[j];
					A[j] = temp;
				}
			}
		}
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
	}
}
