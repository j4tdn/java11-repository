package bean;

public class Dimension {
	//row's columns
	private int x;
	private int y;
	private int z;
	private int t;
	
	public Dimension() {
		
	}

	public Dimension(int x, int y, int z, int t) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
		this.t = t;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public int getT() {
		return t;
	}

	public void setT(int t) {
		this.t = t;
	}

	@Override
	public String toString() {
		return "(" + x + "," + y + "," + z + "," + t + ")";
	}
	
}
