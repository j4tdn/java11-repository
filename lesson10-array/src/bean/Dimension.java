package bean;

public class Dimension {
	private int X;
	private int Y;
	private int Z;
	private int T;
	
	public Dimension() {
		
	}

	public Dimension(int x, int y, int z, int t) {
		X = x;
		Y = y;
		Z = z;
		T = t;
	}

	public int getX() {
		return X;
	}

	public void setX(int x) {
		X = x;
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		Y = y;
	}

	public int getZ() {
		return Z;
	}

	public void setZ(int z) {
		Z = z;
	}

	public int getT() {
		return T;
	}

	public void setT(int t) {
		T = t;
	}

	@Override
	public String toString() {
		return "Dimension [X=" + X + ", Y=" + Y + ", Z=" + Z + ", T=" + T + "]";
	}
	
}
