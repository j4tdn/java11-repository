package exercise02;

import java.util.Arrays;

public class App {
	public static void main(String[] args) {
		int[][] a = { { 1, 2, 3, 4 }, { 5, 0, 8, 7 }, { 1, 9, 0, 9 }, { 2, 0, 6, 5 }, { 1, 2, 4, 5 } };
		Element[] elem = getZeroElement(a);
		process(elem, a);
		printArray(a);
	}

	public static Element[] getZeroElement(int[][] arr) {
		int row = arr.length;
		int col = arr[0].length;
		Element[] elemArr = new Element[row * col];
		int count = 0;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (arr[i][j] == 0) {
					elemArr[count++] = new Element(i, j);
				}
			}
		}
		return Arrays.copyOfRange(elemArr, 0, count);
	}

	public static void process(Element[] elem, int[][] a) {
		for (int i = 0; i < elem.length; i++) {
			int x = elem[i].getX();
			int y = elem[i].getY();
			for (int j = 0; j < a[0].length; j++) {
				a[x][j] = 0;
			}
			for (int j = 0; j < a.length; j++) {
				a[j][y] = 0;
			}
		}
	}

	public static void printArray(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}

}
