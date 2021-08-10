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
		List<Apple> result = new ArrayList<>();

		System.out.println("====== Green Apples ======");
		List<Apple> greenApples = filterApples(inventory, "green");
		CollectionUtils.printf(greenApples);

		System.out.println("====== Red Apples ======");
		List<Apple> redApples = filterApples(inventory, "red");
		CollectionUtils.printf(redApples);

		System.out.println("====== Heavy Apples ======");
		List<Apple> heavyApples = filterHeavyApples(inventory, 150, WeightType.HEAVY);
		CollectionUtils.printf(heavyApples);

		System.out.println("====== Light Apples ======");
		List<Apple> lightApples = filterHeavyApples(inventory, 150, WeightType.LIGHT);
		CollectionUtils.printf(lightApples);
		
		System.out.println("====== Weight and Color Apples ======");
		List<Apple> apples = filterApples(inventory, 400, "green");
		CollectionUtils.printf(apples);
		
		System.out.println("====== Weight and Country Apples ======");
		List<Apple> applesBy = filterApplesBy(inventory, 400, "VietNam");
		CollectionUtils.printf(applesBy);
	}

	private static List<Apple> filterApples(List<Apple> inventory, String color) {
		List<Apple> result = new ArrayList<>();

		for (Apple apple : inventory) {
			if (color.equals(apple.getColor())) {
				result.add(apple);
			}
		}
		return result;
	}

	private static List<Apple> filterHeavyApples(List<Apple> inventory, double weight, WeightType type) {
		List<Apple> result = new ArrayList<>();

		switch (type) {
		case HEAVY:
			for (Apple apple : inventory) {
				if (apple.getWeight() > weight) {
					result.add(apple);
				}
			}
			break;
		case LIGHT:
			for (Apple apple : inventory) {
				if (apple.getWeight() < weight) {
					result.add(apple);
				}
			}
			break;
		}
		return result;
	}
	
	private static List<Apple> filterApples(List<Apple> inventory, double weight, String color){
		Objects.requireNonNull(inventory, "inventory can not be null");
		Objects.requireNonNull(color, "color can not be null");
		
		List<Apple> result = new ArrayList<>();

		for (Apple apple : inventory) {
			if (color.equals(apple.getColor()) && apple.getWeight() > weight) {
				result.add(apple);
			}
		}
		return result;
	}
	
	private static List<Apple> filterApplesBy(List<Apple> inventory, double weight, String country){
		Objects.requireNonNull(inventory, "inventory can not be null");
		Objects.requireNonNull(country, "country can not be null");
		
		List<Apple> result = new ArrayList<>();
		
		for (Apple apple : inventory) {
			if (country.equals(apple.getCountry()) && apple.getWeight() > weight) {
				result.add(apple);
			}
		}
		return result;
	}
}
