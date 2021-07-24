package collection.list;

import java.util.ArrayList;
import java.util.List;

public class Ex04 {
	public static void main(String[] args) {
		List<String> elements = new ArrayList<>();
		elements.add("Item - 5");
		elements.add("Item - 2");
		elements.add("Item - 3");
		elements.add("Item - 4");

		elements.removeIf(item -> Integer.parseInt("" + item.charAt(item.length() - 1)) <= 3);

		System.out.println(elements.contains("Item - 5"));

		/*
		 * Iterator<String> iterator = elements.iterator(); for (; iterator.hasNext();)
		 * { String item = iterator.next(); int remainingDays = Integer.parseInt("" +
		 * item.charAt(item.length() - 1));
		 * 
		 * if (remainingDays <= 3) { iterator.remove(); } }
		 */

		/*
		 * for (int i = 0; i < elements.size(); i++) { Integer remainingDays =
		 * Integer.parseInt("" + elements.get(i).charAt(elements.get(i).length() - 1)) ;
		 * 
		 * if(remainingDays <= 3) { elements.remove(elements.get(i));
		 * System.out.println("Removed element: " + remainingDays); i--; } }
		 */

		System.out.println(elements.toString());
	}
}
