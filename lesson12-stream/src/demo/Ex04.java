package demo;

import java.util.Arrays;
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
		// instance -> ClassA.[ClassB].method(instance)
		// ClassA.[ClassB]::method
		
		Consumer<Apple> c1 = a -> System.out.println(a);
		Consumer<Apple> c2 = System.out::println;
		
		inventory.forEach(System.out::println);
		
		// Example 02
		// (ClassA instance) -> instance.ClassA#method
		// ClassA::method
		
		// (String s) -> s.length()
		// String::length
		
		System.out.println("====== Map Length ======");
		List<String> texts = Arrays.asList("abc", "abcde", "ab", "abcdefgh");
		Set<Integer> lengths = CollectionUtils.map(texts, String::length);
		CollectionUtils.printf(lengths);
		
		System.out.println("====== Map Apples ======");
		Set<String> colors = CollectionUtils.map(inventory,  Apple::getColor);
		CollectionUtils.printf(colors);

		
		Function<String, Integer> f1 = Integer::parseInt;
	}
}
