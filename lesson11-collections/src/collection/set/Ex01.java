package collection.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import bean.Item;

public class Ex01 {
	public static void main(String[] args) {
		Set<Item> digits = new HashSet<>();
		digits.add(new Item(101, 1, "A", 120));
		digits.add(new Item(102, 2, "A", 120));
		digits.add(new Item(103, 3, "A", 120));
		digits.add(new Item(101, 1, "A", 120));

		System.out.println(digits.size());

		for (Item digit : digits) {
			System.out.println(digit);
		}

		Iterator<Item> each = digits.iterator();
		while (each.hasNext()) {
			System.out.println(each.next());
		}
	}

}
