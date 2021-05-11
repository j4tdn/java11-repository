package ex1;

import java.time.LocalDate;
import java.time.Month;

public class PointUtils {
	private PointUtils() {
	}

	public static Pos getPos(Point O, int R, Point A) {
		double distance = Math.sqrt(Math.pow(A.getX(), 2) + Math.pow(A.getY(), 2));
		if (distance < R) {
			return Pos.INSIDE;
		}
		if (distance > R) {
			return Pos.OUTSIDE;
		}
		return Pos.ONSIDE;
	}

}
