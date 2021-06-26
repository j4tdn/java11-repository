package demo;

import java.io.IOException;

import exception.ZeroException;

public class Ex02 {
	public static void main(String[] args) {
		int a = 10;
		int b = 0;

		try {
			System.out.println("result: " + divide(a, b));
		} catch (ZeroException e) {
			e.printStackTrace();
		}
		System.out.println("Main end");
	}

	private static int divide(int a, int b) {
		// throws RuntimeException >> no mandatory to handle exception
		if (b == 0) {
			System.out.println("throw new");
			// throw new ArithmeticException();
			throw new ZeroException("Please enter a non-zero value");
		}
		System.out.println("return a / b");
		return a / b;

	}
}