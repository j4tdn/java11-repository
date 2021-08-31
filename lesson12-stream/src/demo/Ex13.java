package demo;

import java.util.List;
import java.util.Optional;

import bean.Dish;
import utils.DishUtils;

/**
 * 
 * how could you calculate sum of the calories in the menu
 *
 */
public class Ex13 {
	public static void main(String[] args) {
		List<Dish> menu = DishUtils.getAll();
		
		double sumOfCalories = menu.stream()
								.map(Dish::getCalories)
								.reduce(0d, Double::sum);
		System.out.println("sumOfCalories: " + sumOfCalories);
		
		double  priSumOfCalories = menu.stream()
				.mapToDouble(Dish::getCalories).sum();
		System.out.println("priSumOfCalories: " + priSumOfCalories);
		
		 Optional<Dish> dishOpt=  menu.stream().reduce(Dish::max);
		dishOpt.ifPresent(System.out::println);
	}
}
