package Ex01_Circle;

public class PosUtils {
	public static Pos getPos(Point A, Point O, float R) {
		double distance = Math.sqrt(Math.pow(A.getX() -O.getX(), 2) + Math.pow(A.getY() - O.getY(), 2));
		if (distance == R) {
			return Pos.ONSIDE;
		}
		if (distance > R) {
			return Pos.OUTSIDE;
		}
		return Pos.INSIDE;
	}
}
