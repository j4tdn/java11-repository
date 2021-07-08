package ex03;

import java.util.Arrays;
import java.util.Comparator;

import static ex03.DataType.*;

public class Ex03Main {
	public static void main(String[] args) {
		String[] arr = { "-2", "-6", "10", null, "4", "8", null, "Special", "a", "c", "b", "xx" };
		System.out.println("Original Array: \n" + Arrays.toString(arr));
		
		Arrays.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String str1, String str2) {
				if (str1 == null) {
					return 1;
				}

				if (str2 == null) {
					return -1;
				}

				if (str1.equals(str2)) {
					return 0;
				}

				if (typeOf(str1) != typeOf(str2)) {
					return DataType.compare(typeOf(str1), typeOf(str2));
				} else if (typeOf(str1) == NUMERIC) {
					int diff = Integer.parseInt(str1) - Integer.parseInt(str2);
					return (diff < 0) ? -1 : (diff == 0) ? 0 : 1;
				} else {
					return str1.compareTo(str2);
				}

			}
		});

		System.out.println("Sorted Array: \n" + Arrays.toString(arr));
	}
}
