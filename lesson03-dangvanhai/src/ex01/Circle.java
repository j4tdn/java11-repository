package ex01;

public class Circle {
	private Point center;
	private int radius;

	public Circle() {

	}

	public Circle(Point center, int radius) {
		this.center = center;
		this.radius = radius;
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public String toString() {
		return "Circle [center=" + center + ", radius=" + radius + "]";
	}

	/**
	 * @param another point
	 * @return position of a point relative to this circle
	 */
	public Pos PosOfPoint(Point p) {
		// calculation distance
		double distance = Math.sqrt(Math.pow((center.getX() - p.getX()), 2) + Math.pow((center.getY() - p.getY()), 2));

		// return position
		if (distance > radius) {
			return Pos.OUTSIDE;
		}
		if (distance == radius) {
			return Pos.ONSIDE;
		}
		return Pos.INSIDE;
	}

}
