package demo;

import bean.Rectangle;

public class Ex02 {
	//how many object were created;
	public static void main(String[] args) {
		Integer a = 10; //1
		String b = new String("asd"); //2
		float c = 10.2f;
		Double d = 7d; //3
		Rectangle r1 = null;
		Rectangle r2 = new Rectangle(); //4
		Rectangle r3 = r2;
		String f = "welcome"; //5
	}
}
