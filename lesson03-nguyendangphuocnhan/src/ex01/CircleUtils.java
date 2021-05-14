package ex01;

public class CircleUtils {

	public static Pos getPos(Point pA, Point pO, int r) {
		double distance = Math.sqrt(Math.pow(pA.getX() - pO.getX(), r) + Math.pow((pA.getY() - pO.getY()), 2));

		if (distance == r) {
			return Pos.ONSIDE;
		}
		if (distance > r) {
			return Pos.OUTSIDE;
		}
		return Pos.INSIDE;
	}
}
