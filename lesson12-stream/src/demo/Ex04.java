package demo;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

import bean.Apple;
import utils.AppleUtils;
import utils.CollectionUtils;

public class Ex04 {
	public static void main(String[] args) {
		// Example 01
		List<Apple> inventory = AppleUtils.getAll();
		// instance -> ClassA.[ClassB].method(instance)
		// ClassA.[ClassB]::method

		Consumer<Apple> c1 = a -> System.out.println(a);
		Consumer<Apple> c2 = System.out::println;
		inventory.forEach(System.out::println);

		// Example 02
		// (ClassA instance) -> instance.ClassA#method
		// ClassA::method
		System.out.println("======= Map Apples ========");

		List<String> texts = Arrays.asList("a", "abc", "acdkdj", "asjdkfjskdf");
		Set<Integer> lengths = CollectionUtils.map(texts, String::length);
		CollectionUtils.printf(lengths);

		Set<String> countries = CollectionUtils.map(inventory, Apple::getColor);
		CollectionUtils.printf(countries);
	}
}
