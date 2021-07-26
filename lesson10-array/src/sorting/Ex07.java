package sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;

import static java.util.Comparator.*;
import bean.Item;
import utils.ArrayUtils;

public class Ex07 {
	public static void main(String[] args) {
		Item[] items = getItems();
		
		// lambda expression
		// Function<T, R> >> t -> t.X();
		// t: instance of T
		// X: T's method return R
		
		Item itemX = new Item(111, "AAA", 333);
		
		//lambda expression
		//Fuction< T, R> >> t -> t.X();
		//t: instance of T
		//X: T's method return R
		Function<Item, String> f1 = (Item item) -> item.getName();
		System.out.println("f1: " + f1.apply(itemX));
		
		// method reference tham chieu phuong thuc
		Function<Item, Integer> f2 = Item::getItemId;
		System.out.println("f2: " + f2.apply(itemX));
		
		 Arrays.sort(items, comparing(i -> i.getName()));
		 
		// Comparator<Item> precom = Comparator.comparing(Item::getName, String.CASE_INSENSITIVE_ORDER);
		 Comparator<Item> precom = new Comparator<Item>() {

			@Override
			public int compare(Item o1, Item o2) {
				return o1.getName().compareToIgnoreCase(o2.getName());
			}
		};
		 Arrays.sort(items, precom);
		 Arrays.sort(items, precom.thenComparing(Item::getPrice));
		 ArrayUtils.printf(items);
		 
//		Arrays.sort(items, comparing(Item::getName));
//		ArrayUtils.printf(items);
		
		System.out.println("======================");
		
		Function<Item, Integer> f3 = Item::getstoreId;
		System.out.println("f3: " + f3.apply(itemX));
		
		Comparator<Item> comparator = comparing(Item::getstoreId, reverseOrder());
		Arrays.sort(items, comparator.thenComparing(Item::getItemId).reversed());
		Arrays.sort(items, comparator.thenComparing(Item::getName).reversed());
		ArrayUtils.printf(items);
		
		// . ; :: ... -> () {} []
	}
	
	private static Item[] getItems() {
		return new Item[] {
			new Item(1, 12, "a", 278.2d),
			new Item(2, 27, "B", 12.2d),
			new Item(3, 12, "c", 228),
			new Item(2, 29, "D", 259),
			new Item(1, 18, "f", 278),
			new Item(1, 10, "F", 159),
			new Item(2, 15, "b", 47),	
			new Item(4, 19, "A", 48),
			new Item(3, 1, "a", 49),
		};
	}
}