package ex01;

import java.util.Arrays;

public class Ex01 {
	public static void main(String[] args) {
		int[] origin = {1,2,3,4,3,1};
		
		int[] result = removeExcess(origin);
		
		for (int r: result) {
			System.out.print(r + " ");
		}
		System.out.println("\n============");
		
		System.out.println("\n============");
		
		System.out.println("3rd largest number " + get3rd(origin, 3));
	}
	
	private static int[] removeExcess(int[] origin) {
		int count = 0;
		int[] result = new int[origin.length];
		Arrays.sort(origin);
		
		if (origin[0] != origin[1]) 
			result[count++] = origin[0];
		
		for (int i = 1; i < origin.length - 1; i++) {
			if (origin[i] == origin[i-1]) 
				continue;		
			else if ((origin[i] != origin[i-1]) && (origin[i] != origin[i+1]))
				result[count++] = origin[i];
		}
		
		if (origin[origin.length - 1] != origin[origin.length - 2])
			result[count++] = origin[origin.length - 1];
		
		return Arrays.copyOfRange(result, 0, count);
	}
	private static int get3rd(int[] origin, int pos) {
		int num = 0;
		int count = 1;
		Arrays.sort(origin);
		for (int i = origin.length -1 ; i > 0; i--) {
			if (origin[i] == origin[i-1]) 
				continue;
			else 
				count++;
	
			if (count == pos) {
				num = origin[i-1];
				break;
			}
		}
		
		return num;
	}
}
	