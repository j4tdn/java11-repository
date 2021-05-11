package bai1;

public class Point {
	private int xA;
	private int yA;
	
	public Point() {
	}

	public Point(int xA, int yA) {
		super();
		this.xA = xA;
		this.yA = yA;
	}

	public int getxA() {
		return xA;
	}

	public void setxA(int xA) {
		this.xA = xA;
	}

	public int getyA() {
		return yA;
	}

	public void setyA(int yA) {
		this.yA = yA;
	}

	@Override
	public String toString() {
		return "Point [xA=" + xA + ", yA=" + yA + "]";
	}
	
	
}
