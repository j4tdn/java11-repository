package demo;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

import bean.Dish;
import utils.DishUtils;

public class Ex13 {
	public static void main(String[] args) {
		List<Dish> menu = DishUtils.getAll();
		
		
		double sumOfCalories = menu.stream()
				.map(Dish::getCalories) //Stream<Double>
				.reduce(0d, Double::sum); 
		System.out.println("sumOfCalories: "+sumOfCalories);
		
		//Primitive Stream : IntStream, LongStream, DoubleStream
		double priSumOfCalories = menu.stream()
				.mapToDouble(Dish::getCalories).sum();
		System.out.println("priSumOfCalories: "+priSumOfCalories);
		
		//Find Dish with max calories
		//Optional<Dish> dishOpt =  menu.stream().reduce(Dish::maxClr);
		//dishOpt.ifPresent(System.out::println);
		
	}
}