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

		// anonymous class
		List<Apple> greenApple = filterApples(inventory, a -> "green".equals(a.getColor()));
		List<Apple> redApple = filterApples(inventory, a -> "red".equals(a.getColor()));
		List<Apple> wApple = filterApples(inventory, a -> a.getWeight() > 200);

		System.out.println("========Green Apples =======");
		CollectionUtils.printf(greenApple);
		System.out.println("========red Apples =======");
		CollectionUtils.printf(redApple);
		System.out.println("========w Apples =======");
		CollectionUtils.printf(wApple);

	}

	// class >> abstract class
	// Lambda expression is a instance of Functional Interface
	// Functional Interface Name finame = Lambda expression
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
