package demo;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import bean.Dish;
import bean.Dish.Kind;
import utils.DishUtils;

public class Ex07 {
	public static void main(String[] args) {
		// stream is "sequences" of elements from SOURE that helps manipulate
		// collections of data.
		List<Dish> menu = DishUtils.getAll();

		List<String> meatDishes =  menu.stream()
				.filter(d -> d.getKind().equals(Kind.MEAT))
				.filter(d -> d.getCalories() <400).map(Dish::getName)
				.collect(Collectors.toList());
		
		// collect: ->  can be printed many times

		meatDishes.forEach(System.out::println);

	}

}
