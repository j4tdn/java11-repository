package data;

import utils.PrintUtils;

public class Ex01 {
	public static void main(String[] args) {
		// primitive type
		// store: STACK
		//format code: Ctrl shift F
		int age = 20;
		boolean gender = false;
		float avgPoint = 8.7f;
		char level = 'A';
		
		//TODO: diff btw name &fname
		String name = "Adam";
		String fname = new String("Join");
		
		PrintUtils.hash("hash name", name);
		PrintUtils.hash("hash fname", fname);
		
		//Ctrl Alt XUONG
		System.out.println("Age: " + age);
		System.out.println("Gender: " + gender);
		System.out.println(
				"AvePoint: " +avgPoint 
				+"\nLevel: " + level
				+"\nName: " +name
		);
		
		
		
	
	
	
	}
}
