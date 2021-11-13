package demo;

import bean.Box;

public class App {
	public static void main(String[] args) {
		//Initial 2 boxes
		//Box1: w8 h4 
		//Box2: w6 h3
		//Box3: w2 h1 
		
		//initial object from class
		// Use 'new' keyword to call constructor
		//NullPointerException: NPE
		Box box1 = new Box();
		box1.setWidth(8);
		box1.setWidth(4);
		
		Box box2 = new Box();
		box2.setWidth(6);
		box2.setWidth(3);
		
		Box box3 = new Box(2,1); 
		Box box4 = new Box(10,5);
		
		System.out.println(box1);
		System.out.println(box2);
		System.out.println(box3);
		System.out.println(box4);
	}
}
