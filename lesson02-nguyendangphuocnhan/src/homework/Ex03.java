package homework;

import java.util.Scanner;

public class Ex03 {
	
//	Nhập vào một số bất kỳ. Kiểm tra số đó có phải là số đối xứng hay không
	
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.println("Number: ");
		int n = Integer.parseInt(ip.nextLine());
		System.out.println(n + " is a symmetric number?: " + isSymmetrical(n));
	}

	public static boolean isSymmetrical(int n) {
		int reversed = 0;
		int origin = n;
		while (n != 0) {
			int remainder = n % 10;
			reversed = reversed * 10 + remainder;
			n = n / 10;
		}
		if (reversed == origin) {
			return true;
		}else {
			return false;
		}
	}
}