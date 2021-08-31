package demo;

import java.util.List;
import java.util.Optional;

import bean.Dish;
import utils.DishUtils;

public class Ex13 {
	public static void main(String[] args) {
		List<Dish> menu = DishUtils.getAll();
		
		double sumOfCalories = menu.stream()
								   .map(Dish::getCalories)
								   .reduce(0d, Double::sum);
		System.out.println("sumOfCalories: " + sumOfCalories);
		
		// Primitive Stream: IntStream, DoubleStream, ...
		double priSumOfCalories = menu.stream()
								.mapToDouble(Dish::getCalories)
								.sum();
		System.out.println("priSumOfCalories" + priSumOfCalories);
		
		// 2
		Optional<Dish> optDish = menu.stream().reduce((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2);
		optDish.ifPresent(System.out::println);
		
	}
}
