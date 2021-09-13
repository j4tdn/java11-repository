package demo;

import java.util.List;
import java.util.Optional;

import bean.Dish;
import utils.DishUtils;

/*
 *	How could caculate  
 */
public class Ex13 {
	public static void main(String[] args) {
		List<Dish> menu = DishUtils.getAll();
		
		double sumOfCalories = menu.stream()
								   .map(Dish::getCalories)
								   .reduce(0d, Double::sum);

		System.out.println(sumOfCalories);
		
		double priSumOfCalories = menu.stream()
									  .mapToDouble(Dish::getCalories)
									  .sum();
		System.out.println(priSumOfCalories);
		
		// How could find dish with maximum calories
		Optional<Dish> dishOpt = menu.stream()
									 .reduce((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2);
		dishOpt.ifPresent(System.out::println);
	}
}
