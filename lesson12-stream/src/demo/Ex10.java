package demo;

import java.awt.event.ItemEvent;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import utils.ArrayUtils;
import utils.CollectionUtils;

public class Ex10 {
	public static void main(String[] args) {
		List<String> s1 = Arrays.asList("a", "b", "c");
		List<String> s2 = Arrays.asList("I", "II", "III");
		List<String> s3 = Arrays.asList(".", "*", "^");

		List<List<String>> s = Arrays.asList(s1, s2, s3);

		// list -> list.stream() = Collection::stream
		List<String> apbData = s.stream() // Stream<List<String>>
				.flatMap(list -> list.stream()) // Stream<String>
				.filter(item -> item.matches("[a-z]+")).collect(Collectors.toList()); // List<String>

		CollectionUtils.printf(apbData);

		System.out.println("==========");

		int[][] a = { { 1, 3, 5 }, { 2, 4, 6 }, { 10, 20, 30 } };
		int[] data = Arrays.stream(a).flatMapToInt(array -> Arrays.stream(array)).filter(item -> item % 2 == 0)
				.toArray();
		ArrayUtils.printf(data);

	}
}
