package data;

import utils.PrintUtils;

public class Ex03 {
	public static void main(String[] args) {
//		JAVA type
//		constant pool
		Integer age = 20; //age, day luon nam o Stack, 20 nam o Heap
		Integer day = 20;
		
		PrintUtils.hash("age", age);
		PrintUtils.hash("day", age);
		
//		normal heap
//		never used
		Integer salary = new Integer(30);
		Integer exp = new Integer(30);
		PrintUtils.hash("salary", salary);
		PrintUtils.hash("exp", exp);
	}
}
