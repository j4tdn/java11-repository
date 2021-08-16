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
		// input data
		List<Apple> inventory = AppleUtils.getAll();

		System.out.println("======= Green ===========");
		List<Apple> greenApples = fillterApple(inventory, a -> "green".equals(a.getColor()));
		CollectionUtils.printf(greenApples);

		System.out.println("======= Red ===========");
		List<Apple> redApples = fillterApple(inventory, a -> "red".equals(a.getColor()));
		CollectionUtils.printf(redApples);

		System.out.println("======= Heavy ===========");
		List<Apple> heavyApples = fillterApple(inventory, a -> a.getWeight() > 150);
		CollectionUtils.printf(heavyApples);

		System.out.println("======= Map String ===========");
		Set<String> country = map(inventory, a -> a.getCountry());
		CollectionUtils.printf(country);
		List<String> text = Arrays.asList("ab", "abc", "abcd", "abcde");
		Set<Integer> lenght = map(text, t -> t.length());
		CollectionUtils.printf(lenght);

	}

	private static <T, R> Set<R> map(List<T> inventory, Function<T, R> func) {
		Set<R> result = new HashSet<>();
		for (T apple : inventory) {
			result.add(func.apply(apple));
		}
		return result;
	}

	/**
	 * Get apples with given condition.
	 * 
	 * @param inventory input data
	 * @param behavior  given condition
	 * @return output data
	 */
	private static List<Apple> fillterApple(List<Apple> inventory, Strategy<Apple> strategy) {
		List<Apple> result = new ArrayList<>();

		for (Apple apple : inventory) {
			if (strategy.behavior(apple)) {
				result.add(apple);
			}
		}
		return result;
	}

}
