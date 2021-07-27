package collection.list;

import java.util.ArrayList;
import java.util.List;


import bean.Item;

public class Ex07 {
	
	public static void main(String[] args) {
		List<Item> items = getItems();
		Item iA = new Item(1,2,"A12",12);
		Item iB = new Item(1,10,"A10",100);
		Item iC = items.get(2);
		
		// im plementation note: List<E> elements 
		// need call: remove, contains
		//require: E override equals methods
		//without: using default Object's equals to compare address in heap memory
		
		System.out.println("itemA exist :" + items.contains(iA));
		System.out.println("itemA exist :" + items.contains(iB));
		System.out.println("itemA exist :" + items.contains(iC));
		
		items.remove(iB);
		System.out.println("size: " + items.size());
	}
	public static List<Item> getItems() {
		List<Item> items = new ArrayList<>();
		
		Item i1  = new Item(1,10,"A10",100);
		Item i2  = new Item(2,20,"A20",200);
		Item i3  = new Item(3,30,"A30",300);
		Item i4  = new Item(1,12,"A12",120);
		
		items.add(i1);
		items.add(i2);
		items.add(i3);
		items.add(i4);
		
		return items;
	}

}
