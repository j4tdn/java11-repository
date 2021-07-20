package sorting;

import java.util.Comparator;

import bean.Item;
import utils.ArrayUtils;

public class Ex03 {
	public static void main(String[] args) {
		Item[] items = getItems();

		Comparator<Item> comparator = new Comparator<Item>() {

			@Override
			public int compare(Item i1, Item i2) {
				return i1.compareTo(i2);
			}
		};
		
		// bubble sort
		sort(items, comparator);
		
		ArrayUtils.printf(items);
	}

	private static void sort(Item[] items, Comparator<Item> comparator) {
		// bubble sort
		for (int i = 0; i < items.length; i++) {
			for (int j = 0; j < items.length - i - 1; j++) {
				if (comparator.compare(items[j], items[j+1]) > 0) {
					swap(items, j, j + 1);
				}
			}
		}
	}

	private static int compare(Item i1, Item i2) {
		return i1.compareTo(i2);
	}

	private static Item[] getItems() {
		return new Item[] { new Item(1, 12, "a", 278.2d), 
							new Item(2, 27, "B", 12.2d), 
							new Item(3, 12, "c", 228),
							new Item(2, 29, "D", 259), 
							new Item(1, 18, "f", 278), 
							new Item(1, 10, "K", 159),
				new Item(4, 12, "B", 47), };
	}

	private static void swap(Item[] items, int i, int j) {
		Item tmp = items[i];
		items[i] = items[j];
		items[j] = tmp;
	}
}