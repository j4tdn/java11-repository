package demo;

import java.util.List;
import java.util.Optional;

import bean.Dish;
import utils.DishUtils;

public class Ex13 {
	public static void main(String[] args) {
		List<Dish> menu = DishUtils.getAll();
		
		double sumOfCalories = menu.stream().map(Dish::getCalories).reduce(0d, Double::sum);
		Optional<Dish> disOpt = menu.stream().reduce(Dish::maxClr);
		System.out.println("sumOfCalories: " + sumOfCalories);
		disOpt.ifPresent(System.out::println);
		
		// Primitive Stream: IntStream, LongStream, DoubleStream
		double priSumOfCalories = menu.stream()
									  .mapToDouble(Dish::getCalories)
									  .sum();
		System.out.println("priSumOfCalories: " + priSumOfCalories);
		
	}
}
