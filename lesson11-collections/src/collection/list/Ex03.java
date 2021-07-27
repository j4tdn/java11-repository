package collection.list;

import java.util.ArrayList;
import java.util.List;

public class Ex03 {
	public static void main(String[] args) {
		//String[] elements = new String[0];
		//elements.get(0) = elements[0];
		
		//Constructs an empty list with an initial capacity of ten.
		//this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
		//DEFAULT_CAPACITY = 10;
		List<String> elements = new ArrayList<>(8);
		
		//capacity
		elements.add("Water");
		elements.add("Botlle");
		elements.add(0, "Paper");
		
		elements.set(1, "Can"); //edit
		
		//remove index
		elements.remove(0);
		
		//remove value
		elements.remove("Can");
		//loop
		for (int i = 0; i < elements.size(); i++) {
			System.out.println("element " + i + ": " + elements.get(i));
		}
		
//		//System.out.println("element 0: " + elements.get(0));
//		System.out.println("element 1: " + elements.get(1));
//		System.out.println("element 2: " + elements.get(2));
		
		//trong code: co bien size
		System.out.println("elements size: " + elements.isEmpty());
		System.out.println("elements size: " + elements.size());
		
		
	}
}
