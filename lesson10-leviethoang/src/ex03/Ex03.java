package ex03;

import java.util.Arrays;

public class Ex03 {
	public static void main(String[] args) {
		String[] strings = { "-2", "-6", "10", null, "4", "8", null, "Special", "a", "c", "b", "xx" };
		print(strings);
		System.out.println("========================");
		sort(strings);
		print(strings);
		System.out.println("========================");
		print(reverse(strings));
		
	}

	private static void print(String[] strings) {
		for (String string : strings) {
			System.out.print(string + " ");
		}
		System.out.println();
	}

	private static void sort(String[] strings) {
		int length = strings.length - 1;
		for (int i = 0; i < length - 1; i++) {
			if ("Special".equals(strings[i])) { // Special First
				String tmp = strings[i];
				strings[i] = strings[0];
				strings[0] = tmp;
			}

			if (strings[i] == null) { // null last
				String tmp = strings[i];
				strings[i] = strings[length];
				strings[length--] = tmp;
			}
		}

		String[] newStrings = Arrays.copyOfRange(strings, 1, length + 1);
		Arrays.sort(newStrings);

		Integer[] tmp = new Integer[newStrings.length];
		int index = 0;

		for (int i = 0; i < newStrings.length; i++) {
			if (!isDigit(newStrings[i])) {
				tmp[index++] = Integer.parseInt(newStrings[i]);
			}
		}
		Integer[] digits = Arrays.copyOfRange(tmp, 0, index);
		Arrays.sort(digits); // -6 -2 4 8 10

		for (int i = 0; i < digits.length; i++) {
			newStrings[i] = digits[i].toString(); // -6 -2 4 8 10 a b c xx
		}

		for (int i = 1; i < length + 1; i++) {
			strings[i] = newStrings[i - 1];
		}
	}

	private static String[] reverse(String[] strings) {
		String[] newStrings = new String[strings.length];
		int index = 0;
		for(int i = strings.length - 1; i >= 0; i--) {
			newStrings[index ++] = strings[i];
		}
		return newStrings;
	}

	private static boolean isDigit(String str) {
		return str.matches("[a-zA-Z~!@#$%^&*(){}||?,.]+");
	}

}
