package data;

import utils.PrintUtils;

public class Ex01 {

	public static void main(String[] args) {
		// primitive type
		// store: stack
		// format code: ctrl + shift + f
		// copy code: ctrl + alt + down
		
	
		// local variable
		int age = 20;
		boolean gender = false;
		float avgPoint = 8.7f;
		char level = 'A';
		
		// TODO: diff btw name & fname
		String name = "Adam";
		String fname = new String("John");
		
		PrintUtils.hash("hname: ", name);
		PrintUtils.hash("fname: ", fname);
		
		System.out.println("Age: " + age);
		System.out.println("Gender: " + gender);		
		System.out.println(
				"AvgPoint: " + avgPoint 
			  + "\nLevel: " + level 
			  +	"\nName: " + name);		

		
	}

}
