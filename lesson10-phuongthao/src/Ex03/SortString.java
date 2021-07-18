package Ex03;

import java.util.Arrays;
import java.util.Comparator;
import utils.ArrayUtils;

public class SortString {
	public static void main(String[] args) {
		String[] strings = { "-2", "6", "Special", "-10", null, "4", "-8", null, "Special", "7", "5", "a", "c", "b",
				"xx" };

		Arrays.sort(strings, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1 == "Special" || o2 == null) {
					return -1;
				}

				if (o2 == "Special" || o1 == null) {
					return 1;
				}

				try {
					int n1 = Integer.parseInt(o1);
					int n2 = Integer.parseInt(o2);
					return n1 - n2;
				} catch (Exception e) {
					return o1.compareTo(o2);
				}
			}
		});

		ArrayUtils.printf(strings);
		ArrayUtils.reverse(strings);
		ArrayUtils.printf(strings);


	}

}
