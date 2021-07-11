package bt03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Bt03 {
	public static void main(String[] args) {
		String[] str = { "-2", "-6", "10", null, "4", "8", null, "Special", "a", "c", "b", "xx" };
		List<String> list = new ArrayList<String>(Arrays.asList(str));

		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i) == null) {
				list.remove(i);
				list.add(null);
				continue;
			} else if ("special".equals(list.get(i))) {
				list.remove(i);
				list.add(0, "special");
				continue;
			}

			for (int j = i + 1; j < list.size(); j++) {
				try {
					int num1 = Integer.parseInt(list.get(i));
					int num2 = Integer.parseInt(list.get(j));
					if (num1 > num2) {
						String temp = list.get(i);
						list.set(i, list.get(j));
						list.set(j, temp);
					}
				} catch (Exception e) {
					if (list.get(i) != null && list.get(j) != null) {
						if (list.get(i).compareTo(list.get(j)) > 0) {
							String temp = list.get(i);
							list.set(i, list.get(j));
							list.set(j, temp);
						}
					}
				}
			}
		}
		System.out.println("Sort up ascending: " + list);
		Collections.reverse(list);
		System.out.println("Sort descending: " + list);

	}
}
