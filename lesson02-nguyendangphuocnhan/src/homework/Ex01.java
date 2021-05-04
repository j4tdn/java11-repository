package homework;

import java.util.Scanner;

public class Ex01 {
	// Viết chương trình kiểm tra 1 số có phải là lũy thừa của 2 hay không
	
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.println("Number: ");
		int n = Integer.parseInt(ip.nextLine());
		System.out.println(n + " is power of two?: " + isPowerOfTwo(n));
	}

	public static boolean isPowerOfTwo(int n) {
		while (n % 2 == 0) { 
			n = n / 2; 
		}
		if (n == 1) {
			return true;
		} else {
			return false;
		}
	}
}
