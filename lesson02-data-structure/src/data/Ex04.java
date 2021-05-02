package data;

import utils.PrintUtils;

public class Ex04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer age =20;
		System.out.println("age: " + age);
		PrintUtils.hash("hash age", age);
		increase(age);
		
		
		Integer salary = 20;
		PrintUtils.hash("hash salary", salary);
		
		salary = 30;
		PrintUtils.hash("hash salary", salary);

		

	}
	private static void increase(Integer input) {
		PrintUtils.hash("1/ ", input);
		input =30;
		PrintUtils.hash("2/",input);
	}

}