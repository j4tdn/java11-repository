

import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.print("Nhap so dao nguoc: ");
		int num = ip.nextInt();
		int num1 = num;
		int reversed = 0;
		while (num != 0) {
			int digit = num % 10;
			reversed = reversed * 10 + digit;
			num /= 10;
		}
		System.out.println(num1 + " is" + (reversed == num1 ? " reverse" : " not reverse") + " number");
	}

}
