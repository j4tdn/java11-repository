package demo;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import bean.Dish;
import bean.Dish.Kind;
import utils.DishUtils;

public class Ex07 {
	public static void main(String[] args) {
		List<Dish> menu = DishUtils.getAll();
		
		menu.stream()
			.filter(dish -> { 
				System.out.println("filer: " + dish.getName());
				return Kind.MEAT.equals(dish.getKind());
				})
			.map(dish -> {
				System.out.println("map: " + dish.getName());
				return dish.getName();
			})
			.count();
		System.out.println("==================");
		
		// what is stream ?
		// stream is sequence of elements from source that help manipulate collections of data
		// stream: source - [intermediate operations - terminal operations] - target
		// intermediate operations >> return type : Stream <T>
		// terminal operations 	   >> return type : non-stream E.g Array, List, Set, Map, Long, Integer
		// steps: menu-source -> stream -> intermediate operation -> steam -> terminal operation -> non-stream type 
		
	}	
}
