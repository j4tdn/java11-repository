package demo;

import bean.Rectangle;

public class Ex01 {
	
	public static void main(String[] args) {
		Rectangle r1 = new Rectangle();
		r1.setWidth(8);
		r1.setHeight(4);
		System.out.println(r1);
		

		Rectangle r2 = new Rectangle(3, 4);
		System.out.println(r2);
		
		
		
		System.out.println(r1 instanceof Rectangle);
	}

}
