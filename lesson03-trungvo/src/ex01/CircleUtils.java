package ex01;

public class CircleUtils {
	private CircleUtils() {
		// TODO Auto-generated constructor stub
	}
	
	public static Pos getPos(PointA pA, int xO, int yO, int R ) {
		double distance = Math.pow((pA.getX() - xO), 2) + Math.pow((pA.getY() - yO), 2);
		if (distance == R) {
			return Pos.INSIDE;
		}
		if (distance > R) {
			return Pos.OUTSIDE;
		}
		return Pos.ONSIDE;
	}
	
}
