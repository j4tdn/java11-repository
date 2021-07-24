package collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class Ex04 {
	public static void main(String[] args) {
		List<String> elements = new ArrayList<>();
		elements.add("Item - 5");
		elements.add("Item - 1");
		elements.add("Item - 2");
		elements.add("Item - 0");
		
		elements.removeIf(item -> Integer.parseInt("" + item.charAt(item.length()-1)) <= 1);
		
		System.out.println("Contains: " + elements.contains("Item - 5"));
		
		System.out.println("=================");
		for (String element: elements) {
			System.out.println(element);
		}
		
		/*Iterator<String> iterator = elements.iterator();
		while(iterator.hasNext()) {
			String item = iterator.next();
			int remainingDays = Integer.parseInt("" + item.charAt(item.length()-1));
			
			if (remainingDays <= 3) {
				System.out.println("remove element: " + item);
				iterator.remove();
			}
		}*/
	
		
//		for(int i = 0; i < elements.size(); i++) {
//			String item = elements.get(i);
//			int remainingDays = Integer.parseInt("" + item.charAt(item.length()-1));
//			
//			if (remainingDays <= 3) {
//				System.out.println("remove element: " + item);
//				elements.remove(item);
//				i--;
//			}
//		}
		
		
	}
}
