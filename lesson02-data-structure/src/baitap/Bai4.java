package baitap;

import java.util.Scanner;

public class Bai4 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		int n;
		
		do {
			System.out.print("Nhập số các số nguyên: ");
			n = ip.nextInt();
			if(n<=0) {
				System.out.println("Nhập sai. Mời nhập lại!\n ");
			}
		} while (n <= 0);

		int a[] = new int[n];
		NhapMang(a);
		XuatMang(a);
		System.out.println("\nSố lẻ lớn nhất có trong dãy là: " + SoLeLonNhat(a));
	}

	private static void NhapMang(int a[]) {
		for (int i = 0; i < a.length; i++) {
			Scanner ip = new Scanner(System.in);
			System.out.print("Số nguyên thứ " + i + " : ");
			a[i] = ip.nextInt();
		}
	}

	private static void XuatMang(int a[]) {
		System.out.print("\nDãy các số nguyên: ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	private static boolean LaSoLe(int a) {
		return a % 2 == 1;
	}

	private static int SoLeLonNhat(int a[]) {
		int max = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > max && Bai4.LaSoLe(a[i]) == true) {
				max = a[i];
			}
		}
		return max;
	}

}
