package Ex01;

import java.util.Arrays;

import utils.ArrayUtils;

public class ManipulatingWithArray {

	public static void main(String[] args) {
		int[] digits1 = { 1, 2, 3, 4, 3, 1 };

		RemoveDuplicateElements(digits1);

		ArrayUtils.printf(RemoveDuplicateElements(digits1));

		int[] digits2 = { 7, 8, 8, 8, 6, 2, 5, 1 };
		System.out.println(comparaInArray(digits2));
		
		int[] digits3 = {7,8,8,8,6,2,5,1};
		
		System.out.println(find3rdMax(digits3));

	}

	private static int[] RemoveDuplicateElements(int[] digits) {
		int end = digits.length;

		for (int i = 0; i < end; i++) {
			for (int j = i + 1; j < end; j++) {
				if (digits[i] == digits[j]) {
					int shiftLeft = j;
					for (int k = j + 1; k < end; k++, shiftLeft++) {
						digits[shiftLeft] = digits[k];
					}
					end--;
					j--;
				}
			}
		}

		int[] whitelist = new int[end];
		for (int i = 0; i < end; i++) {
			whitelist[i] = digits[i];
		}
		return whitelist;
	}

	private static String comparaInArray(int[] digits2) {
		int sumFrist = 0;
		int sumLast = 0;
		for (int i = 0; i < (digits2.length) / 2; i++) {
			sumFrist += digits2[i];
		}
		for (int j = digits2.length / 2; j < digits2.length; j++) {
			sumLast += digits2[j];
		}

		if (sumFrist == sumLast) {
			return "equal";
		}

		return sumFrist > sumLast ? "greater" : "smaller";

	}

	private static int find3rdMax(int[] digits3) {
		Arrays.sort(digits3);

		int[] newArray = RemoveDuplicateElements(digits3);

		return newArray[newArray.length-3];
	}

}
