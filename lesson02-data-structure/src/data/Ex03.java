package data;

import utils.PrintUtils;

public class Ex03 {
	public static void main(String[] args) {
		
		//int age = 20: age is save at stack, 20 is saved at stack
		
		//Java type
		//constant pool
		Integer age = 20; //age is saved at stack, 30 should be saved at heap
		Integer day = 20;
		PrintUtils.hash("age", age);
		PrintUtils.hash("day", day);
		
		//normal heap
		Integer salary = new Integer(30); //new Integer(30) is saved at heap
		Integer exp = new Integer(30); //new Integer(30) is saved at heap
		PrintUtils.hash("salary", salary);
		PrintUtils.hash("exp", exp);
	}
}
