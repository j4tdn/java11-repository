package demo;

import org.w3c.dom.css.Rect;

import bean.Rectangle;

public class Ex02 {
	// how many objects were created ?
	public static void main(String[] args) {
		Integer a = 10; // +
		String b = new String("hello"); // +
		float c = 10.2f;
		Double d = 7d; // +
		Rectangle r1 = null;
		System.out.println(r1.getHeight());
		Rectangle r2 = new Rectangle(); // +
		Rectangle r3 = r2;
		String f = "welcome"; // +
		// 4 3 5 6 5 4
	}
}
