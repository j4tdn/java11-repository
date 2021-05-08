

import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		long tong = factorial(4) + factorial(7) + factorial(12) + factorial(18);
		System.out.println("S = 4! + 7! + 12! +18! = " + tong);
	}
	private static long factorial(int n) {
		long result = 1;
		if(n == 0 || n == 1) {
			return result;
		}
		else {
			for(int i = 2; i <= n; i ++) {
				result *= i;
			}
		return result;		
		}
	}

}
