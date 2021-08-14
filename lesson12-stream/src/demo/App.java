package demo;

import java.util.ArrayList;
import java.util.List;

import bean.*;
import utils.*;

public class App {
	public static void main(String[] args) {
		// input data
		List<Apple> inventory = AppleUtils.getAll();

		System.out.println("==========Apple Green ========");
		List<Apple> greenApples =  filterApples(inventory, "green");
		CollectionUtils.printf(greenApples);
		
		System.out.println("==========Red Green ========");
		List<Apple> redApples = filterApples(inventory, "red");
		CollectionUtils.printf(redApples);
		
		System.out.println("==========AppleWeight ========");
		List<Apple> heavyApple = filterHeavyApples(inventory, 150, WeightType.HEAVY);
		CollectionUtils.printf(heavyApple);
		
		System.out.println("==========lightApple ========");
		List<Apple> lightApple = filterHeavyApples(inventory, 150, WeightType.LIGHT);
		CollectionUtils.printf(lightApple);

	}
	public static List<Apple> filterApples(List<Apple> inventory, String color){
		List<Apple> result = new ArrayList<>();

		for(Apple apple : inventory) {
			if(color.equals(apple.getColor())) {
				result.add(apple);
			}
		}
		return result;
	}
	private static List<Apple> filterHeavyApples(List<Apple> inventory, double weight, WeightType type){
		List<Apple> result = new ArrayList<>();
		switch(type){
		case HEAVY:
			for(Apple apple: inventory) {
				if(apple.getWeight()> weight) {
					result.add(apple);
				}
			}
		case LIGHT:
			for(Apple apple: inventory) {
				if(apple.getWeight() < weight) {
					result.add(apple);
				}
			}
		}
		
		return result;
	}

}
