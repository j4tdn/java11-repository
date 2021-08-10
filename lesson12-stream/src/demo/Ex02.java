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
		
		List<Apple> apples = filterApples(inventory, a -> "red".equals(a.getColor()));
		
		System.out.println("=====================");
		CollectionUtils.printf(apples);
	}
	
	

	/**
	 * Get apples with given condition.
	 * 
	 * @param inventory
	 * @param behavior
	 * @return
	 */

	private static List<Apple> filterApples(List<Apple> inventory, Strategy<Apple> strategy) {
		List<Apple> result = new ArrayList<>();

		for (Apple element : inventory) {
			if (strategy.behavior(element)) {
				result.add(element);
			}
		}
		return result;
	}
}