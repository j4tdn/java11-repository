package collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class Ex04 {
	public static void main(String[] args) {
		List<String> elements = new ArrayList<>();
		elements.add("Item -5");
		elements.add("Item -2");
		elements.add("Item -3");
		elements.add("Item -4");
		Predicate<String> pre = new Predicate<String>() {

			@Override
			public boolean test(String item) {
				int remainingdays = Integer.parseInt("" + item.charAt(item.length() - 1));
				if (remainingdays <= 3) {
					return true;
				} else
					return false;
			}
		};
		elements.removeIf(pre);
		System.out.println("=======================");
		for (String element : elements) {
			System.out.println(element);
		}
//		Iterator<String> iterator = elements.iterator();
//		while(iterator.hasNext())
//		{
//			String item=iterator.next();
//			int remainingdays = Integer.parseInt("" + item.charAt(item.length() - 1)); if
//			  (remainingdays <= 3) { System.out.println("removed element: " + item);
//			  elements.remove(item); iterator.remove(); 
//		}
		/*
		 * for (int i = 0; i < elements.size(); i++) { String item = elements.get(i);
		 * int remainingdays = Integer.parseInt("" + item.charAt(item.length() - 1)); if
		 * (remainingdays <= 3) { System.out.println("removed element: " + item);
		 * elements.remove(item); i--; } }
		 */
		System.out.println("=======================");
		for (String element : elements) {
			System.out.println(element);
		}
	}
}
