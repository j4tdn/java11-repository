package collection.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import bean.Item;

public class Ex07 {
	public static void main(String[] args) {

		List<Item> items = getItems();
		
		Item itemA = new Item(1, 2, "A12", 12);
		Item itemB = new Item(1, 10, "A10", 100);
		Item itemC = items.get(2);
		
		//Implementation note: List<E> elements
		//Need: call remove or contains
		//Required: E override equals methods
		//Without override: using default Object's equals to comparing address in heap
		
		System.out.println("item exist: " + items.contains(itemA));//F after overide equals -> F
		System.out.println("item exist: " + items.contains(itemB));//F after overide equals -> T
		System.out.println("item exist: " + items.contains(itemC));//T after overide equals -> T
		
		items.remove(itemB);
		System.out.println("size: " + items.size());
	}
	
	private static List<Item> getItems(){
		//List<Item> items = new ArrayList<>();
		List<Item> items = new LinkedList<>();
		
		Item item1 = new Item(1, 10, "a10", 100);
		Item item2 = new Item(2, 20, "a20", 200);
		Item item3 = new Item(3, 30, "a30", 300);
		Item item4 = new Item(4, 12, "a12", 120);
		
		items.add(item1);
		items.add(item2);
		items.add(item3);
		items.add(item4);
		
		return items;
		
	}
}
