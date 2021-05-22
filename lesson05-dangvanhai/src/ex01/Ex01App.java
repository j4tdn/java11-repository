package ex01;

import java.util.Arrays;


// fail
public class Ex01App {
	public static void main(String[] args) {
		int[] input = new int[] {3, 15, 21, 0, 15, 17, 21};
		int[] result = getUniqueNumbers(input);
		for(var i : result) {
			System.out.print(i + " ");
		}
	}
	
	private static int[] getUniqueNumbers(int[] a) {
		Arrays.sort(a);
		int[] result = new int[a.length];
		for(int i=0; i< a.length; i++) {
			if(isUniqueNumber(a, a[i])) {
				result[i] = a[i];
			}
		}
		return result;
	}

	private static boolean isUniqueNumber(int[] a, int number) {
		for(int i=0; i<a.length; i++) {
			if(a[i]== number) {
				return false;
			}
		}
		return true;
	}
}
