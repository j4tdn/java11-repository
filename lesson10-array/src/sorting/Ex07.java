package sorting;

import java.util.Arrays;
import java.util.Comparator;
import static java.util.Comparator.*;
import bean.Item;
import utils.ArrayUtils;

public class Ex07 {
	public static void main(String[] args) {
		Item[] items = getItems();
		
		Arrays.sort(items, comparing(i -> i.getName()));
		ArrayUtils.printf(items);
		
		System.out.println("======================");
		
		Comparator.reverseOrder();
		// compare(o1, o2) >>>  compare(o2, o1)
		/*
		 * 1 3
		 * 1 2
		 * 2 4
		 * 2 2
		 */
		
		Comparator<Item> comparator = comparing(i -> i.getStoreId(), reverseOrder());
		Arrays.sort(items, comparator.thenComparing(i -> i.getItemId()).reversed());
		ArrayUtils.printf(items);
	}
	
	private static Item[] getItems() {
		return new Item[] {
			new Item(1, 12, "a", 278.2d),
			new Item(2, 27, "B", 12.2d),
			new Item(3, 12, "c", 228),
			new Item(2, 29, "D", 259),
			new Item(1, 18, "f", 278),
			new Item(1, 10, "K", 159),
			new Item(4, 12, "B", 47),
		};
	}
}
