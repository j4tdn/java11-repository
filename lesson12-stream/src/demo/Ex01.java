package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import bean.Apple;
import bean.WeightType;
import utils.AppleUtils;
import utils.CollectionUtils;

public class Ex01 {
	public static void main(String[] args) {
		// input data
		List<Apple> inventory = AppleUtils.getAll();

		System.out.println("===== Green Apple =====");
		List<Apple> greenApples = filterApples(inventory, "green");
		CollectionUtils.printf(greenApples);

		System.out.println("===== Red Apple =====");
		List<Apple> redApples = filterApples(inventory, "red");
		CollectionUtils.printf(redApples);

		System.out.println("===== Heavy Apple =====");
		List<Apple> heavyApples = filterApples(inventory, 150, WeightType.HEAVY);
		CollectionUtils.printf(heavyApples);

		System.out.println("===== Light Apple =====");
		List<Apple> lightApples = filterApples(inventory, 200, WeightType.LIGHT);
		CollectionUtils.printf(lightApples);
		
		System.out.println("===== Weight and Color Apple =====");
		List<Apple> apples = filterApples(inventory, 280, "green");
		CollectionUtils.printf(apples);
		
		System.out.println("===== Weight and Country Apple =====");
		List<Apple> applesBy = filterApplesBy(inventory, 300, "Vietnam");
		CollectionUtils.printf(applesBy);
	}
	
	// pass by value
	// parameters: a, b, apple >> variable with data type

	private static List<Apple> filterApples(List<Apple> inventory, String color) {
		List<Apple> result = new ArrayList<>();

		for (Apple apple : inventory) {
			if (color.equals(apple.getColor()));
			result.add(apple);
		}

		return result;

	}

	private static List<Apple> filterApples(List<Apple> inventory, double weight, WeightType type) {
		List<Apple> result = new ArrayList<>();

//		for (Apple apple : inventory) {
//
//			if (type.equals(WeightType.HEAVY)) {
//				if (apple.getWeight() > weight) {
//					result.add(apple);
//				}
//			} else if (apple.getWeight() < weight) {
//				result.add(apple);
//			}
//		}

		switch (type) {
		case HEAVY:
			for (Apple apple : inventory) {
				if (apple.getWeight() > weight) {
					result.add(apple);
				}
			}
			break;
		case LIGHT: {
			for (Apple apple : inventory) {
				if (apple.getWeight() < weight) {
					result.add(apple);
				}
			}
			break;
		}
		}
		return result;
	}
	
	private static List<Apple> filterApples (List<Apple> inventory, double weight, String color){
		Objects.requireNonNull(inventory, "inventory cannot be null");
		Objects.requireNonNull(color, "color cannot be null");
		
		List<Apple> result = new ArrayList<>();
		
		for (Apple apple : inventory) {
			if (apple.getWeight() > weight && color.equals(apple.getColor())) {
				result.add(apple);
			}
		}
		
		return result;
	}
	
	private static List<Apple> filterApplesBy (List<Apple> inventory, double weight, String country ){
		Objects.requireNonNull(inventory, "inventory cannot be null");
		Objects.requireNonNull(country, "country cannot be null");
		
		List<Apple> result = new ArrayList<>();
		
		for (Apple apple : inventory) {
			if (apple.getWeight() > weight && country.equals(apple.getColor())) {
				result.add(apple);
			}
		}
		
		return result;
	}
}






