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
		List<Apple> greenApples = filterApples(inventory, apple -> "green".equals(apple.getColor()));
		List<Apple> redApples = filterApples(inventory, apple -> "red".equals(apple.getColor()));
		List<Apple> heavyApples = filterApples(inventory, apple -> apple.getWeight() > 300);

		System.out.println("===== Green =====");
		CollectionUtils.printf(greenApples);
		System.out.println("===== Red =====");
		CollectionUtils.printf(redApples);
		System.out.println("===== heavy =====");
		CollectionUtils.printf(heavyApples);
	}
	// class >> abstract class
    // lambda expression is a instance of Functional Interface
	// Functional Interface Name finame = lambda expression
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
