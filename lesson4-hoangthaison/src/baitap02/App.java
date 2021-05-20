package baitap02;

import java.util.List;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		System.out.println("So phần tử của mảng");
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		Nhap(n);
		
		
	}
	private  static void Nhap(int n) {
		
		int[] a = new int [20];
		int max = n-1;
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i <n; i++) {
			System.out.println("a[" + i + "] = " );
			a[i] = Integer.parseInt(sc.nextLine());
		}
		for(int i = 0; i < n; i++) {
			for(int j = i; j < n; j++) {
				if(a[j] % 7 ==0 && a[j] % 5!= 0) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
				if(a[j] % 7 != 0 && a[j] % 5 == 0) {
					int temp = a[j];
					a[j] = a[i];
					a[i] = temp;
					max --;
					n--;
					j--;
				}
			}
		}
		for(int i=0;i < n; i++){
			System.out.println(a[i]+"");
			
		}
		
	}	
	

}
