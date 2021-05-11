package bai1;

public class CheckUtil {

	private CheckUtil() {
	}

	public static Pos getPos(Circle circle, Point point) {
		double distance = Math
				.sqrt(Math.pow((point.getxA() - circle.getxO()), 2) + Math.pow((point.getyA() - circle.getyO()), 2));
		if (distance == circle.getR()) {
			return Pos.ONSIDE;
		}
		if (distance > circle.getR()) {
			return Pos.OUTSIDE;
		}
		return Pos.INSIDE;
	}

}
