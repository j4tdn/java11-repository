package enumeration;

public class Ex01 {	
	private static final double PI = 3.14d;
	private static final String COLOR_RED = "RED";
	
	public static void main(String[] args) {
		// A: xA, yA
		// Circle: O: xO, yO - R
		// Point: x, y
		
		Point pA = new Point(3, 4);
		Point pO = new Point(0, 0);
		int R = 6;
		
		Position pos = getPos(pA, pO, R);
		if (pos == Position.INSIDE) {
			System.out.println("pos: " + pos); //default: name
			System.out.println("Calculate");
		}
		System.out.println(pos);
	}
	
	private static Position getPos(Point point, Point pO, int R) {
		double distance = Math.sqrt(Math.pow(point.x - pO.x, 2) + Math.pow(point.y - pO.y, 2));
		if (distance == R) {
			return Position.ONSIDE;
		}
		if (distance > R) {
			return Position.OUTSIDE;
		}
		return Position.INSIDE;
		
	}
}
