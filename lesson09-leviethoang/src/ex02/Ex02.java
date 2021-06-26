package ex02;

import java.util.Arrays;

public class Ex02 {
	public static void main(String[] args) {
		String[] result = getLargestNumbers("aa6b546c6e22h", "aa6b326c6e22h");
		int[] it = new int[result.length];
		for (int i = 0; i < it.length; i++) {
			it[i] = Integer.parseInt(result[i]);
		}
		Arrays.sort(it);
		printf(it);
	}

	private static void printf(int[] result) {
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}

	private static String getLargestNumbers(String strings) {
		String[] str = strings.split("[a-zA-Z]+");
		String Max = "";

		for (int i = 0; i < str.length; i++) {
			if (str[i].length() > Max.length()) {
				Max = str[i];
			}
		}

		for (int i = 0; i < str.length; i++) {
			if (str[i].length() == Max.length() && str[i].compareTo(Max) > 0) {
				Max = str[i];
			}
		}

		return Max;
	}

	private static String[] getLargestNumbers(String... strings) {
		String[] result = new String[strings.length];
		int index = 0;
		for (String string : strings) {
			result[index++] = getLargestNumbers(string);
		}

		return Arrays.copyOfRange(result, 0, index);
	}
}
