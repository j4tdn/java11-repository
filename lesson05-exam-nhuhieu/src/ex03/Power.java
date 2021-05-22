package ex03;

import java.util.Scanner;

public class Power {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.println("Input a: ");
		int a = Integer.parseInt(ip.nextLine());

		System.out.println("Input b: ");
		int b = Integer.parseInt(ip.nextLine());
		System.out.println(isPowerOf(a, b));
		
		System.out.println("("+ a + ", " + b + ")" + "(" + isPowerOf(a,b) + ")");
	}

	public static boolean isPowerOf(int a, int b) {
		while (a % b == 0) {
			a = a / b;
		}
		if (a == 1) {
			return true;
		} else {
			return false;
		}
	
	}
}
