package sorting;

import bean.Item;
import utils.ArrayUtils;

public class Ex03 {
	public static void main(String[] args) {
		Item[] items = getItems();
		for (int i = 0; i < items.length; i++) {
			for (int j = 0; j < items.length - 1 - i; j++) {
				if (items[j].getName().compareTo(items[j + 1].getName()) > 0) {
					swap(items, j, j + 1);
				}
			}
		}
		ArrayUtils.printf(items);

		for (int i = 0; i < items.length; i++) {
			for (int j = 0; j < items.length - 1 - i; j++) {
				if (items[j].getStoreId() == items[j + 1].getStoreId()) {
					if (items[j].getItemId() < items[j + 1].getItemId()) {
						swap(items, j, j + 1);
						
					}
				}
				if(items[j].getStoreId() > items[j + 1].getStoreId()) {
					swap(items, j, j + 1);
					continue;
				}
			}
		}
		ArrayUtils.printf(items);
	}

	private static void swap(Item[] items, int j, int i) {
		Item tmp = items[i];
		items[i] = items[j];
		items[j] = tmp;

	}

	private static Item[] getItems() {
		return new Item[] { new Item(1, 12, "a", 278), new Item(2, 27, "B", 12), new Item(3, 12, "c", 278),
				new Item(2, 29, "D", 259), new Item(1, 18, "f", 278), new Item(1, 10, "k", 159),
				new Item(4, 12, "B", 47) };
	}
}
