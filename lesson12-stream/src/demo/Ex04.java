package demo;

import java.util.Arrays;
import java.util.Collections;
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
		
		System.out.println("====== Map Colors ======");
		Set<String> colors = CollectionUtils.map(inventory, Apple::getColor);
		CollectionUtils.printf(colors);
		
		// Example 03
		// s -> Integer.parseInt(s); >> Integer::parseInt
		Function<String, Integer> f1 = Integer::parseInt;
		
		// List<Apple> la1 // abcd
		// List<Apple> la2 // acbb
		// la1 == la2
		
		Function<Apple, Integer> func = Apple::getId;
		
		compare(Collections.emptyList(), Collections.emptyList(), Apple::getId);
		
	}
	
	private static <R> boolean compare(List<Apple> la1, List<Apple> la2, Function<Apple, R> func) {
		if (la1.size() != la2.size()) {
			return false;
		}
		int length = la1.size();
		for (int i = 0 ; i < length; i++) {
			if (!func.apply(la1.get(i)).equals(func.apply(la2.get(i)))) {
				return false;
			}
		}
		return true;
	}
}
