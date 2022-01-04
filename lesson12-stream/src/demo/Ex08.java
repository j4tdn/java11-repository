package demo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import utils.ArrayUtils;
import utils.CollectionUtils;

public class Ex08 {
	public static void main(String[] args) {

		int[] digits = { 1, 2, 1, 3, 3, 2, 5, 7 };
		int[] oddNumbers = Arrays.stream(digits).filter(e -> e % 2 != 0).toArray();
		ArrayUtils.printf(oddNumbers);
		// exercise select unique elements from input list of numbers
		// select unique dish's calories from menu

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 1, 2, 4, 5, 7);
		Set<Integer> eventNumbers = numbers.stream().filter(e -> e % 2 == 0).collect(Collectors.toSet());
		CollectionUtils.printf(eventNumbers);
		System.out.println("runtime class: " + eventNumbers.getClass());

		// Ex01
		List<Integer> nums = Arrays.stream(digits).boxed().collect(Collectors.toList());
		List<Integer> result = nums.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet().stream()
				.filter(e -> e.getValue() == 1)
				.map(Entry::getKey).collect(Collectors.toList());
		System.out.println(result);
	}
}
