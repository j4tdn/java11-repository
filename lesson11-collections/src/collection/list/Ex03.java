package collection.list;

import java.util.ArrayList;
import java.util.List;

public class Ex03 {
	public static void main(String[] args) {
		List<String> elements = new ArrayList<>();
		
		elements.add("water");
		
		elements.add(0, "Paper");
		
		//elements.set(0, "Can");
		
		elements.remove(0);
		
		for(int i=0; i<elements.size(); i++) {
			System.out.println("element " + i + ": " + elements.get(i) );
		}
		
		System.out.println(elements.get(0));
		System.out.println(elements.get(1));
		
		
	}

}
