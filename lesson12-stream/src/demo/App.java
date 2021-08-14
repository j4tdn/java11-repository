package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import bean.Apple;
import bean.WeightType;
import utils.AppleUtils;
import utils.CollectionUtils;

public class App {
	public static void main(String[] args) {
		List<Apple> inventory= AppleUtils.getAll();
		
		System.out.println("=================GREEND APPLE==============");
		List<Apple> greenApple = filterApples(inventory,"green");
		CollectionUtils.printf(greenApple);
		
		System.out.println("===================RED APPLE===============");
		List<Apple> redApple = filterApples(inventory,"red");
		CollectionUtils.printf(redApple);
		
		System.out.println("===================Heavy APPLE===============");
		List<Apple> heavyApple = filterAppleByWeight(inventory,150,WeightType.HEAVY);
		CollectionUtils.printf(heavyApple);
		
		System.out.println("===================Light APPLE===============");
		List<Apple> lightApple = filterAppleByWeight(inventory,200,WeightType.LIGHT);
		CollectionUtils.printf(lightApple);
		
		System.out.println("===================Weight and color APPLE===============");
		List<Apple> apple = filterApples(inventory,200,"green");
		CollectionUtils.printf(lightApple);
		
	}
	private static List<Apple> filterApples(List<Apple> inventory, String color){
		List<Apple> result = new ArrayList<Apple>();
		for(Apple apple : inventory) {
			if(color.equals(apple.getColor())) {
				result.add(apple);
			}
		}
		return result;
	} 
	private static List<Apple> filterAppleByWeight(List<Apple> inventory, double weight, WeightType type) {
		List<Apple> result = new ArrayList<Apple>();
		switch (type) {
		case HEAVY:
			for(Apple apple : inventory) {
				if(apple.getWeight()>weight) {
					result.add(apple);
				}
			}
			break;
		case LIGHT:
			for(Apple apple : inventory) {
				if(apple.getWeight()<weight) {
					result.add(apple);
				}
			}
			break;
		}
		return result;
	}
	private static List<Apple> filterApples(List<Apple> inventory, double weight, String color){
		Objects.requireNonNull(inventory,"inventory can not be null");
		Objects.requireNonNull(color,"color cannot be null");
		
		List<Apple> result = new ArrayList<Apple>();
		for(Apple apple : inventory) {
			if(apple.getWeight()>weight && color.equals(apple.getColor())) {
				result.add(apple);
			}
		}
		return result;
	}
	
}