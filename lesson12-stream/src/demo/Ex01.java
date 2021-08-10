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

		for (Apple element : inventory) {
			if ("green".equals(element.getColor())) {
				result.add(element);
			}
		}
		System.out.println("======== Green Apples");
		CollectionUtils.printf(result);

		System.out.println("======== Red Apples ======");
		List<Apple> redApples = filterApples(inventory, "red");
		CollectionUtils.printf(redApples);
		
		System.out.println("======== Than 150g Apples=======");
		List<Apple> bigApples = filterApples(inventory, 150, WeightType.HEAVY);
		CollectionUtils.printf(bigApples);
		
		System.out.println("======== Less 150g Apples=======");
		List<Apple> smallApples = filterApples(inventory, 150, WeightType.LIGHT);
		CollectionUtils.printf(smallApples);
		
		System.out.println("======== Weight and Color Apples=======");
		List<Apple> apples = filterApples(inventory, 400, "red");
		CollectionUtils.printf(apples);
		
		System.out.println("======== Weight and Country Apples=======");
		List<Apple> applesBy = filterApplesBy(inventory, 300, "Thailand");
		CollectionUtils.printf(applesBy);
	}

	private static List<Apple> filterApples(List<Apple> inventory, String color) {
		List<Apple> result = new ArrayList<>();

		for (Apple element : inventory) {
			if (color.equals(element.getColor())) {
				result.add(element);
			}
		}

		return result;
	}

	private static List<Apple> filterApples(List<Apple> inventory, double weight, WeightType type) {
		List<Apple> result = new ArrayList<>();

		if (type.equals(WeightType.HEAVY)) {
			for (Apple element : inventory) {
				if (element.getWeight() > weight) {
					result.add(element);
				}
			}
		} else {
			for (Apple element : inventory) {
				if (element.getWeight() < weight) {
					result.add(element);
				}
			}
		}

		return result;
	}
	private static List<Apple> filterApples(List<Apple> inventory, double weight, String color){
		Objects.requireNonNull(inventory, "inventory cannot be null");
		Objects.requireNonNull(color, "color cannot be null");
		
		List<Apple> result = new ArrayList<>();
		
		for (Apple element : inventory) {
			if(element.getWeight() > weight && color.equals(element.getColor())) {
				result.add(element);
			}
		}
		
		return result;
	}
	
	private static List<Apple> filterApplesBy(List<Apple> inventory, double weight, String country){
		Objects.requireNonNull(inventory, "inventory cannot be null");
		Objects.requireNonNull(country, "color cannot be null");
		
		List<Apple> result = new ArrayList<>();
		
		for (Apple element : inventory) {
			if(element.getWeight() > weight && country.equals(element.getCountry())) {
				result.add(element);
			}
		}
		
		return result;
	}
}
