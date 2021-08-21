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
		
		// anonymous class
		List<Apple> greenApples = filterApples(inventory, new Strategy<Apple>() {
			@Override
			public boolean behavior(Apple apple) {
				return "red".equals(apple.getColor());
			}
			
		});
		
		// Short code with lambda
		// Expression: Type Reference
		List<Apple> greenApplesLambda = filterApples(inventory, a -> "green".equals(a.getColor()));
		List<Apple> redApples = filterApples(inventory, a -> "red".equals(a.getColor()));
		List<Apple> heavyApples = filterApples(inventory, a -> a.getWeight() > 200);
		
		System.out.println("====== Green Apples ======");
		CollectionUtils.printf(greenApples);

		System.out.println("====== Red Apples ======");
		CollectionUtils.printf(redApples);
		
		System.out.println("====== Heavy Apples ======");
		CollectionUtils.printf(heavyApples);
		
		System.out.println("====== Map Apples ======");
		
		// Lambda expressions 
		// Get list of origin countries of apples
		Set<String> colors = map(inventory, a -> a.getColor());
		CollectionUtils.printf(colors);
		
		System.out.println("====== Map Length ======");
		List<String> texts = Arrays.asList("abc", "abcde", "ab", "abcdef");
		Set<Integer> lengths = map(texts, new Function<String, Integer>() {
			@Override
			public Integer apply(String s) {
				return s.length();
			}
		});
		// Set<Integer> lengths = map(texts, s -> s.length());
		CollectionUtils.printf(lengths);
		
		// Lambda expressions 
		// Lambda expression is an instance of functional interface
		// Functional Interface Name finame = lambda expression
		Predicate<Apple> p = (Apple a) -> a.getWeight() > 0;
		Function<Apple, Double> f = (Apple a) -> a.getWeight();
	}
	
	private static <T, R> Set<R> map(List<T> ts, Function<T, R> function) {
		Set<R> result = new HashSet<>();
		// behavior(Apple): R
		for (T t: ts) {
			// apple -> country, weight, id >> apple.getCountry()
			result.add(function.apply(t));
		}
		return result;
	}
	
	/**
	 * Get apples with the given condition
	 * @param inventory input data
	 * @param behavior given condition
	 * @return output data
	 */
	private static List<Apple> filterApples(List<Apple> inventory, Strategy<Apple> strategy) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple: inventory) {
			if (strategy.behavior(apple)) {
				result.add(apple);
			}
		}
		return result;
	}
}