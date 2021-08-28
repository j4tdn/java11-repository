package demo;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import utils.ArrayUtils;
import utils.CollectionUtils;

public class Ex10 {
	public static void main(String[] args) {
		List<String> s1 = Arrays.asList("a", "b", "c");
		List<String> s2 = Arrays.asList("I", "II", "III");
		List<String> s3 = Arrays.asList(".", "$", "&");

		List<List<String>> s = Arrays.asList(s1, s2, s3);

		// list -> list.stream() = Collection::stream
		List<String> apbData = s.stream().flatMap(Collection::stream).filter(item -> item.matches("[a-z]+"))
				.collect(Collectors.toList());
		CollectionUtils.printf(apbData);

		System.out.println("----------------------");
		int[][] a = { { 1, 4, 6 }, { 2, 5, 7 }, { 17, 21, 32 } };
		int[] data = Arrays.stream(a) // Stream<int[]>
			.flatMapToInt(Arrays::stream) //array -> Arrays.stream(array) = Arrays::stream
			.filter(item -> item % 2 == 0)
			.toArray();
		ArrayUtils.printf(data);
	}
}
