package demo;

import bean.Rectangle;

public class Ex01 {
	public static void main(String[] args) {
		Rectangle r1 = new Rectangle();
		r1.setWidth(10);
		r1.setHeight(15);
		System.out.println(r1);

		Rectangle r2 = new Rectangle(9, 7);
		System.out.println(r2);

	}
}
