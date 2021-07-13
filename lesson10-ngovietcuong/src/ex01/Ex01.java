package ex01;

import java.util.Arrays;

import utils.Utils;

public class Ex01 {
	public static void main(String[] args) {
		int[] digits = { 1, 2, 3, 4, 3, 1 };
		System.out.println("So sanh gia tri TB cua s1(" + digits.length / 2 + " phan tu dau tien) va s2("
				+ digits.length / 2 + " phan tu cuoi cung) trong mang");
		System.out.println(compare(digits));

		System.out.println("===================");

		System.out.println("Mang sau khi loai bo nhung phan tu trung nhau");
		Utils.printf(removeElements(digits));

		System.out.println("\n===================");

		int[] d = { 8, 8, 7, 7, 6, 6, 2, 5, 1 };
		System.out.println("So lon thu 3 trong mang la: " + max(d));

	}

//	{1,2,3,4,3,1} 
//  {2,4} 
	private static int[] removeElements(int[] digits) {
		int[] c = new int[digits.length];
		int d = 0;
		int e = 0;
		for (int i = 0; i < digits.length; i++) {
			if (count(digits, i) == 1) {
				c[e++] = digits[i];
				d++;
			}
		}
		return Arrays.copyOfRange(c, 0, d);
	}

	private static String compare(int[] digits) {
		double s1 = 0;
		double s2 = 0;
		for (int i = 0; i < digits.length / 2; i++) {
			s1 = s1 + digits[i];
			s2 = s2 + digits[digits.length - 1 - i];
		}
		s1 = s1 / (digits.length / 2);
		s2 = s2 / (digits.length / 2);
		if (s1 > s2) {
			return "KQ: s1 > s2";
		}
		if (s1 < s2) {
			return "KQ: s1 < s2";
		}
		if (s1 == s2) {
			return "KQ: s1 = s2";
		}
		return null;
	}

	private static int[] delete(int[] digits, int index) {
		int[] c = new int[digits.length - 1];
		for (int i = 0; i < c.length; i++) {
			if (i < index) {
				c[i] = digits[i];
			} else {
				c[i] = digits[i + 1];
			}
		}
		return c;
	}

	private static int count(int[] digits, int index) {
		int c = digits[index];
		int d = 0;
		for (int i = 0; i < digits.length; i++) {
			if (c == digits[i]) {
				d++;
			}
		}
		return d;
	}

	private static int max(int[] digits) {
		int tmp;
		for (int i = 0; i < digits.length - 1; i++) {
			for (int j = i + 1; j < digits.length; j++) {
				if (digits[i] < digits[j]) {
					tmp = digits[i];
					digits[i] = digits[j];
					digits[j] = tmp;
				}
			}
		}
		int max = 0;
		int c = 0;
		int d = 0;
		for (int i = 0; i < digits.length; i++) {
			if (count(digits, i) == 1) {
				d++;
			}
			c = digits[i];
			if (count(digits, i) != 1 && c != digits[i + 1]) {
				d++;
			}
			if (d == 2) {
				max = digits[i + 1];
				return max;
			}
		}
		return max;
	}
}
