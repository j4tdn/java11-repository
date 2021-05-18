package pascal;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int height = 0;
		System.out.println("Input height of triPascal: ");
		height = sc.nextInt();
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(triPascal(j,i) + "  ");
			}
			System.out.print("\n");
		}
	}
	
	public static int triPascal(int a, int b) {
		// row b, col a
		if (a == 0 || a == b) return 1;
		if (a == 1) return b;
		return triPascal(a-1, b-1) + triPascal(a, b-1);
	}
}
