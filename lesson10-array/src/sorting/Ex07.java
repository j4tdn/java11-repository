package sorting;


import java.util.Comparator;

import static java.util.Comparator.*;

import java.util.Arrays;
import java.util.function.Function;


import bean.Item;
import utils.ArrayUtils;

public class Ex07 {
	public static void main(String[] args) {
		Item[] items = getItems();
		
//		Arrays.sort(items);
//		ArrayUtils.printf(items);// => sort theo comparable
		
//		Arrays.sort(items,new Comparator<Item>() {
//			@Override
//			public int compare(Item i1, Item i2) {
//				return i1.getItemId() - i2.getItemId();
//			}
//		}); 
//		ArrayUtils.printf(items); // =>  sort theo comparator
		
//		Comparator<Item> c1 = (Item i1, Item i2) -> {
//			return i1.getItemId() - i2.getItemId();
//		};
//		Arrays.sort(items,c1);
//		ArrayUtils.printf(items); => comparator ngan
		
		Comparator<Item> c2 = (i1, i2) -> i1.getItemId() - i2.getItemId();
		Arrays.sort(items,c2);
		ArrayUtils.printf(items);
		
		
//	    Arrays.sort(items,  comparing(i -> i.getName()));
//		ArrayUtils.printf(items);	    
//
//		System.out.println("====================");
//
//		Comparator<Item> comparator = comparing(i -> i.getStoreId(), reverseOrder());
//		Arrays.sort(items, comparator.thenComparing(i -> i.getItemId()).reversed());
//		ArrayUtils.printf(items);

	}

	private static Item[] getItems() {
	return new Item[] {
			new Item(1, 12, "a", 278.2d),
			new Item(2, 27, "B", 12.2d),
			new Item(3, 12, "c", 278),
			new Item(2, 29, "D", 259),
			new Item(1, 18, "f", 278),
			new Item(1, 10, "k", 159),
			new Item(4, 12, "B", 47)
		};
}
}
 