package sorting;

import bean.Item;
import utils.ArrayUtils;

public class Ex03 {
	public static void main(String[] args) {
		Item[] items = getItems();
		// bubble sort
		for(int i = 0; i < items.length; i++) {
			for(int j = 0 ; j < items.length -i -1; j++) {
				if(items[j].compareTo(items[j+1]) > 0) {
					swap(items, j, j+1);
				}
				/*
				if(items[j].getStoreId() > items[j+1].getStoreId()) {
					swap(items, j, j+1);
					continue;
				}
				if(items[j].getStoreId() == items[j+1].getStoreId()) {
					if(items[j].getItemId() > items[j+1].getItemId()) {
						swap(items, j, j+1);
					}
				}
				*/
			}
		}
		ArrayUtils.printf(items);
		
	}
	private static Item[] getItems() {
		return new Item[] {
				new Item(1, 28, "A", 278),
				new Item(1, 27, "C", 32),
				new Item(3, 25, "t", 48),
				new Item(4, 14, "e", 24),
				new Item(5, 22, "d", 223),
				new Item(6, 10, "s", 41),		
		};
	}
	private static void swap(Item[] items, int i, int j) {
		Item tmp = items[j];
		items[j] = items[i];
		items[i] = tmp;
	}
}
