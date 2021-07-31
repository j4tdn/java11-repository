package collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import utils.CollectionUtils;

public class Ex05 {
	public static void main(String[] args) {
		
		//fixed-size
		List<String> elements = Arrays.asList("a", "b", "c","d", "e");
		System.out.println("contains: " +elements.contains(new String("b")));
		
		boolean isExist = elements.contains("b");
		Collections.reverse(elements);
		
		Collections.shuffle(elements);
		
		CollectionUtils.printf(elements);
		
		

		
	}

}
