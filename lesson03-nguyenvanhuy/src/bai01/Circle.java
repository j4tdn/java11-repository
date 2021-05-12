package bai01;

public class Circle {
	private int x0;
	private int y0;
	private int radius;
	
	public Circle() {
		
	}
	

	public Circle(int x0, int y0, int radius) {
		super();
		this.x0 = x0;
		this.y0 = y0;
		this.radius = radius;
	}


	public int getx0() {
		return x0;
	}


	public void setx0(int x0) {
		this.x0 = x0;
	}


	public int gety0() {
		return y0;
	}


	public void sety0(int y0) {
		this.y0 = y0;
	}


	public int getRadius() {
		return radius;
	}


	public void setRadius(int radius) {
		this.radius = radius;
	}


	@Override
	public String toString() {
		return "Circle [x0=" + x0 + ", y0=" + y0 + ", radius=" + radius + "]";
	}

	public Pos PosOfPoint(Circle circle , Point point) {
		double distance = Math.sqrt(Math.pow((point.getxA() - circle.getx0()), 2) + Math.pow((point.getyA() - circle.gety0()), 2));
		if (distance > radius) {
			return Pos.OUTSIDE;
		}
		if (distance == radius) {
			return Pos.ONSIDE;
		}
		return Pos.INSIDE;
	}
}
