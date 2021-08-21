package demo;

import java.util.List;

import bean.Dish;
import bean.Dish.Kind;
import utils.DishUtils;

public class Ex07 {
	public static void main(String[] args) {
		// Stream is "sequences of elements from SOURSE that helps manipulate collection
		// of data"
		// Source: menu
		List<Dish> menu = DishUtils.getAll();

		// menu -> stream -> intermediate operation -> stream -> terminal operation ->
		// non-stream type (long, collection)
		menu.stream()
			.filter(dish -> {
				System.out.println("filter: " + dish.getName());
				return Kind.MEAT.equals(dish.getKind());
			})
			.map(dish -> {
				System.out.println("map: " + dish.getName());
				return dish.getName();
			}).count();
		
		System.out.println("================");
		
		// What is Stream?
		// Stream is "sequences of elements from SOURce that helps manipulate collections of data"
		// Stream: SOURCE - INTERMEDIATE OPERATIONS - TERMINAL OPERATIONS] - TARGET
		
		// INTERMEDIATE OPERATIONS >> returned type: Stream<T>
		// TERMINAL OPERATIONS     >> returned type: Non-Stream. E.g Array, Set, List, Map, Long, Integer
		//                         >> count, collect(Collectors.toList(), Collectors.toSet(), to Map), forEach, toArray;
		//
		// Steps: menu-source -> stream -> terminal operation -> non-stream type
		// Features:
		// 1. Traversable once only
		// 2. Stream & Collections
		// Same: Can store and manipulate with data
		// Diff: Collections: Focus on store data
		//       Stream     : Focus on manipulate data
		// 3. Intermediate operations will do nothing until a terminal operation invoked
		// 4. Internal iteration
		// 5. Express a query then ad hoc implementation
	}
}
