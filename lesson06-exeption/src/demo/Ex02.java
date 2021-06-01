package demo;

import exception.ZeroException;

public class Ex02 {
	public static void main(String[] args) {
		int a = 5;
		int b = 0;

		try {
			System.out.println("result: " + divide(a, b));
		} catch (ZeroException e) {
			e.printStackTrace();
		}
		System.out.println("Main End");

	}

	private static int divide(int a, int b) {
		
		if(b==0) {
			throw new ZeroException("Please enter a non-zero value");
			
		}
		System.out.println("return a/b");
		return a / b;

	}
}
