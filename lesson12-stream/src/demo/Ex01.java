package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

import bean.Apple;
import bean.WeightType;
import utils.AppleUtils;
import utils.CollectionUtils;

public class Ex01 {
	private static int g;

	public static void main(String[] args) {
		// input data
		List<Apple> inventory = AppleUtils.getAll();
		System.out.println("======== Green Apples =======");
		List<Apple> greenApp = filterApples(inventory, "green");
		CollectionUtils.printf(greenApp);

		System.out.println("======== Red Apples =======");
		List<Apple> redApp = filterApples(inventory, "red");
		CollectionUtils.printf(redApp);

		System.out.println("======== Heavy Apples =======");
		List<Apple> HeavyApp = filterWeightApple(inventory, 150, WeightType.HEAVY);
		CollectionUtils.printf(HeavyApp);

		System.out.println("======== Light Apples =======");
		List<Apple> LightApp = filterWeightApple(inventory, 200, WeightType.LIGHT);
		CollectionUtils.printf(LightApp);

		System.out.println("======== Weight and Color Apples =======");
		List<Apple> apples = filterApples(inventory, 200, "green");
		CollectionUtils.printf(apples);

		System.out.println("======== Weight and Country Apples =======");
		List<Apple> applesBy = filterApplesBy(inventory, 200, "Vietnam");
		CollectionUtils.printf(applesBy);
	}

	// pass by value
	// parameters: a, b, apple >> variable with data type

	private static List<Apple> filterApples(List<Apple> inventory, String color) {
		List<Apple> result = new ArrayList<>();
		for (Apple app : inventory) {
			if (color.equals(app.getColor())) {
				result.add(app);
			}
		}
		return result;
	}

	private static List<Apple> filterWeightApple(List<Apple> inventory, double weight, WeightType type) {
		List<Apple> result = new ArrayList<>();

		switch (type) {
		case HEAVY:
			for (Apple app : inventory) {
				if (app.getWeight() > weight) {
					result.add(app);
				}
			}
		case LIGHT:
			for (Apple app : inventory) {
				if (app.getWeight() < weight) {
					result.add(app);
				}
			}
		}
		return result;
	}

	private static List<Apple> filterApples(List<Apple> inventory, double weight, String color) {
		Objects.requireNonNull(inventory, "inventory cannot be null");
		Objects.requireNonNull(color, "color cannot be null");

		List<Apple> result = new ArrayList<>();
		for (Apple app : inventory) {
			if (app.getWeight() > weight && color.equals(app.getColor())) {
				result.add(app);
			}
		}
		return result;
	}

	private static List<Apple> filterApplesBy(List<Apple> inventory, double weight, String country) {
		Objects.requireNonNull(inventory, "inventory cannot be null");
		Objects.requireNonNull(country, "color cannot be null");

		List<Apple> result = new ArrayList<>();
		for (Apple app : inventory) {
			if (app.getWeight() > weight && country.equals(app.getCountry())) {
				result.add(app);
			}
		}
		return result;
	}
}
