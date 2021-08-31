package demo;

import java.util.List;
import java.util.Optional;

import bean.Dish;
import utils.DishUtils;

public class Ex13 {
	public static void main(String[] args) {
		List<Dish> menu = DishUtils.getAll();
		double sumofCalories = menu.stream().map(Dish::getCalories).reduce(0d, Double::sum);
		System.out.println("sumOfCalories:" + sumofCalories);
		// Primitive Stream: IntStream, LongStream, DoubleStream
		double priSumOfCalories = menu.stream() // stream<Dish>
				.mapToDouble(Dish::getCalories).sum();
		System.out.println("priSumOfCalories:" + priSumOfCalories);

		Optional<Dish> dishOpt = menu.stream().reduce(Dish::maxCalories);
		System.out.println("The dish's max of calories: " + dishOpt.get());

	}

}
