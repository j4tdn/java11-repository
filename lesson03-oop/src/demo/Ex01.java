package demo;

import bean.Rectangle;

public class Ex01 {
	public static void main(String[] args) {
		// r1 : w8 h6
		Rectangle r1 = new Rectangle();
		r1.setWidth(8);
		r1.setHeight(6);
		System.out.println("r1 : " + r1);

		// r2 : w12 h6
		Rectangle r2 = new Rectangle(12, 6);
		System.out.println("r2 : " + r2);
		
		System.out.println(r1 instanceof Rectangle);
	}
}
