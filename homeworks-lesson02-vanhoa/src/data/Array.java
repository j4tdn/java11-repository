package data;

import java.util.function.Predicate;

public class Array {
	public static void main(String[] args) {
		int[] a = {5,6,7,10,3,100,99};
		int numberOdd = checkOdd(a);
		System.out.println(numberOdd);
//		int numberodd=Test(a, t->t%2==0);
//		System.out.println(numberodd);
	}

	private static int checkOdd(int[] a) {
		int max = a[0];
		for (int i = 1; i < a.length; i++) {

			if (a[i] % 2 != 0 && a[i] >= max) {
				max = a[i];
			}
		}
		return max;

	}
//	private static int Test(int[]a,Predicate<Integer> predicate)
//	{
//		int max=a[0];
//		for (int i = 1; i < a.length; i++) {
//
//			if (predicate.test(a[i]) && a[i] >= max) {
//				max = a[i];
//			}
//		}
//		return max;
//	}

}
