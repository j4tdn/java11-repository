package demo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

import bean.Apple;
import utils.AppleUtils;
import utils.CollectionUtils;

public class Ex04 {
	public static void main(String[] args) {
		List<Apple> inventory = AppleUtils.getAll();
		List<Apple> inventory1 = AppleUtils.getAll();

		// Instance -> ClassA.[ClassB].method(instance)
		// ClassA.[ClassB]::method
		Consumer<Apple> c1 = a -> System.out.println(a.getId());
		Consumer<Apple> c2 = System.out::println;
		inventory.forEach(System.out::println);

		// Example 02
		// (ClassA instance) -> instance.ClassA#method
		// ClassA::method

		// (String s) -> s.length()
		// String::length
		List<String> texts = Arrays.asList("abc", "abcde", "bcd", "fbdxza");
		Set<Integer> lengths = map(texts, String::length);
		CollectionUtils.printf(lengths);

	}

	private static <T, R> Set<R> map(List<T> ts, Function<T, R> func) {
		Set<R> result = new HashSet<>();
		for (T t : ts) {
			result.add(func.apply(t));
		}
		return result;
	}
}
