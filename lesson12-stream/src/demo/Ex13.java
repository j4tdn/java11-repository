package demo;

import java.util.List;
import java.util.Optional;

import bean.Dish;
import utils.DishUtils;

public class Ex13 {

	public static void main(String[] args) {
		List<Dish> menu = DishUtils.getAll();

		double sumOfCalories = menu.stream().map(Dish::getCalories).reduce(0d, Double::sum);

		System.out.println("sum: " + sumOfCalories);

		double priSumOfCalories = menu.stream().mapToDouble(Dish::getCalories).sum();
		System.out.println(priSumOfCalories);

		// how could you find dish with maximum calories

		Optional<Dish> dishMaxClr =

				menu.stream().reduce(Dish::MaxClr);

		dishMaxClr.ifPresent(System.out::println);

	}

}
