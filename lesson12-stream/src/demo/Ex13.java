package demo;

import java.util.List;
import java.util.Optional;

import bean.Dish;
import utils.DishUtils;

/**
 * How could you calculate sum of the calories in the menu
 *
 */

public class Ex13 {
	public static void main(String[] args) {
		List<Dish> menu  = DishUtils.getAll();
		
		double sumOfCalories = menu.stream()
									.map(Dish::getCalories) //Stream<Double>
									.reduce(0d, Double::sum);
		System.out.println("sumOf Calories: " + sumOfCalories);
		
		//Primitive Stream: IntStream, LongStream, DoubleStream
		double priSumOfCalories = menu.stream() //Stream<Dish>
									  .mapToDouble(Dish::getCalories) //DoubleStream
									  .sum();
		System.out.println("priSumOfCalories: " + priSumOfCalories);
		
		//How to find dish with maximum calories 
		Optional<Dish> dishOpt = menu.stream().reduce(Dish::maxClr); //maxClr trong class Dish
			dishOpt.ifPresent(System.out::println);

	
	}
}
	
	

