package ex01_circle;

public class PosHelper {

	public static Pos getPos(Point p, Point o, int r) {

		double distance = Math.sqrt(Math.pow((p.getX() - o.getX()), 2) + Math.pow((p.getY() - o.getY()), 2));

		if (distance == r) {
			return Pos.ONSIDE;
		}
		if (distance > r) {
			return Pos.OUTSIDE;
		}
		return Pos.INSIDE;

	}
}
