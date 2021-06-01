package demo;

import exception.ZeroException;

public class Ex02 {
	public static void main(String[] args) {
		int a = 10;
		int b = 0;
		try {
			System.out.println("Result : " + divide(a, b));
		} catch (ZeroException e) {
			// System.out.println("Message" + e.getMessage();
		e.printStackTrace();
		}
		
	}
	
	private static int divide(int a, int b)  throws ZeroException{
		// ArithmeticException 
		// throws RuntimeException >> no manition  
		if(b == 0) {
			// ZeroException
			System.out.println("Throw new");
			//throw new ArithmeticException();
			throw new ZeroException("Please enter a non-zero value");
		}
		System.out.println("a / b");
		return a / b;
	}
}
