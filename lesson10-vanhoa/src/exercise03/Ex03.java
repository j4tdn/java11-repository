package exercise03;

import java.util.ArrayList;
import java.util.Arrays;

import utils.ArrayUtils;

public class Ex03 {
	public static void main(String[] args) {
		String[] strings = { "-2", "-6", "10", null, "4", "8", null, "Special", "a", "c", "b", "xx" };
		
		ArrayList<String> result = getSortArrays(strings);
		ArrayUtils.printf(result);
		reverse(result);
		ArrayUtils.printf(result);
	}
	
	private static ArrayList<String> getSortArrays(String[] strings) {
		int[] d = getDigitArrays(strings);
		String[] d1 = new String[d.length];
		for (int i = 0; i < d.length; i++) {
			d1[i] = Integer.toString(d[i]);
		}
		String[] s = getStringArrays(strings);

		ArrayList<String> result = new ArrayList<String>();

		for (int i = 0; i < strings.length; i++) {
			try {
				if (strings[i].equals("Special")) {
					result.add(strings[i]);
				}
			} catch (NullPointerException e) {
			}
		}
		for (int i = 0; i < d1.length; i++) {
			result.add(d1[i]);
		}

		for (int i = 0; i < s.length; i++) {
			result.add(s[i]);
		}
		for (int i = 0; i < strings.length; i++) {
			if (strings[i] == null) {
				result.add(null);
			}
		}

		return result;
	}
	
	private static void reverse(ArrayList<String> strings) {
		for (int i = 0; i < strings.size() / 2; i++) {
			String tmp = strings.get(i);
			strings.set(i, strings.get(strings.size() - i - 1));
			strings.set(strings.size() - i - 1, tmp);
		}
	}
	
	private static String[] getStringArrays(String[] strings) {
		String[] tmpA = new String[strings.length];
		int index = 0;
		for (int i = 0; i < strings.length; i++) {
			if (!(isDigit(strings[i])) && !(strings[i] == null) && !(strings[i].equals("Special"))) {
				tmpA[index++] = strings[i];
			}
		}

		String[] result = new String[index];
		for (int i = 0; i < index; i++) {
			result[i] = tmpA[i];
		}

		for (int i = 0; i < index - 1; i++) {
			for (int j = i + 1; j < index - 1; j++) {
				String tmp = "";
				if (result[j].length() < result[i].length()) {
					tmp = result[i];
					result[i] = result[j];
					result[j] = tmp;
				}
			}
		}

		return result;
	}

	private static int[] getDigitArrays(String[] strings) {
		int[] digits = new int[strings.length];
		int index = 0;

		for (int i = 0; i < strings.length; i++) {
			if (isDigit(strings[i])) {
				digits[index++] = Integer.parseInt(strings[i]);
			}
		}
		for (int i = 0; i < index; i++) {
			for (int j = i + 1; j < index; j++) {
				int tmp = 0;
				if (digits[j] < digits[i]) {
					tmp = digits[i];
					digits[i] = digits[j];
					digits[j] = tmp;
				}
			}
		}
		return Arrays.copyOfRange(digits, 0, index);
	}

	private static boolean isDigit(String string) {
		if (string == null || string.isEmpty()) {
			return false;
		}
		for (char c : string.toCharArray()) {
			if (!Character.isDigit(c) && !(c == '-')) {
				return false;
			}
		}

		return true;
	}
}
