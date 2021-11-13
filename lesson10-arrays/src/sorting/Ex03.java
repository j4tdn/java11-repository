package sorting;

import Utils.ArraysUtils;
import bean.Item;

public class Ex03 {
	public static void main(String[] args) {
		Item item1 = new Item(12, "A", 10);
		Item item2 = new Item(24, "C", 20);
		Item item3 = new Item(18, "F", 30);
		Item item4 = new Item(24, "D", 18);
		Item item5 = new Item(18, "E", 30);
		Item[] items = { item1, item2, item3, item4, item5 };

		for (int i = 0; i < items.length; i++) {
			for (int j = 0; j < items.length - i - 1; j++) {
				Item pre = items[j];
				Item next = items[j + 1];
				if (pre.getId() < next.getId())
					continue;
				if (pre.getId() > next.getId()) {
					Item item = pre;
					pre = next;
					next = item;
					continue;
				}
				if (pre.getName().compareTo(next.getName()) < 0) {
					Item item = pre;
					pre = next;
					next = item;
					continue;
				}
			}
		}
		ArraysUtils.printf(items);
	}
}
