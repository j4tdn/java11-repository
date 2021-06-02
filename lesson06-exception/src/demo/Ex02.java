package demo;

import exception.ZeroException;

public class Ex02 {
	public static void main(String[] args) {
		int a = 10;
		int b = 0;
		System.out.println("Start main");
		
		try {
			System.out.println("result: " + divide(a, b));
		} catch (ZeroException e) {
			e.printStackTrace();
		}
		
		System.out.println("End main");
	}
	
	private static int divide(int a, int b) throws ZeroException {
		// Arithmetic Exception
		if(b == 0) {
			System.out.println("throw new");
			//throw new ArithmeticException();
			throw new ZeroException("Please Enter a non-zero value");
		}
		System.out.println("return a / b");
		return a / b;
	}
}
