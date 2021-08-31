package demo;

import java.util.List;
import java.util.Optional;

import bean.Dish;
import utils.DishUtils;

public class Ex13 {
	public static void main(String[] args) {
		List<Dish> menu = DishUtils.getAll();
		double sumOfCalories  = menu.stream()
						 .map(Dish::getCalories)
						 .reduce(0d, Double::sum);
		
		// Primitive Stream: IntStream, LongStream, DoubleStream
		double priSumOfCalories = menu.stream()
									  .mapToDouble(Dish::getCalories).sum();
		
		// How could you find dish with maximum calories
		System.out.println("sumOfCalories: " + sumOfCalories);
		Optional<Dish> dishOpt  = menu.stream().reduce(DishUtils::maxCalories);
		dishOpt.ifPresent(System.out::println);
	}

}
