package collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import utils.collectionUtils;

public class Ex05 {
	public static void main(String[] args) {
		List<String> elements = Arrays.asList("a","b","c","d","e");
		System.out.println("random: " + elements.get(new Random().nextInt(elements.size())));
		
		boolean isExist = elements.contains("b");
		Collections.reverse(elements);
		Collections.shuffle(elements);
		
		
		System.out.println("isExist: " + isExist);
		collectionUtils.printf(elements);
	}

}
