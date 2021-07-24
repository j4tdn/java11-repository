package collection.list;

import java.util.ArrayList;
import java.util.List;


public class Ex03 {
	public static void main(String[] args) {
		List<String> elements = new ArrayList<>(8);
		
		elements.add("water");
		elements.add("bottle");
		elements.add(0, "paper");
		
		elements.set(1, "can");
		//remove index
		elements.remove(0);
		
		//remove value
		elements.remove("can");
		
		for (int i = 0; i < elements.size(); i++) {
			System.out.println(elements.get(i));
		}
		
		System.out.println(elements.size());
	}
}
