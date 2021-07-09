package ex02;

public class Point {
	private int row;
	private int col;
	
	public Point() {
	}

	public Point(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	@Override
	public String toString() {
		return "Point [row=" + row + ", col=" + col + "]";
	}
	
	
}
