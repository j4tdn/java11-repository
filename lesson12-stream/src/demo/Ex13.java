package demo;

import java.util.List;
import java.util.Optional;

import bean.Dish;
import utils.DishUtils;

public class Ex13 {
	public static void main(String[] args) {
		List<Dish> menu = DishUtils.getAll();
		
		// sum of calories in menu
		double sumOfCalories = menu.stream()
								   .map(Dish::getCalories)
								   .reduce(0d, Double::sum);
		System.out.println("sumOfCalories: " + sumOfCalories);
		
		// primitive stream: intStream, longStream
		double priSumOfCalories = menu.stream()
									  .mapToDouble(Dish::getCalories)
									  .sum();
		System.out.println("priSumOfCalories: " + priSumOfCalories);
		
		// find dish with maximum calories
		Optional<Dish> dishOpt = menu.stream()
									 .reduce(Dish::maxClr);
		dishOpt.ifPresent(System.out::println);
	}
}
