package collection.list;

import java.util.ArrayList;
import java.util.List;

public class Ex03 {
	public static void main(String[] args) {
		// String[] elements = new String[];
		// elements.get(0) = elements[0];

		// Constructs an empty list with an initial capacity of ten
		// this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
		List<String> elements = new ArrayList<>(8);
		System.out.println("size: " + elements.size());
		// modCount++;
		// add(e, elementData, size)'
		// return true

		// capacity
		// add
		elements.add("Water");
		elements.add("Bottle");
		elements.add(0, "Paper");

		// update
		elements.set(1, "Can");

		// delete
		// remove index
		elements.remove(0);

		// remove value
		elements.remove("Can");

		// loop
		for (int i = 0; i < elements.size(); i++) {
			System.out.println("element " + i + ": " + elements.get(i));
		}

		System.out.println("size: " + elements.size());
		System.out.println("isEmpty: " + elements.isEmpty());

	}
}