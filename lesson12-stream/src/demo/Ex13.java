package demo;

import java.util.List;
import java.util.Optional;

import bean.Dish;
import utils.DishUtils;

public class Ex13 {
	public static void main(String[] args) {
		List<Dish> menu = DishUtils.getAll();
		
		Optional<Double> sum  =  menu.stream().map(Dish::getCalories).reduce(Double::sum);
		System.out.println(sum.get());
		
		double priSumOfCalories = menu.stream()
				.mapToDouble(Dish::getCalories).sum();
		
		
	 	Optional<Dish> dishOpt =  menu.stream()
		.reduce((d1,d2) -> d1.getCalories() > d1.getCalories() ? d1 : d2 );
		dishOpt.ifPresent(System.out::println);
		
	}
}
