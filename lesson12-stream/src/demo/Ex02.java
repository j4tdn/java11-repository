package demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

import bean.Apple;
import bean.Strategy;
import utils.AppleUtils;
import utils.CollectionUtils;

public class Ex02 {
	public static void main(String[] args) {
		List<Apple> inventory = AppleUtils.getAll();
		
		
		List<Apple> greenApples = filterApples(inventory, apple -> "green".equals(apple.getColor()));
		
		List<Apple> redApples = filterApples(inventory, apple -> "red".equals(apple.getColor()));
		
//		Strategy<Apple> strategy = new Strategy<Apple>() {
//
//			@Override
//			public boolean behavior(Apple a) {
//				return a.getWeight() > 300;
//			}
//		};
		
		// anonymous class
		List<Apple> heavyApples = filterApples(inventory, apple -> apple.getWeight() > 300);
		
		System.out.println("===== Green Apples =====");
		CollectionUtils.printf(greenApples);
		
		System.out.println("===== Red Apples =====");
		CollectionUtils.printf(redApples);
		
		System.out.println("===== Heavy Apples =====");
		CollectionUtils.printf(heavyApples);
		
		// Lambda expression
		// Function<Apple, Double> p = (Apple a) -> a.getWeight();
		// Get list of origin countries of apples
		System.out.println("===== Map Color =====");
		Set<String> colors = map(inventory, new Function<Apple, String>() {
			@Override
			public String apply(Apple a) {
				return a.getColor();
			}
		});
		//CollectionUtils.printf(colors);
		
		System.out.println("===== Map Lenght =====");
		List<String> texts = Arrays.asList("abc", "abcde", "ab", "abcdefgh");
		Set<Integer> lengths = map(texts, s -> s.length());
		// CollectionUtils.printf(lengths);
		
		
	}
	
	private static <T, R> Set<R> map(List<T> ts, Function<T, R> function) {
		Set<R> result = new HashSet<>();

		for (T t : ts) {
			result.add(function.apply(t));
		}
		return result;
	}
	

	/**
	 * Get apples with given condition
	 * 
	 * @param inventory input data
	 * @param behavior given condition
	 * @return output data
	 */
	// class >> abtract class
	// Lambda expression is a instance of Functional Interface
	// Functional Interface 
	private static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> strategy){
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (strategy.test(apple)) {
				result.add(apple);
			}
		}
		
		return result;
	}
}