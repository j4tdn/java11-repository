package demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import bean.Apple;
import bean.Strategy;
import utils.AppleUtils;
import utils.CollectionUtils;

public class Ex02 {
	public static void main(String[] args) {
		List<Apple> inventory = AppleUtils.getAll();

		List<Apple> greenApples = filterApples(inventory, a -> "green".equals(a.getColor()));

		List<Apple> redApples = filterApples(inventory, a -> "red".equals(a.getColor()));

		List<Apple> heavyApples = filterApples(inventory, a -> a.getWeight() > 200);

		System.out.println("===== Green Apples =====");
		CollectionUtils.printf(greenApples);

		System.out.println("===== Red Apples =====");
		CollectionUtils.printf(redApples);

		System.out.println("===== Heavy Apples =====");
		CollectionUtils.printf(heavyApples);

		// Lambda expressions
		// Get list of origin countries of apples
		System.out.println("===== Map Colors =====");
		Set<String> colors = map(inventory, a -> a.getColor());
		CollectionUtils.printf(colors);
		
		System.out.println("===== Map Lenghts =====");
		List<String> texts = Arrays.asList("abc", "abcde", "ab", "abcdefgh");
		Set<Integer> lengths = map(texts, s -> s.length());
		CollectionUtils.printf(lengths);

	}

	private static <T, R> Set<R> map(List<T> ts, Function<T, R> function){
		Set<R> result = new HashSet<>();
		
		// behavior(T = Apple): R 
		for(T t: ts) {
			result.add(function.apply(t));
			}
		
		return result;
	}

	private static List<Apple> filterApples(List<Apple> inventory, Strategy<Apple> strategy) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (strategy.behavior(apple)) {
				result.add(apple);
			}
		}
		return result;
	}
}
