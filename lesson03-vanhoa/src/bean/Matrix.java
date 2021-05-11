package bean;

import java.util.Random;

public class Matrix {
	private int columnLength;
	private int rowLength;
	private int[][] A;

	public Matrix() {
	}

	public Matrix(int columnLength, int rowLength) {
		this.columnLength = columnLength;
		this.rowLength = rowLength;
	}

	public int getColumnLength() {
		return columnLength;
	}

	public void setColumnLength(int columnLength) {
		this.columnLength = columnLength;
	}

	public int getRowLength() {
		return rowLength;
	}

	public void setRowLength(int rowLength) {
		this.rowLength = rowLength;
	}

	@Override
	public String toString() {
		return "Matrix [columnLength=" + columnLength + ", rowLength=" + rowLength + "]";
	}

	public void randomMatrix(int m,int n) {
		this.rowLength = m;
		this.columnLength = n;
		this.A = new int[m][n];
		Random rd = new Random();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				A[i][j] = 1 + rd.nextInt(100);
				System.out.printf("%-5d", A[i][j]);
			}
			System.out.println();
		}
	}
	public boolean isSaddle() {
		for (int i = 0; i < this.columnLength; i++) {
			int rowMin = this.A[i][0];
			int a = 0;
			for(int j = 0; j < this.rowLength; j++) {
				if(this.A[i][j] < rowMin) {
					rowMin = this.A[i][j];
					a = j;
				}
			}
			int colMax = rowMin;
			for(int k = 0; k < this.columnLength; k ++) {
				if(this.A[k][a] > colMax) {
					break;
				}
				if(k == this.columnLength - 1) {
					return true;
				}
			}
		}
		return false;
	}

}
