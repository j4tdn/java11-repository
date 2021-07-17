package exercises;

import java.util.Arrays;

public class Ex03 {

	public static void main(String[] args) {
		String[] strings = { "-2", "-6", "10", null, "4", "8", null, "Special", "c", "a", "b", "xx" };

		sort(strings);
	}

	private static void sort(String[] strings) {
		for (int out = strings.length - 1; out > 0; out--) {
			for (int in = 0; in < out; in++) {

				if (strings[in] == null) {
					continue;
				}

				if (strings[in].equals("Special")) {
					String tmp = strings[in];
					strings[in] = strings[out];
					strings[out] = tmp;
					continue;
				}
				
				if (isInteger(strings[in]) && isInteger(strings[out])) {
					if (Integer.parseInt(strings[in]) < Integer.parseInt(strings[out])) {
						String tmp = strings[in];
						strings[in] = strings[out];
						strings[out] = tmp;
					}						
					continue;
				}
				
				if (strings[out] == null || strings[in].compareTo(strings[out]) < 0) {
					String tmp = strings[in];
					strings[in] = strings[out];
					strings[out] = tmp;
				}

			}
		}
		Arrays.stream(strings).forEach(string -> System.out.print(string + " "));
	}

	private static boolean isInteger(String input) {
		if (input == null) {
	        return false;
	    }
		try {
			Integer.parseInt(input);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}