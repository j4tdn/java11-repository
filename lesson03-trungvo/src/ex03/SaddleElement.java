package ex03;

import java.util.Iterator;
import java.util.Scanner;

public class SaddleElement {
public static void main(String[] args) {
	Scanner ip =new Scanner(System.in);
	int[][] a = new int [3][3]; 
	System.out.println("Nhap mang");
	 
	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 3; j++) {
			System.out.println("arr[" + i + "][" + j +"] = ");
			a[i][j] = ip.nextInt();

		}
	}
	System.out.println("Mang nhap vao la: ");
	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 3; j++) {
			System.out.print(a[i][j] + "     ");
		}
		System.out.println();
	}
	
	
	}
}
