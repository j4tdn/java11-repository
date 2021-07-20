package sorting;

import java.util.Arrays;
import java.util.Comparator;
import static java.util.Comparator.*;
import java.util.function.Function;

import bean.Item;
import untils.ArrayUtils;

public class Ex071 {
	public static void main(String[] args) {
		Item[] items = getItems();
		// lambda expression
		// Function<T, R> >> t -> t.X();
		// t: instance of T
		// X: T'smethod return R

		Item itemX = new Item(111, "AAA", 333);
		Function<Item, String> f1 = item -> item.getName();
		System.out.println("f1 : " + f1.apply(itemX));
		// method reference
		Function<Item, Integer> f2 = Item::getItemId;
		System.out.println("f2 : " + f2.apply(itemX));

		// Arrays.sort(items, comparing(Item::getItemId, reverseOrder()).reversed());
		Comparator<Item> comparator = comparing(Item::getName);
		comparator.thenComparing(Item::getPrice);
		Arrays.sort(items, comparator);
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
