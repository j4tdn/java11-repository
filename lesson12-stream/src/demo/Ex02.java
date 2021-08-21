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

		System.out.println("======= Green Apples ======");
		List<Apple> greenApples = filterApples(inventory, c -> "green".equals(c.getColor()));
		CollectionUtils.printf(greenApples);

		System.out.println("======== Red Apples =======");
		List<Apple> redApples = filterApples(inventory, c -> "red".equals(c.getColor()));
		CollectionUtils.printf(redApples);

		System.out.println("======== Heavy Apples =======");
		List<Apple> heavyApples = filterApples(inventory, c -> c.getWeight() > 200);
		CollectionUtils.printf(heavyApples);

		System.out.println("======== Light Apples =======");
		List<Apple> lightApples = filterApples(inventory, c -> c.getWeight() < 200);
		CollectionUtils.printf(lightApples);

		System.out.println("======== Weight and Color Apples =======");
		List<Apple> apples = filterApples(inventory, c -> "green".equals(c.getColor()) && c.getWeight() > 200);
		CollectionUtils.printf(apples);

		System.out.println("======== Weight and Country Apples =======");
		List<Apple> applesBy = filterApples(inventory, c -> "Vietnam".equals(c.getCountry()));
		CollectionUtils.printf(applesBy);

		System.out.println("======= Map Apples ========");
		// Lambda expressions
		// Get List of origin countries of apples
		Set<String> countries = map(inventory, a -> a.getColor());
		CollectionUtils.printf(countries);
		//
		List<String> texts = Arrays.asList("a", "abc", "acdkdj", "asjdkfjskdf");
		Set<Integer> lengths =  map(texts, s -> s.length());
		CollectionUtils.printf(lengths);
	}

	private static <T, R> Set<R> map(List<T> ts, Function<T, R> function) {
		Set<R> result = new HashSet<>();

		for (T t : ts) {
			result.add(function.apply(t));
		}

		return result;
	}

	/**
	 * Get apples with give condition
	 * 
	 * @param inventory input data
	 * @param behavior  given condition
	 * @return output data
	 */
	// Lambda expression is a instance of Functional Interface
	// Functional interface
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
