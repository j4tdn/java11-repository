package exercise01;

public class Circle {
	private Point center;
	private int R;

	public Circle() {
	}

	public Circle(Point center, int r) {
		this.center = center;
		R = r;
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public int getR() {
		return R;
	}

	public void setR(int r) {
		R = r;
	}

	@Override
	public String toString() {
		return "Circle [center=" + center + ", R=" + R + "]";
	}

	public Location checkLocation(Point point) {
		double range = Math.sqrt(Math.pow(point.getX() - center.getX(), 2) + Math.pow(point.getY() - center.getY(), 2));
		if (range == R) {
			return Location.ON_CIRCLE;
		}
		if (range < R) {
			return Location.IN_CIRCLE;
		}
		return Location.OUTSIDE_CIRCLE;
	}
}
