package collection.list;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Ex05 {
	public static void main(String[] args) {
		List<String> elements = Arrays.asList("a", "b", "c", "d", "e");

		System.out.println(elements.get(new Random().nextInt(elements.size())));

		Collections.reverse(elements);
		Collections.shuffle(elements);

		System.out.println("isExits: " + elements.contains("b"));
		utils.CollectionUtils.printf(elements);
	}
}
