package data;

import utils.PrintUtils;

public class Ex01 {
	public static void main(String[] args) {
//		primitive type
//		store: STACK
//		format code: ctrl + shift + f
		int age = 20;
		boolean gender = false;

//		float phai co f luc khai bao gia tri mac dinh
		float avgPoint = 8.7f;

//		dau '': cho ky tu
		char level = 'A';

//		dau "": cho chuoi
		String name = "Adam";
		String fname = new String("Join");

		PrintUtils.hash("hash name: ", name);
		PrintUtils.hash("hash fname: ", fname);

//		prinln: co "ln" la in xong xuong hang
		System.out.println("Age: " + age);
		System.out.println("Gender: " + gender);
		System.out.println("AgePoint: " + avgPoint + "\nLevel: " + level + "\nName: " + name);
	}

}
