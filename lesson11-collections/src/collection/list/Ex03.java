package collection.list;

import java.util.ArrayList;
import java.util.List;

import javax.lang.model.util.Elements;

public class Ex03 {
	public static void main(String[] args) {
		// String[] elements = new String[0];
		// elements.get(0) = elements[0];
		
		// Construct an empty list with an initial capacity of ten
		// this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA
		// DEFAULT_CAPACITY = 10;
		List<String> elements = new ArrayList<>(8);
		
		// modCount++;
		// add(e, elementData, size
		// return true;
		
		
		elements.add("Water");
		elements.add("Bottle");
		elements.add(0, "Paper");
		
		elements.set(1, "Can");
		
		// remove index
		elements.remove(0);
		
		// remove value
		elements.remove("Can");
		
		// loop
		for (int i=0; i<elements.size(); i++) {
			System.out.println("elements " + i + ": " + elements.get(i));
		}

		// code: size
		System.out.println("size: " + elements.size());
		System.out.println("isEmpty: " + elements.isEmpty());
	}
	
}
