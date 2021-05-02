package demo;

import bean.Rectangle;

public class Ex01 {
	public static void main(String[] args) {
		Rectangle r1 = new Rectangle(9, 6);
		System.out.println("r1: " + r1);
		Rectangle r2 = new Rectangle();
		r2.setHeight(15);
		r2.setWidth(20);
		System.out.println(r2);
		//difference new and set and get

	}
}
