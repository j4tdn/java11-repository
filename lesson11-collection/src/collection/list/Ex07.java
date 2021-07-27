package collection.list;

import java.util.LinkedList;
import java.util.List;

import bean.Item;

public class Ex07 {
	public static void main(String[] args) {
		List<Item> items = getItem();
		
		Item itemA = new Item(1, 2, "A12", 12);
		Item itemB = new Item(1, 10, "A10", 100);
		Item itemC = items.get(2);
		
		// Implementation note: List<E> elements
		// Need call: remove, contains
		// Require: E override equals method
		// Without: using default Object's equals to comparing address
		
		System.out.println("itemA exists > " + items.contains(itemA));
		System.out.println("itemB exists > " + items.contains(itemB));
		System.out.println("itemC exists > " + items.contains(itemC));
		
		items.remove(itemB);
		System.out.println("size: " + items.size());
		
	}
	
	private static List<Item> getItem(){
		List<Item> items = new LinkedList<>();
		
		Item i1 = new Item(1, 10, "A10", 100);
		Item i2 = new Item(2, 20, "A20", 200);
		Item i3 = new Item(3, 30, "A30", 300);
		Item i4 = new Item(1, 12, "A12", 120);
		
		items.add(i1);
		items.add(i2);
		items.add(i3);
		items.add(i4);
		
		return items;
	}
}
