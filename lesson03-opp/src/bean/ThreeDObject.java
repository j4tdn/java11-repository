package bean;

public class ThreeDObject {
	private int x;
	private int y;
	private int z;

	public ThreeDObject() {

	}

	public ThreeDObject(int x) {
		this.x = x;
	}

	public ThreeDObject(int x, int y,int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public String toString() {
		return "ThreeDObject [x=" + x + ", y=" + y + ", z=" + z + "]";
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setZ(int z) {
		this.z = z;
	}

}
