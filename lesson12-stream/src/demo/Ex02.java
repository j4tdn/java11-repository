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
		
		// anonymous class
		List<Apple> heavyApples = filterApples(inventory, apple -> apple.getWeight() > 300);
		
		System.out.println("===== Green Apples =====");
		CollectionUtils.printf(greenApples);
		
		System.out.println("===== Red Apples =====");
		CollectionUtils.printf(redApples);
		
		System.out.println("===== Heavy Apples =====");
		CollectionUtils.printf(heavyApples);
	}

	/**
	 * Get apples with given condition
	 * 
	 * @param inventory input data
	 * @param behavior given condition
	 * @return output data
	 */
	// class >> abtract class
	// Lambda expression is a instance of Functional Interface
	// Functional Interface 
	private static List<Apple> filterApples(List<Apple> inventory, Strategy strategy){
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (strategy.behavior(apple)) {
				result.add(apple);
			}
		}
		
		return result;
	}
}