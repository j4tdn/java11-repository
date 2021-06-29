package ex05;

import java.util.Arrays;

public class App {
	public static void main(String[] args) {
		String s1 = "ABCEDEABC";
		String s2 = "ABCEDCBBCK";
		longComSub(s1, s2);
	}

	private static void longComSub(String s1, String s2) {
		String[] arr = new String[100];
		int count = 0;
		for (int i = 0; i < s1.length() - 1; i++) {
			for (int j = i + 1; j < s1.length(); j++) {
				if (s2.contains(s1.substring(i, j))) {
					arr[count++] = s1.substring(i, j);
				}
			}
		}

		String[] realArr = new String[count];
		for (int i = 0; i < realArr.length; i++) {
			realArr[i] = arr[i];
		}

		String max = realArr[0];
		for (int i = 0; i < realArr.length; i++) {
			max = max(max, arr[i]);
		}
		System.out.println(max);
	}

	private static String max(String x, String y) {
		if (x.length() > y.length()) {
			return x;
		}
		return y;
	}
}
