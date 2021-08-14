package demo;

import java.util.ArrayList;
import java.util.List;

import bean.*;
import utils.*;

public class Ex02 {
	public static void main(String[] args) {
		List<Apple> inventory = AppleUtils.getAll();
		
		List<Apple> greenApple = filterApples(inventory, apple -> 
				 "green".equals(apple.getColor()));
		
		List<Apple> redApple = filterApples(inventory,apple ->
				 "red".equals(apple.getColor())); 
		System.out.println("====== Green Apples ======");
		CollectionUtils.printf(greenApple);
		
		System.out.println("====== red Apples ======");
		CollectionUtils.printf(redApple);
	}
	/*
	 * get Apple with given condition
	 * 
	 * @param inventory input data
	 * @param behavior given condition
	 * @return output data
	 */
	
	// class >> abstract class
	// Lambda expression is a instance
	private static List<Apple> filterApples(List<Apple> inventory, Strategy strategy){
		List<Apple> result = new ArrayList<>();
		for(Apple apple: inventory) {
			if(strategy.behavior(apple)) {
				result.add(apple);
			}
			
		}
		return result;
	}
	private static boolean behavior(Apple apple) {
		return apple.getWeight() > 300;
	}

}
