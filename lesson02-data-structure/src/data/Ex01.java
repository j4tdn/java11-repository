package data;

import utils.PrintUtils;

public class Ex01 {
	public static void main(String[] args) {
		// cprimitive type
		// store : STACK
		// format code : ctrl shift f
		int age = 20;
		boolean gender = false;
		float avgPoint = 8.7f;
		char level = 'A';
		String name = "nguyen trung hieu";
		String fname = new String ("Join");
		
		PrintUtils.hash("hashname", name);
		PrintUtils.hash("fname", name);
		
		//ctrl alt down
		System.out.println("Age: " + age);
		System.out.println("Gender: " + gender);
		System.out.println(
				"agePoint: " + avgPoint
				+ "\nLevel: " + level
				+ "\nName: " + name);
	
		
	}
	
	}


