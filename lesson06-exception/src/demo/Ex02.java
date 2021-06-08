package demo;

import exception.ZeroException;

public class Ex02 {
	public static void main(String[] args) {
		int a = 10;
		int b = 0;
		
		try {
			System.out.println("result: " + divide(a, b));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Main end");
	}

	private static int divide(int a, int b) throws ZeroException{
		// ArithmeticException
		if(b == 0) {
			//throw new ArithmeticException();
			throw new ZeroException("Please enter non-zero value");
		}
		return a / b;
	}
}
