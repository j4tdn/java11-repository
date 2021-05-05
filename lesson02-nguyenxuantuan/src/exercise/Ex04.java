package exercise;

import java.util.Scanner;

public class Ex04 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap n: ");
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt(); 
		}
		if(maxOdd(a, n) == 0)
		System.out.println("Mang khong co gia tri le");
		else 
		System.out.println(maxOdd(a, n));
	
	}
	private static boolean isCheck(int number){
		int temp;
		do{
			temp = number % 10;
			number /= 10;
			if(temp % 2 == 0){
				return false;
			}
		}
		while(number > 0);
		return true;
	}
	private static int maxOdd(int[] a, int n){
		int max = 0;
		for(int i = 0; i < n; i++){
			if(a[i] > max && isCheck(a[i]))
			   max = a[i];
		}
		return max;
	}
}
