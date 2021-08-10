package demo;

import java.util.ArrayList;
import java.util.List;

import bean.Apple;
import utils.AppleUtils;
import utils.CollectionUtils;
import utils.WeightType;

public class App {
	public static void main(String[] args) {
		List<Apple> inventory = AppleUtils.getAll();
		List<Apple> result = new ArrayList<>();
		
		List<Apple> greenApples = filterApples(inventory, "green");
		
		CollectionUtils.printf(greenApples);
		
		List<Apple> redApples = filterApples(inventory, "red");
		
		CollectionUtils.printf(redApples);
	}
	
	private static List<Apple> filterApples(List<Apple> inventory, String color) {
		List<Apple> result = new ArrayList<>();
		
		for (Apple apple: inventory) {
			if (color.equals(apple.getColor())) {
				result.add(apple);
			}
		}
		
		return result;
	}
	
	private static List<Apple> filterApples(List<Apple> inventory, double weight, WeightType type) {
		List<Apple> result = new ArrayList<>();
		switch (type) {
		case HEAVY: {	
			for (Apple apple: inventory) {
				if (apple.getWeight() > weight) {
					result.add(apple);
				}
			}
		}
		
		case LIGHT: {
			for (Apple apple: inventory) {
				if (apple.getWeight() < weight) {
					result.add(apple);
				}
			}
		}
		
		default:
			
		}
		
		return result;
	}
	
	private static List<Apple> filterApples(List<Apple> inventory, double weight, String color) {
		List<Apple> result = new ArrayList<>();
		
		for (Apple apple: inventory) {
			if ((apple.getWeight() > weight) && color.equals(apple.getColor())) {
				result.add(apple);
			}
		}
		
		return result;
	}

}
