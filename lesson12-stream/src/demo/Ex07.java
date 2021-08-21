package demo;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import bean.Dish;
import bean.Dish.Kind;
import utils.DishUtils;

public class Ex07 {
	public static void main(String[] args) {
		List<Dish> menu = DishUtils.getAll();
		
		Set<String> meatDishes =    menu.stream()
								  	  .filter(dish -> Kind.MEAT.equals(dish.getKind()))
								  	  .map(Dish::getName)
								  	  .collect(Collectors.toSet());
		meatDishes.forEach(System.out::println);
		meatDishes.forEach(System.out::println);
	}
}
