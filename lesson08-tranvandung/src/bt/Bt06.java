package bt;

import java.util.Scanner;

public class Bt06 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.println("Enter Range Number:");
		String s = ip.nextLine();
		int k = 1;
		System.out.println("Location Number Of k:");
		k = ip.nextInt();
		ip.close();
		System.out.println("Result: "+ s.charAt(k - 1));
	}
}
