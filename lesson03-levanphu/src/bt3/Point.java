package bt3;
	import java.util.Scanner;

	public class Point {
		static Scanner ip = new Scanner(System.in);

		public static void main(String[] args) {
			System.out.print("Nhap m : ");
			int M = ip.nextInt();
			System.out.print("Nhap n : ");
			int N = ip.nextInt();
			int[][] A = new int[M][N];
			input(A, M, N);
			view(A, M, N);
			if (Saddle(A, M, N) == 1) {
				System.out.println("no Saddle Point ");
			} else {
				System.out.println("Saddle Point is  : " + Saddle(A, M, N));
			}
		}

		private static void input(int A[][], int m, int n) {
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print("Nhap phan tu [" + i + " , " + j + "] = ");
					A[i][j] = ip.nextInt();
				}
			}
		}

		private static void view(int a[][], int m, int n) {
			System.out.println("Mang vua nhap : ");
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print("\t" + a[i][j]);
				}
				System.out.println();
			}
		}
		public static int Saddle(int A[][], int row, int col) {
			int min;
			int max;
			int n = 0;
			for (int i = 0; i < row; i++) {
				min = A[i][0];
				for (int j = 0; j < col; j++) {
					if (min > A[i][j]) {
						min = A[i][j];
						n = j;
					}
				}
				max = min;
				for (int j = 0; j < row; j++) {
					if (max < A[j][n]) {
						max = A[j][n];
					}
				}
				if (max == min) {
					return max;
				}
			}
			return 0;
		}
}
