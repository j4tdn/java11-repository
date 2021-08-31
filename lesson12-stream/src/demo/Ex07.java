package demo;

import java.util.List;
import java.util.stream.Collectors;

import bean.Dish;
import bean.Dish.Kind;
import utils.DishUtils;

public class Ex07 {
	public static void main(String[] args) {
		// Stream is "sequences of elements from SOURCE that helps manipulate
		// collections of data
		// Source: menu
		List<Dish> menu = DishUtils.getAll();

		// menu -> stream -> intermediate data operation -> stream
		// -> terminal operation -> non-stream type
		List<Dish> meatDishes = menu.stream().filter(e -> Kind.MEAT.equals(e.getKind())).collect(Collectors.toList());
		
		List<String> names = menu.stream().map(Dish::getName).collect(Collectors.toList()); 
		
		// What is stream ?
		// Stream is "sequences of elements from SOURCE that helps manipulate collections of data"
		// Stream: SOURCE - [INTERMEDIATE OPERATIONS -TERMINAL OPERATIONS] - TARGET
		// Steps: menu-source -> stream -> intermediate operation -> stream -> stream -> terminal operation -> non-stream type
		
		// Intermediate operations >> return type: Stream<T>
		// Terminal Operations     >> return type: Non-Stream. E.g Array, List, Set, Map, Long, Integer
		//						   >> count, collect(Collectors.toList(), toMap, toSet), forEach, toArray
		
		// Steps: menu-source  -> stream  -> intermediate operation -> stream -> terminal operations -> non-stream type
		// Features:
		/*
		 * 1. Traversable once only
		 * 2. Stream & Collections
		 * Same: Can store and manipulate with data
		 * Diff: Collection: Focus on store data
		 * 		 Stream    : Focus on manipulate data,
		 * 3. Intermediate operations will do nothing until a terminal operation invoked
		 * 4. Internal iteration
		 * 5. Express a query than ad hoc implementation
		 */
		
	}
}