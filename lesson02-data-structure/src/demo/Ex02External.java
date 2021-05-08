package demo;

import enumeration.Pos;

public class Ex02External {
	public static void main(String[] args) {
	

		int xA = 3;
		int yA = 4;
		int xO = 0;
		int yO = 0;
		int R = 2;
		Pos pos = getPos(xA, yA, xO, yO, R);
		
		if (pos == Pos.ONSIDE) {
			System.out.println("Value:  " + pos.value);
			System.out.println("(xA, yA) = (" +xA + ", " + yA + ")");
		}
		
	}
	
	private static Pos getPos(int xA, int yA, int xO, int yO, int R) {
		double distance = Math.sqrt(Math.pow((xA-xO), 2) + Math.pow((yA-yO), 2));
		if (distance == R) {
			return Pos.ONSIDE;
		}
		if (distance > R) {
			return Pos.OUTSIDE;
		}
		return Pos.INSIDE;
	}
}
