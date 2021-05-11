package Ex03_SaddleElement;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		
		System.out.print("Nhập số hàng M của mảng: ");
		int M = ip.nextInt();
		
		System.out.print("Nhập số cột N của mảng : ");
		int N = ip.nextInt();
		
		int[][] A = new int[M][N];
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print("Nhập A[" + i + "]" + "[" + j + "]: ");
				A[i][j] = ip.nextInt();
				while (A[i][j] < 1 || A[i][j] > 99) {
					System.out.print("Nhập lại A[" + i + "]" + "[" + j + "]: \n");
					A[i][j] = ip.nextInt();
				}
			}
		}

		for (int i = 0; i < 3; i++) {
			System.out.println("====BẢNG A====");
			for (int j = 0; j < 3; j++) {
				System.out.print(A[i][j] + "\t");
			}
			System.out.print("\n");
		}

		int colum = 0;
		for (int i = 0; i < A.length; i++) {
			int row = i;
			int min = A[i][0];
			for (int j = 0; j < A[0].length; j++) {
				if (A[i][j] < min) {
					min = A[i][j];
					colum = j;
				}
			}

			boolean isMax = true;
			for (int r = 0; r < A.length; r++) {
				if (A[r][colum] > min) {
					isMax = false;
					break;
				}
			}
			if (isMax)
				System.out.println("Phần tử yên ngựa là :" + "A[" + row + "]" + "[" + colum + "] = " + A[row][colum]);
		}
	}
}
