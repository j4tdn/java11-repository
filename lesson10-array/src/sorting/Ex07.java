package sorting;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import static java.util.Comparator.*;
import java.util.function.Function;

import bean.Item;
import utils.ArrayUtils;

public class Ex07 {
	public static void main(String[] args) {
		Item[] items = getItems();
		// ... variables
		// sort by price
		// sort by storedID

		// Using lambda for sort by property
		Comparator<Item> comp1 = (i1, i2) -> i1.getItemId() - i2.getItemId();
		Comparator<Item> comp2 = (i1, i2) -> Double.compare(i1.getPrice(), i2.getPrice());

		// Using Comparator for sort by property
		Arrays.sort(items, new Comparator<Item>() {
			@Override
			public int compare(Item o1, Item o2) {
				return Double.compare(o1.getPrice(), o2.getPrice());
			}
		});

		Arrays.sort(items, new Comparator<Item>() {
			@Override
			public int compare(Item o1, Item o2) {
				return Double.compare(o1.getPrice(), o2.getPrice());
			}

		});

		// Using comparator
		Comparator<Item> c3 = Comparator.comparing(new Function<Item, Integer>() {
			@Override
			public Integer apply(Item i) {
				return i.getItemId();
			}
		});
		Comparator<Item> c31 = Comparator.comparing(i -> i.getItemId());
		c31.thenComparing(i -> i.getStoreId()).reversed(); // reversed(): reversed toan bo thu tu o tren
		c31.thenComparing(i -> i.getStoreId()); // Tang dan
		c31.thenComparing(i -> i.getStoreId(), Comparator.reverseOrder()); // Giam dan vi reverseOrder()

		// Function<T, R> >> R apply(T t)
		// Function<T, R> >> t -> t.X()
		// t: instance of T
		// X: T's method return R
		// comparing
		// (c1, c2) -> keyExtractor.apply(c1).compareTo(keyExtractor.apply(c2));
		
		Function<Item, String> f1 = item -> item.getName();
		Function<Item, String> f2 = Item::getName;
		Function<Item, Integer> f3 = Item::getItemId;
		
		Item itemX = new Item(111, "AAA", 333);
		Function<Item, String> f4 = Item::getName;
		System.out.println("f4: " + f4.apply(itemX));
		ArrayUtils.printf(items);
		
		// Using comparator with lambda
		Arrays.sort(items, c31);
		Arrays.sort(items, Comparator.comparing(i -> i.getItemId()));
		Arrays.sort(items, comparing(Item::getName));
		Arrays.sort(items, comparing(Item::getName, reverseOrder()));
		ArrayUtils.printf(items);
	}

	private static Item[] getItems() {
		return new Item[] { new Item(1, 12, "a", 278), new Item(2, 27, "B", 12), new Item(3, 12, "c", 278),
				new Item(2, 29, "D", 259), new Item(1, 18, "f", 278), new Item(1, 10, "K", 159),
				new Item(4, 12, "B", 47), };
	}
}
