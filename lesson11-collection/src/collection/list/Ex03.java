package collection.list;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Ex03 {
	public static void main(String[] args) {
		List<String> elements = new ArrayList<>();
		
		elements.add("Water");
		elements.add("Bottle");
		elements.add(0,"Paper");
		
		elements.set(1, "Can");
		
		// remove index
		elements.remove(0);
		
		// remove Object
		elements.remove("Can");
		

		System.out.println("elements size : " + elements.size());
		System.out.println("isEmpty : " + elements.isEmpty());
		System.out.println("elements[0] : " + elements.get(0));
	//	System.out.println("elements[1] : " + elements.get(1));
		
		for(String str : elements) {
			System.out.print(str + " ");
		}
	}
}
