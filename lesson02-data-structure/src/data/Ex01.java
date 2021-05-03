package data;

import utils.PrintUtils;

public class Ex01 {
	public static void main(String[] args) {
		// primitive type
		// store: STACK
		// format code: ctrl shift f
		int age = 20;
		boolean gender = false;
		// float should have 'f' after value
		float avgPoint = 8.7f;
		// char only allow 1
		// single quote is for char
		char level = 'A';
		// String is object data type and is class
		// double quotes is for string
		String name = "Adam";
		String fname = new String("Join");
		
		//import method from class 'PrintUtils'	
		PrintUtils.hash("hash name", name);	
		PrintUtils.hash("hash fname", fname);
		

		// break line after printing
		System.out.println("Age: " + age);
		// ctrl + alt + down: copy
		System.out.println("Gender: " + gender);
		System.out.println("AgePoint: " + avgPoint + "\nLevel: " + level + "\nName: " + name);
	}
	
}
