package bt;

import java.util.Scanner;

public class Bai5 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.print("Nhập n: ");
		int n = ip.nextInt();
		System.out.println("Số nhị phân: " + Integer.toBinaryString(n));
	}
	
//	private static convert(int n) {
//		int binary[] = new int[40];
//		int index = 0;
//		while (n > 0) {
//			binary[index++] = n%2;
//			n = n/2;
//		}
//		for(int i = index - 1; i >= 0; i--) {
//			System.out.println(binary);
//		}
//	}
	
}
