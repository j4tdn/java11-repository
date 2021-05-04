package Java11;

import java.util.Scanner;

public class Bt5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 0;
		while (true) {
			System.out.print("Nhap so he co so 10: ");
			n = Integer.parseInt(sc.nextLine());
			System.out.println("So " + n + " trong he co so 2 = " + numbers(n));
		}
	}

	public static String numbers(int n) {
		String result = "";
		while (n > 0) {
			result = n % 2 + result;
			n /= 2;
		}
		return result;
	}

}
