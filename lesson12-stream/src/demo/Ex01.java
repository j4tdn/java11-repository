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

		System.out.println("======= Green ===========");
		List<Apple> greenApples = fillterApple(inventory, "green");
		CollectionUtils.printf(greenApples);

		System.out.println("======= Red ===========");
		List<Apple> redApples = fillterApple(inventory, "red");
		CollectionUtils.printf(redApples);
		
		System.out.println("======= Heavy ===========");
		List<Apple> heavyApples = fillterHeavy(inventory, 150, WeightType.HEAVY);
		CollectionUtils.printf(heavyApples);


	}

	private static List<Apple> fillterApple(List<Apple> inventory, String color) {
		Objects.requireNonNull(inventory, "inventory cannot be null");
		Objects.requireNonNull(color, "inventory cannot be null");
		
		List<Apple> result = new ArrayList<>();

		for (Apple apple : inventory) {
			if (color.equalsIgnoreCase(apple.getColor())) {
				result.add(apple);
			}
		}

		return result;
	}

	private static List<Apple> fillterHeavy(List<Apple> inventory, double weight, WeightType type) {
		List<Apple> result = new ArrayList<>();

		switch (type) {
		case HEAVY:
			for (Apple apple : inventory) {
				if (weight < apple.getWeight()) {
					result.add(apple);
				}
			}
			break;
		case LIGHT:
			for (Apple apple : inventory) {
				if (weight < apple.getWeight()) {
					result.add(apple);
				}
			}
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + type);
		}

		return result;
	}

}
