package collection.list;

import java.util.ArrayList;
import java.util.List;

public class Ex03 {
	public static void main(String[] args) {
		List<String> elements = new ArrayList<String>();

		elements.add("water");
		elements.add("Bottle");
		elements.add(0, "Paper");
		elements.set(1, "can");
		elements.remove(0);
		elements.remove("can");
		for (int i = 0; i < elements.size(); i++) {
			System.out.println("element " + i + ": " + elements.get(i));
		}
		System.out.println("size "+elements.size());
		System.out.println("isEmpty: "+elements.isEmpty());
	}
}
