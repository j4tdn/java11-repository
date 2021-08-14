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
	public static <T> void main(String[] args) {
		List<Apple> inventory = AppleUtils.getAll();

		List<Apple> greenApples = filterApples(inventory, a -> "green".equals(a.getColor()));

		List<Apple> redApples = filterApples(inventory, a -> "red".equals(a.getColor()));

		// anonymous class
		// Lambda expression is a instance of Functional Interface
		// Functional Interface Name finame = lambda expression
		List<Apple> heavyApples = filterApples(inventory, a -> a.getWeight() > 300);

		System.out.println("====== Green Apples ======");
		CollectionUtils.printf(greenApples);

		System.out.println("====== Red Apples ======");
		CollectionUtils.printf(redApples);

		System.out.println("====== Heavy Apples ======");
		CollectionUtils.printf(heavyApples);
		
		
		System.out.println("====== Map Apples ======");
		// Lambda expressions
		// Get list of origin countries of apples
		Set<String> colors = CollectionUtils.map(inventory,  a -> a.getColor());
		CollectionUtils.printf(colors);

		System.out.println("====== Map Length ======");
		List<String> texts = Arrays.asList("abc", "abcde", "ab", "abcdefgh");
		Set<Integer> lengths = CollectionUtils.map(texts, s -> s.length());
		CollectionUtils.printf(lengths);
		
	}

	// class >> abstract class
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
