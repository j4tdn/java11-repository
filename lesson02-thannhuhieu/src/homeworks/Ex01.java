package homeworks;

import java.util.Scanner;

public class Ex01 {
	// Viết chương trình kiểm tra 1 số có phải là lũy thừa của 2 hay không
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			int[] arr = new int[n];

			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}

			int maxValue = arr[0];
			for (int i = 1; i < n; i++) {
				if (arr[i] > maxValue) {
					maxValue = arr[i];
				}
			}

			System.out.print(maxValue);
		}
}

