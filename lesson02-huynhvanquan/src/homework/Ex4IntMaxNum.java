package homework;

import java.util.Scanner;

public class Ex4IntMaxNum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String nums = sc.nextLine();
		String[] num = nums.split(" ");
		int max = Integer.parseInt(num[0]);
		for(String i : num) {
			if (max < Integer.parseInt(i) && Integer.parseInt(i) % 2 == 1) {
				max = Integer.parseInt(i);
			}
		}
		System.out.println("Max: " + max);
		
		
//		Scanner sc = new Scanner(System.in);
//		int num = sc.nextInt();
//		int max = num;
//		while (true) {
//			num = sc.nextInt();
//			if (max < num) {
//				max = num;
//			}
//		}
//		System.out.println("Max: " + max);
		
		
		
		
		
		
		
	}
}
