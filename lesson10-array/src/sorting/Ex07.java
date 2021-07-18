package sorting;

import java.util.Arrays;
import java.util.Comparator;

import bean.Item;
import utils.ArrayUtils;

public class Ex07 {
	public static void main(String[] args) {
		Item[] items = getItems();

		Comparator<Item> comp1 = (Item o1, Item o2) -> o1.getItemId() - o2.getItemId();
		
		
		Comparator<Item> comp2 = Comparator.comparing(i -> -i.getItemId());
		
		
		Arrays.sort(items, comp2);
		ArrayUtils.printf(items);
		
		System.out.println("======================");
		
		Arrays.sort(items, Comparator.comparing(i -> i.getName()));
		ArrayUtils.printf(items);
		
		System.out.println("======================");
		
		
		Comparator<Item> comparator = Comparator.comparing(i -> i.getStoreId());
		Arrays.sort(items, comparator.thenComparing(i -> i.getItemId(), Comparator.reverseOrder()));
		ArrayUtils.printf(items);
		
		ArrayUtils.printf(items);


	}

	private static Item[] getItems() {
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
