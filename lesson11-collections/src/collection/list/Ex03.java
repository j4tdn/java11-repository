package collection.list;

import java.util.ArrayList;
import java.util.List;

public class Ex03 {
	public static void main(String[] args) {
		//String[] elements = new String[0]
		// elements.get(0) =  elements[0];
		//constructs an empty list with an initial capacity of ten
		//List<String> elements = new ArrayList<String>();
		
		
		//modCount++;
		// add(e,elementData, size);
		// return true;
		
		List<String> elements = new ArrayList<String>(8);
		
		//capacity=> han che tao mang moi sau moi lan them
		// them
		elements.add("water");
		elements.add("bottle");
		elements.add(0, "Paper");
		
		//fix
		elements.set(1, "can");
		
		//remove index
		elements.remove(0);
		
		//remove value
		elements.remove("can");
		
		//loop
		for(int i = 0; i<elements.size(); i++) {
			System.out.println("element: "+i+": "+ elements.get(i));
		}
		
		//check empty and size
		System.out.println("size: " + elements.size());
		System.out.println("isEmpty: " + elements.isEmpty());
	}

}
