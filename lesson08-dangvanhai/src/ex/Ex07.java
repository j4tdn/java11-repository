package ex;

import java.util.Arrays;

public class Ex07 {
	public static void main(String[] args) {
		String line = "aaabaaabbaaaaa";

		System.out.println("min: " + minTrueSubSequence(line));
		System.out.println("max: " + maxTrueSubSequence(line));
	}

	private static int minTrueSubSequence(String line) {
		return Arrays.stream(numberTrueSubSequence(line)).min().getAsInt();
	}

	private static int maxTrueSubSequence(String line) {
		return Arrays.stream(numberTrueSubSequence(line)).max().getAsInt();
	}

	private static int[] numberTrueSubSequence(String line) {
		int[] arr = new int[line.length()];
		int index = 0;

		char tmp = line.charAt(0);
		int count = 1;

		for (int i = 1; i < line.length(); i++) {
			if (line.charAt(i) == tmp) {
				count++;
			} else {
				arr[index++] = count;
				count = 1;
				tmp = line.charAt(i);
			}
		}
		arr[index] = count;
		return Arrays.copyOfRange(arr, 0, count);
	}
}
