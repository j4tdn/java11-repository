package sorting;

import java.util.Comparator;

import bean.Item;
import utils.ArrayUtils;

public class Ex03 {
	public static void main(String[] args) {
		Item[] items = getItems();
		// bubble sort
		Comparator<Item> comparator = new Comparator<Item>() {
			
			@Override
			public int compare(Item o1, Item o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
		};
		sort(items, comparator);
		
	}
	private static void sort(Item[] items, Comparator<Item> comparator) {
		// bubble sort
			for(int i = 0; i < items.length; i++) {
				for(int j = 0 ; j < items.length -i -1; j++) {
					if(comparator.compare(items[j], items[j+1]) > 0) {
						swap(items, j, j+1);
					}
				}
			}
	}
	
	private static int compare(Item i1, Item i2) {
		return i1.compareTo(i2);
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
