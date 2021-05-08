

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner i = new Scanner(System.in);
		System.out.print("nhap input: ");
		int a = i.nextInt();
		boolean input = isLT(a);
		System.out.println( input ? " la luy thua cua 2" : " khong phai la luy thua cua 2");
	}
	private static boolean isLT(int a) {
		return Math.sqrt(a) % 2 == 0;
	}

}
