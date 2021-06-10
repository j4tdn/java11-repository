package demo;

import bean.Rectangle;

public class Ex01 {
	public static void main(String[] args) {
		//h8, w4
		Rectangle r1 = new Rectangle();
		r1.setHeight(8);
		r1.setWidth(4);
		System.out.println("r1: " + r1);
		
		//h10,w12
		Rectangle r2 = new Rectangle(10,12);
		System.out.println("r2: " + r2);
		System.out.println(r1 instanceof Rectangle);
	}
}
