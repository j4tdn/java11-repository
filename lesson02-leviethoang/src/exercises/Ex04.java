package exercises;

import java.util.Scanner;

public class Ex04 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.print("Nhap so phan tu : ");
		int n = ip.nextInt();
		int[] arr = new int[n];
	   for(int i = 0;i < arr.length; i++) {
		   System.out.println("arr[" + i + "] = " );
		   arr[i] = ip.nextInt();
	   }
	   System.out.println("maxODD :" + maxOdd(arr));
	}
	
	private static int maxOdd(int[] arr) {
		int max = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] % 2 != 0) {
				if(max < arr[i]) {
					max = arr[i];
				}
			}
		}
		return max;
	}
}
