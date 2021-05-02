package data;

import utils.PrintUtils;

public class Ex01 {

	public static void main(String[] args) {
		// primitive type
		// stack
		// format code : ctrl + shift + F
		int age = 20;
		boolean gender = false;
		float avgPoint = 8.7f;
		char level = 'A';
		
		// TODO : diff btw name & fname;
		String name = "Adam";
		String fname = new String("Adam");
		
		PrintUtils.hash("name", name);
		PrintUtils.hash("fname", fname);
		
		System.out.println("tuoi" + age);
		System.out.println("Gender" + gender);
		System.out.println(
				"avgPoint " + avgPoint
				+"\nLevel " + level
				+"\n name " + name
				);
		
	}
	
}
