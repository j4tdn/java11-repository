package data;

import utils.PrintUtils;

public class Ex01 {
	public static void main(String[] args) {
		// primitive type
		// store: STACK
		// formar code: ctrl shift F
		int age = 20;
		boolean gender = false;
		float avgPoint = 8.7f;
		char lever = 'A';
		
		//todo:diff btw name & fname
		String name = "Adam";
		String fname = new String("join");
		
		PrintUtils.hash("hash name", name);
		PrintUtils.hash("fname", fname);

		System.out.println("Age: " + age);
		System.out.println("Gender: " + gender);
		System.out.println("AgePoint: " + avgPoint + "\nLever: " + lever + "\nName: " + name);

	}
}
