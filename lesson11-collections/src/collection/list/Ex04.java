package collection.list;

import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class Ex04 {
	public static <T> void main(String[] args) {
		List<String> elements = new ArrayList<String>();
		elements.add("Item - 5");
		elements.add("Item - 1");
		elements.add("Item - 2");
		elements.add("Item - 0");
		
		elements.removeIf(item -> Integer.parseInt("" + item.charAt(item.length() - 1)) <= 3);
//		System.out.println("contains: " + elements.contains("Item - 5"));
		/*	Predicate<String> pre = new Predicate<String>() {
				@Override
				public boolean test(String item) {
					return Integer.parseInt("" + item.charAt(item.length() - 1)) <= 3;
				}
			};*/
		
		System.out.println("contains: " + elements.contains("Item - 5"));
	

		System.out.println("=============================");
		for (String element : elements) {
			System.out.println(element);

		}

		/*
		 * Iterator<String> iterator = elements.iterator(); while(iterator.hasNext())
		 * {// check next element ? String item = iterator.next(); int remainingdays =
		 * Integer.parseInt("" + item.charAt(item.length() - 1));
		 * 
		 * if (remainingdays <= 3) { System.out.println("removed element: " + item);
		 * elements.remove(item); i--; } }
		 */

		/*
		 * for (int i = 0; i < elements.size(); i++) { String item = elements.get(i);
		 * int remainingdays = Integer.parseInt("" + item.charAt(item.length() - 1)); if
		 * (remainingdays <= 3) { System.out.println("removed element: " + item);
		 * elements.remove(item); i--; } }
		 */

	}
}
