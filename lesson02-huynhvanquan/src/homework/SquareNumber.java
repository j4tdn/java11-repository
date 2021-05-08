package homework;

import java.util.Scanner;

public class SquareNumber {
	public static void main(String[] args) {
		int n;
		String str;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter n: ");
		str = sc.nextLine();
		while (!isDigit(str)) {
			System.out.println("Please enter integer!");
			System.out.println("Enter n: ");
			str = sc.nextLine();
		}
		if (checkSquareNumber(Integer.parseInt(str))) {
			System.out.println(str + " is a square number.");
		} else {
			System.out.println(str + " is a square number.");
		}
		
	}
	static Boolean isDigit(String str) {
		if (str.length() == 0) {
			return false;
		}
		for (char i : str.toCharArray()) {
			if( i < '0' || i > '9') {
				return false;
			}
		}
		return true;
	}
	static Boolean checkSquareNumber(int n) {
		for (int i = 0; i <= Math.sqrt(n); i++) {
			if (i*i == n) {
				return true;
			}
		}
		return false;
	}
}
