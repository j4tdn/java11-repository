package ex02;

import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int[] a = new int[100];
		int n;
		System.out.print("Nhap so phan tu : ");
		n = sc.nextInt();
		for (int i=0; i<n; i++) {
			System.out.print("A["+i+"] = ");
			a[i] = sc.nextInt();
		}
		
		int i = 0;
		int begin = 0;
		int end = n - 1;
		do {
			if (a[i] % 7 == 0 && a[i] % 5 != 0) {
				swap(begin, i , a);
				begin++;
				i++;
			}else {
				i++;
			}
		}while(i<n);
		
		System.out.println(begin);
		i = begin;
		
		while(i < end) {
			while (a[i] % 5 == 0 && a[i] % 7 != 0) {
				swap(end, i , a);
				end--;
			}
			i++;
		}
		
		for (i=0; i<n; i++) {
			System.out.printf(""+a[i]+"  ");
		}
	}
	private static void swap(int i, int j, int[] array) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

}