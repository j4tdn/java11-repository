package ex02;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n; 
		String s = "";
		System.out.println("Ban muon nhap bao nhieu chuoi: ");
		n = sc.nextInt();
		sc.nextLine();
		int[] max_num = new int[n];
		
		for (int i = 0; i < n; i++) {
			System.out.println("Nhap chuoi thu " + (i + 1) + ": ");
			s = sc.nextLine();
			max_num[i] = findMax(s);
		}
		max_num = toAccending(max_num);
		System.out.print("Ket qua:");
		for(int i: max_num) {
			System.out.print(" " + i);
		}
	}
	
	private static int findMax(String str) {
		int max = 0;
		for (String s: str.split("[a-zA-z]+")) {
			if (!s.isEmpty() && Integer.parseInt(s) > max) {
				max = Integer.parseInt(s);
			}
		}
		return max;
	}
	
	private static int[] toAccending(int[] num) {
		for (int i = 0; i < num.length - 1; i++) {
			for (int j = i + 1; j < num.length; j++) {
				if (num[i] > num[j]) {
					int tmp = num[i]; 
					num[i] = num[j]; 
					num[j] = tmp;
				}
				
			}
		}
		return num;
	}
}
