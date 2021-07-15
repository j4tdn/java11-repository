package declaration;

import bean.Item;

public class Ex01 {
	public static void main(String[] args) {
		int[] i1 = new int[3];
		int[] i2 = {1, 5, 8};
		int[] i3 = new int[] {4, 7, 1};
		System.out.println("i1: " + i1.getClass().getSimpleName());
		
		System.out.println("i2[0]: " + i2[0]);
		
		String[] s1 = new String[2];
		String[] s2 = {"a", "b", "c"};
		String[] s3 = new String[] {"c", "d"};
		System.out.println("s1: " + s1.getClass().getSimpleName());

		// for-index
		for(int i = 0; i< s2.length; i++) {
			System.out.println("s[" + i + "]: " + s2[i]);
		}
		
		// for-each
		int index = 0;
		for(String s: s2) {
			System.out.println("s2[" + index + "]: " + s);
			index++;
		}
		Item item1 = new Item(1, "A", 20);
		Item item2 = new Item(2, "B", 23);
		Item item3 = new Item(3, "C", 22);
		System.out.println("item1: " + item1.getClass().getSimpleName());

		Item[] items = new Item[3];
		Item[] goods = {item1, item2};
		Item[] things = new Item[] {item1, item3};
 	}
	
	private static int[] initNbers() {
		return new int[] {1, 5, 8};
	}
}
