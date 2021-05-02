package data;

import utlis.PrintUtils;

public class Ex04 {
	public static void main(String[] args) {
		Integer age = 20;
		System.out.println("age: " + age);
		
		PrintUtils.hash("hash", age);
		increase(age);
		System.out.println("i age: " + age);
		Integer salary = 20;
		PrintUtils.hash("hash salary",salary);
	}
	
	private static void increase(Integer input) {
		PrintUtils.hash("1.input: ", input);
		input =30;
		PrintUtils.hash("2.input: ", input);
	}
	
	

}
