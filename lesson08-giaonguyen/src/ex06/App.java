package ex06;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		String num = "123133476476519785748548654857409189384975846575055847";
		int k = 0;
		char[] c = num.toCharArray();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Input K: ");
		k = sc.nextInt();
		
		System.out.println("result: " + c[k-1]);
	}
}
