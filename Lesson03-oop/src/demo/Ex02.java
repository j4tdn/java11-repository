package demo;

import bean.Rectangle;

public class Ex02 {
	public static void main(String[] args) {
		// đối tượng được tạo trên heap trong giai đoạn runtime
		// con trỏ chính là ô nhớ trên heap
		Integer a = 10; // +
		String b = new String("hello"); // +
		float c = 3f;
		Double d = 7d; // +
		Rectangle r1 = null;
		Rectangle r2 = new Rectangle(); // +
		Rectangle r3 = r2;
		String f = "welcome";// +
	}

}
