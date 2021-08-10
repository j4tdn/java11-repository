package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import bean.Apple;
import bean.WeightType;
import utils.AppleUtils;
import utils.collectionUtils;

public class Ex01 {
	public static void main(String[] args) {
		List<Apple> inventory = AppleUtils.getAll();

		System.out.println("=========green Apple==========");
		List<Apple> greenApples = filterApples(inventory, "green");
		collectionUtils.printf(greenApples);

		System.out.println("=========green Apple==========");
		List<Apple> redApples = filterApples(inventory, "green");
		collectionUtils.printf(redApples);

		System.out.println("=========Heavy Apple==========");
		List<Apple> HeavyApples = filterHeavyApples(inventory, 150, WeightType.HEAVY);
		collectionUtils.printf(HeavyApples);

		System.out.println("=========Light Apple==========");
		List<Apple> LightApples = filterHeavyApples(inventory, 150, WeightType.HEAVY);
		collectionUtils.printf(LightApples);
		
		System.out.println("=========Weigh and Color Apple==========");
		List<Apple> apples = filterApple(inventory, 200, "green");
		collectionUtils.printf(apples);
		
		System.out.println("=========Weigh and coutry Apple==========");
		List<Apple> apple1 = filterAppleBy(inventory, 200, "Viet Nam");
		collectionUtils.printf(apple1);
	}

	private static List<Apple> filterApples(List<Apple> inventory, String color) {
		List<Apple> result = new ArrayList<Apple>();
		for (Apple apple : inventory) {
			if (color.equals(apple.getColor())) {
				result.add(apple);
			}
		}
		return result;
	}

	private static List<Apple> filterHeavyApples(List<Apple> inventory, double weight, WeightType type) {
		List<Apple> result = new ArrayList<Apple>();

		switch (type) {
		case HEAVY: {
			for (Apple apple : inventory) {
				if (apple.getWeight() > weight) {
					result.add(apple);
				}
			}

		}
		case LIGHT: {
			for (Apple apple : inventory) {
				if (apple.getWeight() < weight) {
					result.add(apple);
				}
			}

		}

		}
		return result;

	}
	
	private static List<Apple> filterApple(List<Apple> inventory, double weight, String color){
		Objects.requireNonNull(inventory, "inventory cannot be null");
		Objects.requireNonNull(color, "color cannot be null");
		
		List<Apple> result = new ArrayList<Apple>();
		
		for (Apple apple : inventory) {
			if(apple.getWeight() > weight && color.equals(apple.getColor())) {
				result.add(apple);
			}
		}
		
		return result;
	}
	private static List<Apple> filterAppleBy(List<Apple> inventory, double weight, String country){
		Objects.requireNonNull(inventory, "inventory cannot be null");
		Objects.requireNonNull(country, "country cannot be null");
		
		List<Apple> result = new ArrayList<Apple>();
		
		for (Apple apple : inventory) {
			if(apple.getWeight() > weight && country.equals(apple.getCountry())) {
				result.add(apple);
			}
		}
		
		return result;
	}
}
