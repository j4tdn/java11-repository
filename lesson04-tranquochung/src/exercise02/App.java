package exercise02;

import java.util.Scanner;

public class App {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Nhap so phan tu trong mang : ");
		int n = scanner.nextInt();
		int[] A = new int[n];
		// Enter Array
		for (int i = 0; i < n; i++) {
			System.out.println("Nhap phan tu thu A[" + i + "] = ");
			A[i] = scanner.nextInt();
		}
		// Show Array
		System.out.println("\nMang vua nhap la :");
		for (int i = 0; i < n; i++) {
			System.out.print(A[i] + " ");
		}

		System.out.println("\nMang vua sap xep la :");
		sort(A, n);
	}

	private static void sort(int[] A, int n) {
		int tmp = 0;
		for (int k = 0; k < n; k++) {
			if (A[k] % 7 != 0) {
				for (int i = k; i < n - 1; i++) {
					for (int j = i + 1; j < n; j++) {
						if (A[j] % 7 == 0 && A[j] % 5 != 0) {
							tmp = A[j];
							A[j] = A[i];
							A[i] = tmp;
						}
					}
				}
			}
		}

		for (int k = n - 1; k > 0; k--) {
			if (A[k] % 5 != 0) {
				for (int i = n - 1; i > 0; i--) {
					for (int j = i - 1; j > 0; j--) {
						if (A[j] % 5 == 0 && A[j] % 7 != 0) {
							tmp = A[j];
							A[j] = A[i];
							A[i] = tmp;
						}
					}
				}
			}
		}

		for (int i = 0; i < n; i++) {
			System.out.print(A[i] + " ");
		}

	}

}
