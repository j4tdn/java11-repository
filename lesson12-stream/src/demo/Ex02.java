package demo;

import java.util.ArrayList;
import java.util.List;

import bean.Apple;
import bean.Strategy;
import utils.AppleUtils;
import utils.CollectionUtils;

public class Ex02 {
	 public static void main(String[] args) {
			// input data
			List<Apple> inventory = AppleUtils.getAll();
			
			System.out.println("======= Green ===========");
			List<Apple> greenApples = fillterApple(inventory, a -> "green".equals(a.getColor()));
			CollectionUtils.printf(greenApples);
			
			System.out.println("======= Red ===========");
			List<Apple> redApples = fillterApple(inventory, a -> "red".equals(a.getColor()));
			CollectionUtils.printf(redApples);
			
			System.out.println("======= Heavy ===========");
			List<Apple> heavyApples = fillterApple(inventory, a -> a.getWeight() > 150);
			CollectionUtils.printf(heavyApples);
	}
	 /**
	  * Get apples with given condition. 
	  * 
	  * @param inventory input data
	  * @param behavior given condition
	  * @return output data
	  */
	 private static List<Apple> fillterApple(List<Apple> inventory,Strategy<Apple> strategy){
		 List<Apple> result = new ArrayList<>();

			for (Apple apple : inventory) {
				if (strategy.behavior(apple)) {
					result.add(apple);
				}
			}
			return result;
	 }
}
