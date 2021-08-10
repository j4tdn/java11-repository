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
		List<Apple> inventory = AppleUtils.getAll();
		
		System.out.println("==== Green Apples ====");
		List<Apple> greenApples = filterApples(inventory, "green");
		CollectionUtils.printf(greenApples);
		
		System.out.println("==== Red Apples ====");
		List<Apple> redApples = filterApples(inventory, "red");
		CollectionUtils.printf(redApples);
		
		System.out.println("====heavier apples====");
		List<Apple> heavyApples = filterHeavy(inventory, 150, WeightType.HEAVY);
		CollectionUtils.printf(heavyApples);
		
		System.out.println("====lighter apples====");
		List<Apple> lightApples = filterHeavy(inventory, 200, WeightType.LIGHT);
		CollectionUtils.printf(lightApples);
		
		System.out.println("====weight and heavy apples====");
		List<Apple> apples = filterApples(inventory, 200, "green");
		CollectionUtils.printf(apples);
		
		System.out.println("====weight and heavy apples====");
		List<Apple> applesBy = filterApplesBy(inventory, 200, "vietnam");
		CollectionUtils.printf(applesBy);
	}
	
	private static List<Apple> filterApples(List<Apple> inventory, String color) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if(color.equals(apple.getColor())) {
				result.add(apple);
			}
		}
		return result;
	}
	
	private static List<Apple> filterHeavy (List<Apple> inventory, double weight, WeightType type){
		List<Apple> result = new ArrayList<>();
		switch (type) {
		case HEAVY:
			for (Apple apple : inventory) {
				if(apple.getWeight() > weight) {
					result.add(apple);
				}
			}
			break;
		case LIGHT:
			for (Apple apple : inventory) {
				if(apple.getWeight() < weight) {
					result.add(apple);
				}
			}
			break;
		}
		return result;
	}
	
	private static List<Apple> filterApples (List<Apple> inventory, double weight, String color){
		Objects.requireNonNull(inventory, "inven can't be null");
		Objects.requireNonNull(color, "color can't be null");
		
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if(apple.getWeight() > weight && color.equals(apple.getColor())) {
				result.add(apple);
			}
		}
		return result;
	}
	
	private static List<Apple> filterApplesBy (List<Apple> inventory, double weight, String country){
		Objects.requireNonNull(inventory, "inven can't be null");
		Objects.requireNonNull(country, "color can't be null");
		
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if(apple.getWeight() > weight && country.equals(apple.getCountry())) {
				result.add(apple);
			}
		}
		return result;
	}
}
