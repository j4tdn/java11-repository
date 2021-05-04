package demo;

import bean.Rectangle;

public class Ex02 {
	public static void main(String[] args) {
		//How many objects were created?
		Integer a = 10; // +
		String b = new String("Hello"); // +
		float c = 10.2f;
		Double d = 7d; // +
		Rectangle r1 = null;
		System.out.println(r1.getHeight());
		Rectangle r2 = new Rectangle(); // +
		Rectangle r3 = r2;
		String f = "wellcom"; // +
	}
}
