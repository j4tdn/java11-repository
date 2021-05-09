package data;

import utils.PrintUtils;

public class Ex04 {
	public static void main(String[] args) {
		Integer age = 20; // muốn tăng giá trị tại hàm void thì dùng cách tạo đối tượng new
		System.out.println("age: " + age);
		PrintUtils.hash("hash age", age);
		increase(age);
		System.out.println("i age: " + age);
		
		
	}

	private static void increase(Integer input) {
		PrintUtils.hash("1. input", input);
		input = 30;
		PrintUtils.hash("2. input", input);
	}

}
