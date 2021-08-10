package demo;

import java.util.ArrayList;
import java.util.List;
import bean.Apple;
import bean.Strategy;
import utils.AppleUtils;
import utils.collectionUtils;

public class Ex02 {
	public static void main(String[] args) {
		List<Apple> inventory = AppleUtils.getAll();
		
		List<Apple> greenApples = filterApples(inventory, a->"green".equals(a.getColor()));
		
		System.out.println("==========greenApple===========");
		collectionUtils.printf(greenApples);
		
		List<Apple> heavyApples = filterApples(inventory, a->a.getWeight()>200 );
		System.out.println("==========greenApple===========");
		collectionUtils.printf(heavyApples);
	}
	
	

	public static List<Apple> filterApples(List<Apple> inventory, Strategy<Apple> strategy){
		List<Apple> result = new ArrayList<Apple>();
		for (Apple apple : inventory) {
			if(strategy.behavior(apple)) {
				result.add(apple);
			}
		}
		return result;
	}
}
