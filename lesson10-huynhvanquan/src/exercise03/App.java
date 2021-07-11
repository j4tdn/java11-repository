package exercise03;

import java.util.Arrays;
import java.util.Comparator;

public class App {
	public static void main(String[] args) {
		String[] strings = { "-2", "-6", "10", null, "4", "8", null, "Special", "a", "c", "b", "xx" };
		// Mode 1: Ascending
		// Mode -1: Descending
		sort(strings, -1);
		for (int i = 0; i < strings.length; i++) {
			System.out.print(strings[i] + " ");
		}

	}

	public static int compare(String s1, String s2) {
		if (s1 == null && s2 == null) {
			return 0;
		}
		if (s1 == null && s2 != null) {
			return 1;
		}
		if (s1 != null && s2 == null) {
			return -1;
		}
		if (s1.equals("Special") && s2.equals("Special")) {
			return 0;
		}
		if (s1.equals("Special") && !s2.equals("Special")) {
			return -1;
		}
		if (!s1.equals("Special") && s2.equals("Special")) {
			return 1;
		}
		if (isDigit(s1) && isDigit(s2)) {
			if (Integer.parseInt(s1) == Integer.parseInt(s2)) {
				return 0;
			}
			if (Integer.parseInt(s1) > Integer.parseInt(s2)) {
				return 1;
			}
			return -1;
		}
		if (isDigit(s1) && !isDigit(s2)) {
			return -1;
		}
		if (!isDigit(s1) && isDigit(s2)) {
			return 1;
		}
		return s1.compareTo(s2) == 0 ? 0 :
			  (s1.compareTo(s2) == 1 ? 1 : -1);
	}

	public static void sort(String[] strings, int mode) {
		for (int i = 0; i < strings.length - 1; i++) {
			for (int j = i + 1; j < strings.length; j++) {
				if (compare(strings[i], strings[j]) == mode) {
					String tmp = strings[i];
					strings[i] = strings[j];
					strings[j] = tmp;
				}
			}
		}
	}

	public static boolean isDigit(String s) {
		if (s.matches("^-?[0-9]+$")) {
			return true;
		}
		return false;
	}

}
