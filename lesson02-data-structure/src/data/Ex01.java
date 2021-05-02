package data;

import utils.PrintUtils;

public class Ex01 {
	public static void main(String[] args) {
		// primitive type
		// store: STACK
		// format CODE: ctrl + shift + F
		int age = 20;
		boolean gender = false;
		float avgPoint = 8.7f;
		char level = 'A';
		String name = "Nguyen Chuong";
		String fname = new String("Join");
		System.out.println("Age: " + age);
		//Ctrl + Alt + down button
		System.out.println("Gender: " + gender);
		System.out.println("AgePoint: " + avgPoint
				+	"\nLevel: " + level
				+ 	"\nName: " + name
				);
		PrintUtils.hash("name", name);
	}
	
}
