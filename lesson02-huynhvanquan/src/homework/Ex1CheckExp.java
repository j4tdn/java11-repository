package homework;

import java.util.Scanner;

public class Ex1CheckExp {
	public static void main(String[] args) {
		int n;
		String str;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter n: ");
		str = sc.nextLine();
		
		while (!isDigit(str)) {
			System.out.println("Please enter integer! \nEnter n: ");
			str = sc.nextLine();
		}
		
		if (checkExp(Integer.parseInt(str))) {
			System.out.println(str + " là lũy thừa của 2.");
		} else {
			System.out.println(str + " không phải lũy thừa của 2.");
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
	
	static Boolean checkExp(int n) {
		return (int)(Math.ceil((Math.log(n) / Math.log(2)))) 
	            == (int)(Math.floor(((Math.log(n) / Math.log(2)))));
	}
}
class Digit {
	// attribute
	public int value;
	
	// constructor
	public Digit(int input) {
		// current reference
		this.value = input;
	}
	@Override
	public String toString() {
		return "" + value;
	}
}

