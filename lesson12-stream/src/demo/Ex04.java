package demo;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import bean.Apple;
import utils.AppleUtils;
import utils.CollectionUtils;

public class Ex04 {
	public static void main(String[] args) {
		List<Apple> inventory = AppleUtils.getAll();
		// instance -> Class.A[ClassB].method(instance)
		// ClassA.[ClassB]::method
		
		inventory.forEach(System.out::println);
		
		// Example 02
		// (ClassA instance) -> instance.ClassA#method
		// ClassA::method
		// s -> s.length
		// String::length
		System.out.println("======================");
		List<String> texts = Arrays.asList("sdfs", "shitqoi", "sdfjalksskdjf", "sdf");
		Set<Integer> lengths = CollectionUtils.map(texts, String::length);
		CollectionUtils.printf(lengths);
		
	}
}
