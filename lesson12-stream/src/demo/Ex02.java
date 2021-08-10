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
		
		List<Apple> greenApples = filerApples(inventory, a -> "green".equals(a.getColor()));
		
		List<Apple> redApples = filerApples(inventory, a -> "red".equals(a.getColor()));
		
		System.out.println("====green apple====");
		CollectionUtils.printf(greenApples);
		
		System.out.println("====red apple====");
		CollectionUtils.printf(redApples);
		
	}
	
	
/**
 * get apples with given condition
 * 
 * @param inventory input data
 * @param behavior given condition
 * @return out put data
 */
	private static List<Apple> filerApples(List<Apple> inventory, Strategy<Apple> strategy) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if(strategy.behavior(apple)) {
				result.add(apple);
			}
		}
		return result;
	}
	
}
