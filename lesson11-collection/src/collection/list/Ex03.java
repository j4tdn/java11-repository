package collection.list;

import java.util.ArrayList;
import java.util.List;

public class Ex03 {
	public static void main(String[] args) {
		// String[] elements = new String[0];
		// elements.get(0) = elements[0];
		
		List<String> elements = new ArrayList<>();
		
		elements.add("mot");
		elements.add("hai");
		elements.add(0, "ba");
		
		elements.set(1, "bon");
		
		// remove index
		elements.remove(2);
		// remove value
		elements.remove("bon");
		
		//loop
		for (int i = 0; i < elements.size(); i++) {
			System.out.println("element "  + i + ": " + elements.get(i));
		}
		
		System.out.println("size: " + elements.size());
		System.out.println("isEmpty: " + elements.isEmpty());
		
	}
}
