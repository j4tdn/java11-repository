package bai1;

public class Circle {
	private int xO;
	private int yO;
	private int R;

	public Circle() {
	}

	public Circle(int xO, int yO, int r) {
		this.xO = xO;
		this.yO = yO;
		R = r;
	}

	public int getxO() {
		return xO;
	}

	public void setxO(int xO) {
		this.xO = xO;
	}

	public int getyO() {
		return yO;
	}

	public void setyO(int yO) {
		this.yO = yO;
	}

	public int getR() {
		return R;
	}

	public void setR(int r) {
		R = r;
	}

	@Override
	public String toString() {
		return "Circle [xO=" + xO + ", yO=" + yO + ", R=" + R + "]";
	}

}
