package data;

import utils.PrintUtils;

public class Ex04 {
	public static void main(String[] args) {
		Integer age = 20;
		System.out.println("age" + age);
		
		PrintUtils.hash("hash age", age);
		increase(age);
		PrintUtils.hash("hash age", age);
	}

	private static void increase(Integer age) {
		PrintUtils.hash("1", age);
		age = 30;
		PrintUtils.hash("1", age);
	}
}
