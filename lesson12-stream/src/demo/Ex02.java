package demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

import bean.Apple;
import bean.Condition;
import utils.AppleUtils;
import utils.CollectionUtils;

public class Ex02 {
	public static void main(String[] args) {
		List<Apple> inventory = AppleUtils.getAll();
		
		List<Apple> apples = filterApples(inventory, a -> "red".equals(a.getColor()));
		
		System.out.println("=====================");
		CollectionUtils.printf(apples);
		
		// Lambda expressions 
		// Get list of origin countries of applet
		
		System.out.println("======================");
		Set<String> countries = map(inventory, a -> a.getCountry());
		CollectionUtils.printf(countries);
		
	}
	
	private static <T, R> Set<R> map(List<T> ts, Function<T, R> function){
		Set<R> result = new HashSet<>();
		
		// behavior(T = Apple): R
		for (T t : ts) {
			// apple -> country, weight, id
			result.add(function.apply(t));
		}
		
		return result;
	}
	

	/**
	 * Get apples with given condition.
	 * 
	 * @param inventory
	 * @param behavior
	 * @return
	 */

	private static List<Apple> filterApples(List<Apple> inventory, Condition condition) {
		List<Apple> result = new ArrayList<>();

		for (Apple element : inventory) {
			if (condition.behavior(element)) {
				result.add(element);
			}
		}
		return result;
	}
}
