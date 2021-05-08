package data;

import java.awt.print.Printable;

import utils.PrintUtils;

public class Ex01 {
	public static void main(String[] args) {
		//primitive type
		//store : STACK 
		//format code : ctrl shift f
		int age =20;
		boolean gender = false;
		float avgPoint = 8.7f;
		char level = 'A';
		String name = "Adam";
		String fname = new String("Join");//khai bao cach khac cua string
		PrintUtils.hash("hashname ", name);
		PrintUtils.hash("fname ", fname);
		//ctrl alt down
		System.out.println("Age: " + age);
		System.out.println("Genger: " + gender);
		System.out.println(
				"Avgpoint: " + avgPoint
				+"\nLevel: " + level
				+"\nName: " + name
				);
	}
    
	
	
}
