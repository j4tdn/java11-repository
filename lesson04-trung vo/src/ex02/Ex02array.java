package ex02;

import java.util.Scanner;

public class Ex02array {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		
		System.out.println("nhap so luong phan tu: ");
		int n = ip.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			System.out.println("arr[" + i + "]= ");
			 	arr[i] = ip.nextInt();
		}
		
		System.out.println("Mang nhap vao la: ");
		for (int i = 0; i < arr.length; i++) {
			System.out.println( "arr[" + i +  "]= " + arr[i]);
			
		}
		
		for (int i = 0; i < arr.length; i++) {
			int temp = arr[i];
			for (int j = i+1; j < arr.length; j++) {
				if (arr[i] %7 == 0 && arr[i]%5 !=0) {
					arr[i] = arr[j];
					arr[j] = temp;
					temp = arr[i];
				}
			}
			
		}
		System.out.println("Mang dc sap xep: ");
		for(int x: arr) {
			System.out.println(x);
		}
		

	}
}
