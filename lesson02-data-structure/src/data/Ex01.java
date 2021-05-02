package data;

import utlis.PrintUtils;

public class Ex01 {
	public static void main(String[] args) {
		// primitive type
		// store: Stack
		// format code: Ctrl + shifl + f
		int age = 10;
		boolean gender = false;
		float avgPoint = 8.7f;
		char level = 'A';
		String name = "Hung Loser";
		String fname = new String("Dung vipper");

		System.out.println("Age: " + age);
		System.out.println("Gender: " + gender);
		System.out.println("AgePoint: " + avgPoint + "\nLevel: " + level + "\nName: " + name);
        
		PrintUtils.hash("hash Name" , name);
		PrintUtils.hash("hash Fname" , fname);
	}
	


}
