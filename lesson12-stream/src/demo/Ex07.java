package demo;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import bean.Dish;
import bean.Dish.Kind;
import utils.DishUtils;

public class Ex07 {
	public static void main(String[] args) {
		// Stream is "sequences of elements from SOURCE that helps manipulate collections
		// Source: menu
		List<Dish> menu = DishUtils.getAll();
		
		// menu-source -> stream -> intermediate operation -> stream -> terminal operation -> non-stream type
		menu.stream()
			.filter(dish -> {
				System.out.println("filter: " + dish.getName());
				return Kind.MEAT.equals(dish.getKind());
			}).map(dish -> {
				System.out.println("map: " + dish.getName());
				return dish.getName();
			}).count();
			
		System.out.println("===================");
		
		// What is Stream ?
		// Stream is "Sequences of elemnents from  SOURCE that helps manipulate collections of data"
		// Stream: SOURCE - [INTERMEDIATE OPERATIONS - TERMINAL OPERATIONS] - TARGET
		
		// INTERMEDIATE OPERATIONS >> returned type: Stream<T>
		// TERMINAL OPERATIONS     >> returned type: Non-Stream. E.g Array, List, Set, Map, Long, Integer
		//                         >> count, collect(Collectors.toList(), toMap, soSet), forEach, toArray
		
		// Steps: menu-cource -> stream -> intermediate operation -> stream -> terminal operation -> non-stream type
		// Features:
		// 1. Traversable once only
		// 2. Stream & Collections
		// Same: Can store and manipulate with data
		// Diff: Collection: Focus on store data
		//       Stream    : Focus on manipulate data,
		// 3. Intermediate operations will do nothing untill a terminal operation invoked
		// 4. Internal iteration
		// 5. Express a query than ad hoc implementation
		
		// meatDisher.forEach(System.out::println);
	}
}
