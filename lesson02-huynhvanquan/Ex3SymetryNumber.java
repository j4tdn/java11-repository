package homework;

import java.util.Scanner;

public class Ex3SymetryNumber {
	public static void main(String[] args) {
		String num;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter n: ");
		num = sc.nextLine();
		while (!isDigit(num)) {
			System.out.println("Please enter integer number! \nEnter n: ");
			num = sc.nextLine();
		}
		if (isSymetryNumber(num)) {
			System.out.println("This is a symetry number!");
			return;
		} 
		System.out.println("This is not a symetry number!");
		
		
	}
	
	static Boolean isDigit(String num) {
		for (char i : num.toCharArray()) {
			if ( i  < '0' || i > '9') {
				return false;
			}
		}
		return true;
	}
	
	static Boolean isSymetryNumber(String str) {
		char[] num = str.toCharArray();
		for (int i = 0; i < num.length/2; i++) {
			if (num[i] != num[num.length - i - 1]) {
				return false;
			}
		}
		return true;
	}
}
