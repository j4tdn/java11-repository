package demo;

import bean.Rectangle;

public class Ex01 {
	public static void main(String[] args) {
		Rectangle r1 = new Rectangle(8, 9);
		System.out.println(r1);
		
		Rectangle r2 = new Rectangle();
		r2.setWidth(5);
		r2.setHeight(10);
		System.out.println(r2);
	}
}
