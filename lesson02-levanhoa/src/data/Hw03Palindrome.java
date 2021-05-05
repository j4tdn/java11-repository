package data;

import java.util.Scanner;

public class Hw03Palindrome {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int n = ip.nextInt();
		boolean test = isPalindrome(n);
		if(test) {
			System.out.println(n + " is palindrome number.");
		}
		else {
			System.out.println(n + " is not palindrome number.");
		}
		
	}
	private static boolean isPalindrome(int n) {
		int r = 0;
		int s;
		int original = n;
		while(n>0) {
			s = n%10;
			r = 10*r + s;
			n = n/10;
		}
		return r == original;
	}

}
