package bt1;
public class Utils {
	private Utils() {
	}
	
	public static Pos getPos(Circle circle, int x0, int y0, int R) {
		double distance = Math.sqrt(Math.pow((circle.getX() - x0), 2) + Math.pow((circle.getY() - y0), 2));
		if (distance == R) {
			return Pos.INSIDE;
		}
		if (distance > R) {
			return Pos.ONSIDE;
		}
		return Pos.OUTSIDE;
}
}
