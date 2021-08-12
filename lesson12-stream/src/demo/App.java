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
		//input data
		List<Apple> inventory = AppleUtils.getAll();
		
		System.out.println("======= Green Apples ======");
		List<Apple> greenApples = filterApple(inventory, "green");
		CollectionUtils.printf(greenApples);
		System.out.println("=============Light Apples ===========");
		List<Apple> getWeightApple = filterWeight(inventory, 300, WeightType.LIGHT);
		CollectionUtils.printf(getWeightApple);
		
		System.out.println("============Weight and Color apples ============");
		List<Apple> apple = filterApple(inventory, 400, "green");
		CollectionUtils.printf(apple);
		
		System.out.println("============Weight and Country apples ============");
		List<Apple> appleCountry = filterAppleBy(inventory, 400, "Vietnam");
		CollectionUtils.printf(appleCountry);
	}
	private static List<Apple> filterApple(List<Apple> inventory, String color){
		Objects.requireNonNull(inventory, "inventory cannot be null");
		
		List<Apple> result = new ArrayList<>();
		for(Apple apple : inventory) {
			if(color.equals(apple.getColor())) {
				result.add(apple);
				
			}
	}
		return result;

	}
	
	private static List<Apple> filterAppleBy (List<Apple> inventory, double weight, String country){
		Objects.requireNonNull(inventory, "inventory cannot be null");
		Objects.requireNonNull(country, "inventory cannot be null");
		List<Apple> result = new ArrayList<>();
		for(Apple apple : inventory) {
			if(apple.getWeight() > weight && country.equals(apple.getCountry())) {
				result.add(apple);
			}
		}
		return result;
	}
	
	private static List<Apple> filterWeight(List<Apple> inventory, double weight, WeightType type){
		
		List<Apple> result = new ArrayList<>();
		
		switch (type) {
		case HEAVY:
			for(Apple apple : inventory) {
				if(apple.getWeight() > weight) {
					result.add(apple);
				}
			}
			break;
		case LIGHT:
			for(Apple apple : inventory) {
				if(apple.getWeight() < weight) {
					result.add(apple);
				}
			}
			break;
		}
		return result;
}
	private static List<Apple> filterApple(List<Apple> inventory,double weight, String color){
		Objects.requireNonNull(inventory, "inventory cannot be null");
		Objects.requireNonNull(color, "color can not be null");
		
		List<Apple> result = new ArrayList<>();
		for(Apple apple : inventory) {
			if(color.equals(apple.getColor())) {
				result.add(apple);
				
			}
	}
		return result;

	}
	
	}