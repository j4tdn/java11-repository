package demo;

import java.util.ArrayList;
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

		System.out.println("=================GREEND APPLE==============");
		List<Apple> green = filterApples(inventory, a -> "green".equals(a.getColor()));
		CollectionUtils.printf(green);

		System.out.println("=================GREEND APPLE==============");
		List<Apple> red = filterApples(inventory, a -> "red".equals(a.getColor()));
		CollectionUtils.printf(red);

		// Lambda expressions

		Set<String> countries = map(inventory, apple -> apple.getCountry());
		CollectionUtils.printf(countries);

	}

	private static <T, R> Set<R> map(List<T> ts, Function<T, R> function) {
		Set<R> result = new HashSet<>();

		for (T t: ts) {
			result.add(function.apply(t));
		}

		return result;
	}

	/**
	 * Get apple with given condition
	 * 
	 * @param inventory input data
	 * @param behavior  given condition
	 * @return output data
	 */
	private static List<Apple> filterApples(List<Apple> inventory, Strategy<Apple> strategy) {
		List<Apple> rs = new ArrayList<Apple>();

		for (Apple apple : inventory) {
			if (strategy.test(apple)) {
				rs.add(apple);
			}
		}
		return rs;
	}

}
