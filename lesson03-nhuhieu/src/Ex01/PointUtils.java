package Ex01;

public class PointUtils {
	private PointUtils() {
	}

	public static Position getPos(Point O, int R, Point A) {
		double distance = Math.sqrt(Math.pow(A.getX(), 2) + Math.pow(A.getY(), 2));
		if (distance < R) {
			return Position.INSIDE;
		}
		if (distance > R) {
			return Position.OUTSIDE;
		}
		return Position.ONSIDE;
	}
}