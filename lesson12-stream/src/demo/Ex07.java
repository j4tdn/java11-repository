package demo;

import java.util.List;
import java.util.stream.Collectors;

import bean.Dish;
import bean.Dish.Kind;
import utils.DishUtils;

public class Ex07 {
	public static void main(String[] args) {
		// Stream is "sequences of elements from SOURCE that helps manipulate collections of data"
		// Source: menu
		
		List<Dish> menu = DishUtils.getAll();
		
		List<String> stream = menu.stream()
								  .filter(dish -> Kind.MEAT.equals(dish.getKind()))
								  .map(Dish::getName)
								  .collect(Collectors.toList());
		
		stream.forEach(System.out::println);
		
	}	
}
