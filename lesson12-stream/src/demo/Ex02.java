package demo;

import java.util.ArrayList;
import java.util.List;

import bean.Apple;
import bean.Strategy;
import utils.AppleUtils;
import utils.CollectionUtils;

public class Ex02 {
	public static void main(String[] args) {
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
