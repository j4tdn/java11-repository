package data;

import utils.PrintUtils;

public class Ex03 {
	public static void main(String[] args) {
		//JAVA type: HEAP
		// constant pool
		Integer age = 20;
		Integer day = 20;
		
		PrintUtils.hash("age", age);
		PrintUtils.hash("day", day);
		
		// normal heap
		Integer salary = new Integer(30);
		Integer exp = new Integer(30);
		PrintUtils.hash("salary", salary);
		PrintUtils.hash("exp", exp);
	}

}
