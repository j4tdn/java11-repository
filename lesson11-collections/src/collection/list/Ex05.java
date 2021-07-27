package collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import utils.CollectionUtils;

public class Ex05 {
	public static void main(String[] args) {
		//fixed size
		List<String> elements = Arrays.asList("a","b","c","d","e");
		boolean isExist = elements.contains("b");
		
		System.out.println(elements.get(new Random().nextInt(elements.size())));
		Collections.reverse(elements);
		Collections.shuffle(elements);
		
		CollectionUtils.printf(elements);
		
	}
}
