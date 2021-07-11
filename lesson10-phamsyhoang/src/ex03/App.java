package ex03;

import java.util.ArrayList;
import java.util.Arrays;

import static utils.ArrayUtils.*;

public class App {

	public static String PATTERN_DIGIT = "-?[0-9]";
	public static String PATTERN_STRING = "[a-zA-Z]+";

	public static void main(String[] args) {
		String[] strings = { "-2", "-6", "10", null, "8", "4", null, "Special", "a", "c", "b", "xx" };
		System.out.println("Mảng xếp theo thứ tự tăng dần: ");
		printf(increase(strings));
		System.out.println("\nMảng xếp theo thứ tự giảm dần: ");
		printf(decrease(strings));
	}

	private static String[] increase(String[] strings) {
		String[] result = new String[strings.length - 1];
		// Loại bỏ "Special" ra khỏi mảng strings và gán cho phần tử đầu tiên trong mảng
		// result
		for (int i = 0; i < strings.length; i++) {
			if (strings[i] == "Special") {
				result[0] = strings[i];
				strings = removeElement(strings, i);
			}
		}

		// Tạo 2 mảng String: digits dạng số, str dạng chuỗi
		String[] digits = new String[strings.length];
		String[] str = new String[strings.length];

		int count_d = 0; // đếm số lượng phần tử trong digits[]
		int count_s = 0; // đếm số lượng phần tử trong str[]

		for (String s : strings) {
			if (s == null) {
				continue;
			}
			if (s.matches(PATTERN_DIGIT)) {
				digits[count_d++] = s;
			}
			if (s.matches(PATTERN_STRING)) {
				str[count_s++] = s;
			}
		}

		digits = Arrays.copyOfRange(digits, 0, count_d);

		int[] intarray = new int[digits.length];
		int i = 0;
		for (String d : digits) {
			intarray[i++] = Integer.parseInt(d); // Chuyển digits từ String[] -> int[]
		}
		// Sắp xếp theo thứ tự tăng dần
		Arrays.sort(intarray);

		String[] sarray = new String[intarray.length];
		for (int n = 0; n < intarray.length; n++) {
			sarray[n] = String.valueOf(intarray[n]); // Chuyển từ int[] về lại String[]
		}

		str = Arrays.copyOfRange(str, 0, count_s);
		Arrays.sort(str);

		// Nối các mảng lại với nhau
		int count = 1;
		for (String d : sarray) {
			result[count++] = d;
		}
		for (String s : str) {
			result[count++] = s;
		}

		return result;
	}

	private static String[] decrease(String[] strings) {
		String[] result = new String[strings.length - 1];
		String[] str = increase(strings);
		for (int i = str.length - 1; i >= 0; i--) {
			result[result.length - 1 - i] = str[i];
		}
		return result;
	}

	private static String[] removeElement(String[] str, int pos) {
		String[] result = new String[str.length - 1];
		for (int i = 0; i < str.length; i++) {
			if (i < pos) {
				result[i] = str[i];
			} else if (i > pos) {
				result[i - 1] = str[i];
			}
		}
		return result;
	}
}
