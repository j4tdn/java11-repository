package bt2;

import java.util.Scanner;

public class Bt2 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.print("Nhap So Luong Phan Tu Day So: ");
		int n = ip.nextInt();
		int[] Arr = new int[n];
		for (int i = 0; i < n; i++) {
			System.out.printf("a[%d] = ", i);
			Arr[i] = ip.nextInt();
		}
		int[] Sort = new int[n];
		int start = 0;
		int end = 1;
		for (int i = 0; i < Arr.length; i++) {
			if (Arr[i] % 7 == 0 && Arr[i] % 5 != 0) {
				Sort[start] = Arr[i];
				start++;
			} else if (Arr[i] % 5 == 0 && Arr[i] % 7 != 0) {
				Sort[Arr.length - end] = Arr[i];
				end++;
			}
		}

		for (int i : Arr) {
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
