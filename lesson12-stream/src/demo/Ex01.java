package demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;

import bean.Apple;
import utils.AppleUtils;
import utils.CollectionUtils;
import utils.WeightType;

public class Ex01 {
	public static void main(String[] args) {
		// input data
		List<Apple> inventory = AppleUtils.getAll();
		List<Apple> result = new ArrayList<Apple>();

		for (Apple apple : inventory) {
			if ("green".equals(apple.getColor())) {
				result.add(apple);
			}
		}
		System.out.println("===== Green Apples =====");
		CollectionUtils.printf(result);
		System.out.println("===== Red Apples =====");
		result = filterApples(inventory, "red");
		CollectionUtils.printf(result);

		System.out.println("===== Heavy Apples =====");
		result = filterApples(inventory, 150, WeightType.HEAVY);
		CollectionUtils.printf(result);

		System.out.println("===== Light Apples =====");
		result = filterApples(inventory, 200, WeightType.LIGHT);
		CollectionUtils.printf(result);

		System.out.println("===== Weight and Color Apples =====");
		result = filterApples(inventory, 280, "green");
		CollectionUtils.printf(result);

		System.out.println("===== weight and Country Apples =====");
		result = filterApplesBy(inventory, 200, "Vietnam");
		CollectionUtils.printf(result);

		Set<String> countries = map(inventory, a -> a.getColor());
		CollectionUtils.printf(countries);
		
		List<String> texts = Arrays.asList("abc", "abcde", "ab", "abcdefgh");
		Set<Integer> lengths = map(texts, s -> s.length());

	}

	private static <T,R> Set<R> map(List<T> elements, Function<T, R> function) {
		Set<R> result = new HashSet<>();

		for (T t: elements) {
			result.add(function.apply(t));
		}

		return result;
	}

	private static List<Apple> filterApples(List<Apple> inventory, String color) {
		List<Apple> result = new ArrayList<>();

		for (Apple apple: inventory) {
			if (color.equals(apple.getColor())) {
				result.add(apple);
			}
		}

		return result;
	}

	private static List<Apple> filterApples(List<Apple> inventory, double weight, WeightType type) {
		List<Apple> result = new ArrayList<>();
		switch (type) {
		case HEAVY: {	
			for (Apple apple: inventory) {
				if (apple.getWeight() > weight) {
					result.add(apple);
				}
			}
		}

		case LIGHT: {
			for (Apple apple: inventory) {
				if (apple.getWeight() < weight) {
					result.add(apple);
				}
			}
		}

		default:

		}

		return result;
	}

	private static List<Apple> filterApples(List<Apple> inventory, double weight, String color) {
		List<Apple> result = new ArrayList<>();

		for (Apple apple: inventory) {
			if ((apple.getWeight() > weight) && color.equals(apple.getColor())) {
				result.add(apple);
			}
		}

		return result;
	}

	private static List<Apple> filterApplesBy(List<Apple> inventory, int weight, String country) {
		Objects.requireNonNull(weight);
		Objects.requireNonNull(country);
		List<Apple> result = new ArrayList<Apple>();
		for (Apple apple : inventory) {
			if (apple.getWeight() > weight && country.equals(apple.getCountry())) {
				result.add(apple);
			}
		}
		return result;
	}

}
