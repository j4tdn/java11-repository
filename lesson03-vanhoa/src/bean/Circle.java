package bean;

public class Circle {
	private int xCenter;
	private int yCenter;
	private float radius;
	
	public Circle() {
	}

	public Circle(int xCenter, int yCenter, float radius) {
		this.xCenter = xCenter;
		this.yCenter = yCenter;
		this.radius = radius;
	}

	public int getxCenter() {
		return xCenter;
	}

	public void setxCenter(int xCenter) {
		this.xCenter = xCenter;
	}

	public int getyCenter() {
		return yCenter;
	}

	public void setyCenter(int yCenter) {
		this.yCenter = yCenter;
	}

	public float getRadius() {
		return radius;
	}

	public void setRadius(float radius) {
		this.radius = radius;
	}

	@Override
	public String toString() {
		return "[(" + xCenter + "; " + yCenter + "), " + radius + "]";
	}
	

}
