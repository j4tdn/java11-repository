package demo;

import bean.Circle;
import bean.Point;
import bean.Pos;
import utils.PosUtils;

public class Hw1 {
	public static void main(String[] args) {
		Circle Q = new Circle(0, 0, 5f);
		System.out.println("Circle Q = " + Q);
		Point A = new Point(3, 4);
		System.out.println("Point A = " + A);
		Pos p = PosUtils.getPos(A, Q);
		if(p == Pos.ONSIDE) {
			System.out.println("Point A" + A + " onside Q" + Q);
		}
		
	}

}
