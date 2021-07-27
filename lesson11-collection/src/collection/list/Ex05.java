package collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import utils.CollectionUtils;

public class Ex05 {
	public static void main(String[] args) {
		// fix size
		List<String> elements = Arrays.asList("a", "b", "c", "d", "e");
		System.out.println(elements.contains(new String("b")));
		Collections.reverse(elements);
		Collections.shuffle(elements);
		CollectionUtils.printf(elements);
		
		
	}
}
