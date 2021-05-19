package bt2;

import java.util.Scanner;

public class Bt2 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.print("Nhap So Luong Phan tu: ");
		int n = ip.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			System.out.printf("a[%d] = ", i);
			arr[i] = ip.nextInt();
		}
		int[] Sort = new int[n];
		int start = 0;
		int end = 1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 7 == 0 && arr[i] % 5 != 0) {
				Sort[start] = arr[i];
				start++;
			} else if (arr[i] % 5 == 0 && arr[i] % 7 != 0) {
				Sort[arr.length - end] = arr[i];
				end++;
			}
		}

		for (int i : arr) {
			if (i % 7 == 0 && i % 5 == 0 || (i % 7 != 0 && i % 5 != 0)) {
				Sort[start++] = i;
			}
		}

		System.out.println("Day Sap Xep La: ");
		for (int i : Sort) {
			System.out.print("\t" + i);
		}
	}
}
