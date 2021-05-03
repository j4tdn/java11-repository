package data;

import utils.PrintUtils;

public class Ex03 {
	public static void main(String[] args) {
<<<<<<< HEAD
		//JAVA type: HEAP
		//constant pool
		Integer age = 20;
		Integer day = 20;
		PrintUtils.hash("age", day);
		//normal heap
		Integer salary = new Integer(30);
		Integer exp = new Integer(30);
		PrintUtils.hash("salary", salary);
=======
		Integer age = 20;
		Integer day = 20;
		PrintUtils.hash("age", age);
		PrintUtils.hash("day", day);
		
		Integer salary = new Integer(30);
		PrintUtils.hash("salary", salary);
		Integer exp = new Integer(30);
>>>>>>> ba78b3a (lesson02-03 02.05.2021)
		PrintUtils.hash("exp", exp);
	}
}
