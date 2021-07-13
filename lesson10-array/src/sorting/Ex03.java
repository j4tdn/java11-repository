package sorting;

import bean.Item;
import utils.ArrayUtils;

public class Ex03 {
	public static void main(String[] args) {
		Item[] items = getItem();
		
		for(int i = 0; i < items.length; i++) {
			for(int j = 0; j < items.length - i -1; j++) {
				if(items[j].compareTo(items[j + 1]) > 0) {
				swap(items, j, j + 1);
			}
		}
	}
		
		ArrayUtils.printf(items);
}
	
	private static void swap(Item[] items, int i, int j) {
		Item tmp = items[i];
		items[i] = items[j];
		items[j] = tmp;
		
	}

	private static Item[] getItem() {
		return new Item[] {
			new Item(1, 12, "a", 278),
			new Item(2, 27, "B", 12),
			new Item(3, 12, "c", 278),
			new Item(2, 29, "D", 259),
			new Item(1, 18, "f", 278),
			new Item(1, 10, "K", 159),
			new Item(4, 12, "B", 47),
		};
	}
}
