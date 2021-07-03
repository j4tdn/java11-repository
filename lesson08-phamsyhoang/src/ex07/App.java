package ex07;

import java.util.Arrays;

public class App {
	public static void main(String[] args) {
		String s = "aaabaaabbaaaaa";
		String[] arr = correctSubString(s);
		int max = max(arr);
		int min = min(arr);
		System.out.println("Độ dài lớn nhất của dãy con đúng của dãy S: " + arr[max].length() + " '" + arr[max] + "' "
				+ "[" + pos(arr, max) + "]");
		System.out.println("Độ dài nhỏ nhất của dãy con đúng của dãy S: " + arr[min].length() + " '" + arr[min] + "' "
				+ "[" + pos(arr, min) + "]");
	}

	private static String[] correctSubString(String s) {
		String[] arr = new String[s.length()];
		int i = 0;
		int tmp = 1;
		while (tmp < s.length()) {
			if (s.charAt(tmp) == s.charAt(tmp - 1)) {
				tmp++;
			} else {
				arr[i++] = s.substring(0, tmp);
				s = s.substring(tmp);
				tmp = 1;
			}
			if (tmp == s.length()) {
				arr[i++] = s.substring(0, tmp);
			}

		}
		return Arrays.copyOfRange(arr, 0, i);
	}

	public static int pos(String[] s, int pos) {
		int p = 0;
		for (int i = 0; i < pos; ++i) {
			p += s[i].length();
		}
		return p;
	}

	public static int max(String[] arr) {
		String max = arr[0];
		int pos = 0;
		for (int i = 0; i < arr.length; ++i) {
			if (max.length() < arr[i].length()) {
				max = arr[i];
				pos = i;
			}
		}
		return pos;
	}

	public static int min(String[] result) {
		String min = result[0];
		int p = 0;
		for (int i = 0; i < result.length; ++i) {
			if (min.length() > result[i].length()) {
				min = result[i];
				p = i;
			}
		}
		return p;
	}

}
