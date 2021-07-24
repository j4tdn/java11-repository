package collection.list;

import java.util.ArrayList;
import java.util.List;

public class Ex03 {
	public static void main(String[] args) {
		/**
		 * Constructs an empty list with an initial capacity of ten.
		 */
//		this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;/
		List<String> elements = new ArrayList<>();

		// capacity
		elements.add("Water");
		elements.add("Bottle");
		elements.add(0, "Paper");

		elements.set(1, "Can");

		// remove index
		elements.remove(0);

		// remove value
		elements.remove("Can");

		// loop
		System.out.println(elements.toString());
		System.out.println("size: " + elements.size());
		System.out.println("isEmpty: " + elements.isEmpty());

	}
}
