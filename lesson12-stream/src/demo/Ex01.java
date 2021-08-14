package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import bean.Apple;
import utils.AppleUtils;
import utils.CollectionUtils;
import utils.WeightType;

public class Ex01 {
	public static void main(String[] args) {
		// input data
				List<Apple> inventory = AppleUtils.getAll();
				List<Apple> result = new ArrayList<Apple>();

				for (Apple apple : inventory) {
					if ("green".equals(apple.getColor())) {
						result.add(apple);
					}
				}
				System.out.println("===== Green Apples =====");
				CollectionUtils.printf(result);
				System.out.println("===== Red Apples =====");
				result = filterApples(inventory, "red");
				CollectionUtils.printf(result);

				System.out.println("===== Heavy Apples =====");
				result = filterApples(inventory, 150, WeightType.HEAVY);
				CollectionUtils.printf(result);

				System.out.println("===== Light Apples =====");
				result = filterApples(inventory, 200, WeightType.LIGHT);
				CollectionUtils.printf(result);

				System.out.println("===== Weight and Color Apples =====");
				result = filterApples(inventory, 280, "green");
				CollectionUtils.printf(result);

				System.out.println("===== weight and Country Apples =====");
				result = filterApplesBy(inventory, 200, "Vietnam");
				CollectionUtils.printf(result);
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
	
	private static List<Apple> filterApplesBy(List<Apple> inventory, int weight, String country) {
		Objects.requireNonNull(weight);
		Objects.requireNonNull(country);
		List<Apple> result = new ArrayList<Apple>();
		for (Apple apple : inventory) {
			if (apple.getWeight() > weight && country.equals(apple.getCountry())) {
				result.add(apple);
			}
		}
		return result;
	}

}
