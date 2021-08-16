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
		// instance -> ClassA.[ClassB].method(instance)
		// ClassA.[ClassB]::method
		
		inventory.forEach(System.out::println);
		
		// Example 02
		// (ClassA instance) -> instance.ClassA#method
		
		// (String s) -> s.length()
		// String::length
		
		System.out.println("======= Map Lenght ============");
		List<String> text = Arrays.asList("ab", "abc", "abcd", "abcde");
		Set<Integer> lenght = CollectionUtils.map(text, String::length);
		CollectionUtils.printf(lenght);
		
		Set<String> country = CollectionUtils.map(inventory, Apple::getColor);
		CollectionUtils.printf(country);
	}
}
