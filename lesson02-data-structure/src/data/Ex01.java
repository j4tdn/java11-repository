package data;

import java.rmi.activation.ActivationSystem;

import utils.PrintUtils;

public class Ex01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// primitive type
		// store: STACK
		int age = 20;
		boolean gender = false;
		float avgPoint = 8.7f;
		char level = 'A';
		String name = "Hoang Thai Son";
		String fname = new String("Join");
		System.out.println("Age: " + age);
		System.out.println("Gender: " + gender);
		System.out.println("AgePoint: " + avgPoint+"\nLevel: "+level+"Name: " +name);
		PrintUtils.hash("Name",name);
		PrintUtils.hash("fName",fname);
	}

	

}
