package collection.list;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import utils.CollectionUtils;

public class Ex05 {
	public static void main(String[] args) {
		// fixed- size
		List<String> elements = Arrays.asList("a", "b", "c", "d");
		
		System.out.println("contains: " + elements.contains("c"));
		Collections.reverse(elements);
		Collections.shuffle(elements);
		
		CollectionUtils.printf(elements);
	}
}
