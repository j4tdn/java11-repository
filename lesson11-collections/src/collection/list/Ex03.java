package collection.list;

import java.util.ArrayList;
import java.util.List;
public class Ex03 {
	public static void main(String[] args) {
		List<String> elements = new ArrayList<>(8); 
		
		elements.add("Water");
		elements.add("Bottle");
		elements.add(0, "Paper");
		
		elements.set(1, "Can");
		
		elements.remove(0);
		elements.remove("Can");
		for(int i = 0; i < elements.size(); i++) {
			System.out.println("element " + i + ": " + elements.get(i));
		}
		
		
		// code: size
		System.out.println("size: " + elements.size());
		System.out.println("isEmpty: " + elements.isEmpty());
	}
}
