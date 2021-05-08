package demo;

import bean.Rectangle;

public class Ex01 {
	public static void main(String[] args) {
		Rectangle r1 = new Rectangle();
		r1.setHeight(6);
		r1.setWidth(8);
		System.out.println("r1: " + r1);
		
		Rectangle r2 = new Rectangle(12,16);
		System.out.println("r2: " + r2);
		
		System.out.println(r1 instanceof Rectangle);
	}
}
