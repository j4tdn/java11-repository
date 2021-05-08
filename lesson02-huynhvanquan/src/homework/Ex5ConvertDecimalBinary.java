package homework;

import java.util.Scanner;

public class Ex5ConvertDecimalBinary {
	public static void main(String[] args) {
		int decimalNumber;
		int[] x = new int[20];
		int i = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter decimal number: ");
		decimalNumber = sc.nextInt();
		while (decimalNumber != 0) {
			x[i++] = decimalNumber % 2;
			decimalNumber = decimalNumber / 2;
		}
		System.out.println("Binary Number: ");
		while (i >= 0) {
			System.out.print(x[i--]);
		}
		
	}

}
