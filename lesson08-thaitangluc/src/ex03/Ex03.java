package ex03;

import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		String s = ip.nextLine();
		System.out.println(StringUtils.removeAccent(s));
	}
}
