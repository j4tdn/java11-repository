package sorting;


import bean.Item;
import utils.ArrayUtils;

public class Ex03 {
	public static void main(String[] args) {
		Item[] items = getItems();
		//bubble sort
		for (int i = 0; i < items.length; i++) {
			for (int j = 0; j < items.length-i-1; j++) {
//				if(items[j].getName().compareToIgnoreCase(items[j+1].getName()) > 0) {
//					swap(items, j, j+1);
//				}
//				if(items[j].getstoreId() > items[j+1].getstoreId()) {
//					swap(items, j, j+1);
//				continue;
//				}
//				
//				if (items[j].getstoreId() == items[j+1].getstoreId()) {
//					if (items[j].getItemId() < items[j+1].getItemId()) {
//						swap(items, j, j+1);
//					}
//					if(items[j].getName().compareToIgnoreCase(items[j+1].getName()) <0) {
//						swap(items, j, j+1);
//					}
//				}
				
				if(items[j].compareTo(items[j+1]) > 0) {
					swap(items, j, j+1);
				}
			}
		}
		ArrayUtils.printf(items);
	}
	
	private static Item[] getItems() {
		return new Item[] {
			new Item(1, 12, "anna", 278.4d),
			new Item(2, 27, "Better", 12),
			new Item(3, 12, "congo", 278),
			new Item(2, 29, "Dunk", 259),
			new Item(1, 18, "fell", 278.6d),
			new Item(1, 10, "Kate", 159),
			new Item(4, 12, "Bily", 47),
			new Item(4, 12 , "zicky", 100)
			
		};
	}
	private static void swap(Item[] items, int i , int j) {
		Item tmp =items[i];
		items[i] = items[j];
		items[j] = tmp;
	}
}
