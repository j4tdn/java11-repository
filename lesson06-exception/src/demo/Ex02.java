package demo;

import java.io.IOException;

public class Ex02 {
	public static void main(String[] args) {
		System.out.println("main start");
		int a = 10;
		int b = 0;
		
		try {
			System.out.println("result: " + divide(a,b));
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Main end");
	}
	
	private static int divide(int a, int b) throws IOException{
		//ArithmeticException
		//throws Runtime Exception >> no mandatory to handle exception
		if ( b== 0) {
			System.out.println("throw new");
			throw new IOException();
		}
		System.out.println("Return a/b ");
		return a/b;
	}
}
