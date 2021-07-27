package collection.list;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import utils.CollectionUtils;

public class Ex05 {
	public static void main(String[] args) {

		// fixed-size
		List<String> elements = Arrays.asList("a", "b", "c", "d", "e");
		System.out.println("randome: " + elements.get(new Random().nextInt(elements.size())));
		
		boolean isExist = elements.contains("b");
		Collections.reverse(elements);
		Collections.shuffle(elements);
		
		System.out.println("isExist: " + isExist);
		CollectionUtils.printf(elements);
	}
}
