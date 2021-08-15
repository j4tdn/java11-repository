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

		List<Apple> redApples = filterApples(inventory, (a) -> "red".equals(a.getColor()));

		List<Apple> heavyApples = filterApples(inventory, (a) -> a.getWeight() > 200);

		System.out.println("==== Green Apples ====");
		CollectionUtils.printf(greenApples);

		System.out.println("==== Red Apples ====");
		CollectionUtils.printf(redApples);

		System.out.println("==== Heavy Apples ====");
		CollectionUtils.printf(heavyApples);

		// Lambda expressions
		// Get list of origin countries of apples
		Set<String> countries = map(inventory, Apple::getColor);
		CollectionUtils.printf(countries);

		List<String> texts = Arrays.asList("abc", "abcde", "bcd", "fbdxza");
		Set<Integer> lengths = map(texts, s -> s.length());
		CollectionUtils.printf(lengths);
	}

	private static <T, R> Set<R> map(List<T> ts, Function<T, R> func) {
		Set<R> result = new HashSet<>();
		for (T t : ts) {
			result.add(func.apply(t));
		}
		return result;
	}

	private static List<Apple> filterApples(List<Apple> inventory, Strategy strategy) {
		List<Apple> result = new ArrayList<Apple>();
		for (Apple apple : inventory) {
			if (strategy.behavior(apple)) {
				result.add(apple);
			}
		}
		return result;
	}
}