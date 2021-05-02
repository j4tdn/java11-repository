package data;

import utils.PrintUtils;

public class Ex03 {
	public static void main(String[] args) {
		Integer age = 20;
		Integer day = 20;
		PrintUtils.hash("age", age);
		PrintUtils.hash("day", day);
		
		Integer salary = new Integer(30);
		PrintUtils.hash("salary", salary);
		Integer exp = new Integer(30);
		PrintUtils.hash("exp", exp);
	}
}
