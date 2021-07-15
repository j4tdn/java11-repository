package sorting;

import bean.Item;
import utils.ArrayUtils;

public class Ex03 {
	public static void main(String[] args) {
		Item[] items = getItems();
//		for(int i = 0; i < items.length; i++) {
//			for(int j = 0; j < items.length - i - 1; j++) {
//				if(items[j].getName().compareTo(items[j+1].getName()) > 0) {
//					swap(items, j, j+1);
//				}
//			}
//		}
//		for(int i = 0; i < items.length; i++) {
//			for(int j = 0; j < items.length - i - 1; j++) {
//				
//				if(items[j].getStoreId() > items[j+1].getStoreId()) {
//					swap(items, j, j+1);
//					continue;
//				}
//				if(items[j].getStoreId() == items[j+1].getStoreId()) {
//					if(items[j].getItemId() < items[j+1].getItemId()) {
//						swap(items, j, j+1);
//					}
//				}
//			}
//		}
		for(int i = 0; i < items.length; i++) {
			for(int j = 0; j < items.length - i - 1; j++) {
				if(items[j].compareTo(items[j+1]) > 0) {
					swap(items, j, j+1);
				}
			}
		}
		ArrayUtils.printf(items);
	}

	private static Item[] getItems() {
		return new Item[] {
			new Item(1, 12, "a" , 278),
			new Item(3, 28, "B" , 123),
			new Item(2, 35, "e" , 467),
			new Item(1, 25, "C" , 345),
			new Item(3, 13, "d" , 132),
			new Item(6, 23, "A" , 434),
		};
	}
	public static void swap(Item[] items, int i, int j) {
		Item tmp = items[i];
		items[i] = items[j];
		items[j] = tmp;
	}
}
