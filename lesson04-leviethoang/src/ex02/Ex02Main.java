package ex02;

import java.util.Scanner;

public class Ex02Main {
	static Scanner ip = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Nhap so phan tu trong mang : ");
		int n = ip.nextInt();
		int[] a = new int[n];
		input(a, n);
		System.out.println("\nMang vua nhap la :");
		export(a, n);
		System.out.println("\nMang vua sap xep la :");
		sort(a, n);
	}

	private static void input(int[] a, int n) {
		for (int i = 0; i < n; i++) {
			System.out.print("a[" + i + "] = ");
			a[i] = ip.nextInt();
		}
	}

	private static void export(int[] a, int n) {
		for (int i = 0; i < n; i++) {
			System.out.print(a[i] + " ");
		}
	}

	private static void sort(int[] a, int n) {
		int tmp = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (a[j] % 7 == 0) {
					tmp = a[j];
					a[j] = a[i];
					a[i] = tmp;
				}
			}
		}

		for (int i = n - 1; i > 0; i--) {
			for (int j = i - 1; j > 0; j--) {
				if (a[j] % 5 == 0) {
					tmp = a[j];
					a[j] = a[i];
					a[i] = tmp;
				}
			}
		}

		export(a, n);
	}
}
