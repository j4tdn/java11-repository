package collection.list;

import java.util.ArrayList;
import java.util.List;

import bean.Item;

public class Ex07 {
	public static void main(String[] args) {
		Item itemA = new Item(1,2,"A12",12);
		Item itemB = new Item(1,10,"A10",100);
		// Implementation note: List<E> elements
		//need call: remove, contains
		//require: E override equals methods
		//without: using default Object's equals to comparing address in heap memory
		List<Item> items = getItems();
		items.remove(itemB);
	}
	
	private static List<Item> getItems() {
		List<Item> items = new ArrayList<>();
		Item item1 = new Item(1,10,"A10",100); 
		Item item2 = new Item(1,20,"A20",200); 
		Item item3 = new Item(1,30,"A30",300); 
		Item item4 = new Item(1,12,"A40",130); 
		
		items.add(item1);
		items.add(item2);
		items.add(item3);
		items.add(item4);
		return items;
	}
}
