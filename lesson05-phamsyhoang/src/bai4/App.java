package bai4;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		int[] a = new int[1000];
		int n;
		System.out.println("Nhap n: ");
		Scanner ip = new Scanner(System.in);
		n = ip.nextInt();

		System.out.println("Nhập mảng a: ");
		for (int i = 0; i < n; i++) {
			System.out.println("Nhap a[" + i + "]: ");
			a[i] = ip.nextInt();
		}

		System.out.println("Xuất mảng a: ");
		for (int i = 0; i < n; i++) {
			System.out.print(a[i] + " ");
		}
		
		getLeastCommonMultiple(a, n);

	}

	public static int UCLN(int a, int b) {
		if (a == b)
			return a;
		if (a > b)
			UCLN(a - b, b);
		else
			UCLN(a, b - a);
		return 0;
	}

	public static int BCNN(int a, int b) {
		return (a * b / UCLN(a, b));
	}

	public static int getLeastCommonMultiple(int a[], int n) {
		int temp = BCNN(a[0], a[1]);
		for (int i = 2; i < n; i++) {
			temp = BCNN(temp, a[i]);
		}
		return temp;
	}

}
