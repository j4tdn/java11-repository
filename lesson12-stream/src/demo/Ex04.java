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
		
		//Ex02
		System.out.println("=======Map lengths=========");
		List<String> texts = Arrays.asList("abc", "abcde", "ab","asdasdas");
		Set<Integer> lengths = CollectionUtils.map(texts,String::length);
		CollectionUtils.printf(lengths);
		
		System.out.println("=======Map lengths=========");
		Set<String> colors = CollectionUtils.map(inventory,Apple::getColor);
		CollectionUtils.printf(colors);
		
		
		//Ex03
		//s-> Integer.parseInt(s); >> Integer.parseInt
		Function<String, Integer> f1 = Integer::parseInt;
	}
}