package ex02;

import java.util.Arrays;

public class App {
	public static void main(String[] args) {
		
		String s1 = "01a2b3456cde478";
		String s2 = "1a6b326c6e22h";
		
		String[] num1 = s1.split("[a-z]+");
		String[] num2 = s2.split("[a-z]+");

		int[] result1 = detach(num1);
		int[] result2 = detach(num2);
		
		int max1 = findNumMax(result1);
		int max2 = findNumMax(result2);
		System.out.println(max1);
		System.out.println(max2);
		
		if (max1 > max2) System.out.println(max2 + " " + max1);
		else System.out.println(max1 + " " + max2);

	}
	
	public static int findNumMax(int[] num) {
		
		int max = num[0];
		for (int i = 1; i < num.length; ++i) {
			if (max < num[i]) {
				max = num[i];
			}
		}
		
		return max;
	}
	
	public static int[] detach(String[] num) {
		int[] numToInt = new int[num.length];
		int count = 0;
		for (String n: num) {
			numToInt[count++] = Integer.parseInt(n);
		}
		
		return numToInt;
	}
	
}
