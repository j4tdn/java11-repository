package homework1;

import java.util.Iterator;
import java.util.Scanner;

public class BT1 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.println("Nhap vao so : ");
		int number = ip.nextInt();
		System.out.println(isPowerOfTwo(number));
		
	}
	private static boolean isPowerOfTwo(int n) {
		if (n == 0 || n ==1) return true;
		int x= n/2;
		int y = n%2;
		if (y == 1) return false;
		return isPowerOfTwo(x);
	}
	
}