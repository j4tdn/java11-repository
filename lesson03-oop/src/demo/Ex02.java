package demo;

import bean.Rectangle;

public class Ex02 {
	// how many object were created?
	public static void main(String[] args) {
		Integer a = 10; // +
		String b = new String("hello");// +
		float c = 10.2f;
		Double d = 7d; // +
		Rectangle r1 = null;
		Rectangle r2 = new Rectangle();// +
		// new thì lúc runtime mới chạy
		Rectangle r3 = r2;
		String f = "welcome"; // +

	}
}
