package ex01;

import java.util.Arrays;

public class App {
	public static void main(String[] args) {
		int[] origin = {1,3,4,4,2,3,1,7,5,1,5,7};
		
		int[] result = removeDupl(origin);
		
		for (int r: result) {
			System.out.print(r + " ");
		}
		System.out.println("\n============");
		
		compare(origin);
		
		System.out.println("\n============");
		
		System.out.println("Max third number is " + getNum(origin, 3));
	}
	
	private static int[] removeDupl(int[] origin) {
		int count = 0;
		int[] result = new int[origin.length];
		Arrays.sort(origin);
		for (int i = 1; i < origin.length - 1; i++) {
			if (origin[i] == origin[i-1]) {
				continue;
			}
			else if ((origin[i] != origin[i-1]) && (origin[i] != origin[i+1])) {
				result[count++] = origin[i];
			}	
		}
		
		if (origin[origin.length - 1] != origin[origin.length - 2]) result[count++] = origin[origin.length - 1];
		
		return Arrays.copyOfRange(result, 0, count);
	}
	
	private static void compare(int[] origin) {
		int sumStAvg = 0;
		int sumNdAvg = 0;
		for (int i = 0; i <= origin.length / 2; i++) {
			sumStAvg += origin[i];
		}
		sumStAvg = sumStAvg / (origin.length/2);
		
		for (int i = origin.length/2 + 1; i < origin.length; i++) {
			sumNdAvg += origin[i];
		}
		sumNdAvg = sumNdAvg / (origin.length - origin.length/2);
		
		if (sumStAvg == sumNdAvg) System.out.println(sumStAvg + " = " + sumNdAvg);
		else if (sumStAvg > sumNdAvg) System.out.println(sumStAvg + " > " + sumNdAvg);
		else System.out.println(sumStAvg + " < " + sumNdAvg);
		
	}
	
	private static int getNum(int[] origin, int pos) {
		int num = 0;
		int count = 1;
		Arrays.sort(origin);
		for (int i = origin.length -1 ; i > 0; i--) {
			if (origin[i] == origin[i-1]) {
				continue;
			}
			else {
				count++;
			}
			
			if (count == pos) {
				num = origin[i-1];
				break;
			}
		}
		
		return num;
	}
}
