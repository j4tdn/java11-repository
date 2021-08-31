package demo;

import java.util.List;
import java.util.Optional;

import bean.Dish;
import utils.DishUtils;

public class Ex13 {
	public static void main(String[] args) {
		List<Dish> menu = DishUtils.getAll();

		double sumOfCalories = menu.stream()		//Stream<Dish>
						.map(Dish::getCalories) 	// Stream<double>
						.reduce(0d, Double::sum);
		System.out.println(sumOfCalories);

		//primitive stream: IntStream, LongStream
		double priSumOfCalories = menu.stream()		//Stream<Dish>
				.mapToDouble(Dish::getCalories)		// DoubleStream	
				.sum();
		System.out.println(priSumOfCalories);
		
		// calories max
		Optional<Dish> dishOpt = menu.stream()
				.reduce(Dish::maxClr);
		dishOpt.ifPresent(System.out::println);
	}
}
