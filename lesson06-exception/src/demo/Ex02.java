package demo;

import exception.ZeroException;

public class Ex02 {
	public static void main(String[] args) {
		int a = 10;
		int b = 0;
		try {
		System.out.println("result: " + divide(a,b));
		} catch (ZeroException e) {
			e.printStackTrace();
		}
	}
	
	private static int divide(int a, int b) {
		// throws RuntimeException >> No mandatory to handle exception
		if (b == 0) {
			System.out.println("throw new");
			throw new ZeroException("please enter non-zero value");
		}
		return a / b;
	}
}
