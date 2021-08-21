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
		// stream is "sequences of elements from SOURCE that help manipulate collections of data"	
		// Source: menu
		List<Dish> menu = DishUtils.getAll();
		
		// menu-source -> stream -> intermediate operation -> stream -> terminal operation -> non-stream type (long, collections, arrays)
		 	menu.stream()
				.filter(dish -> {
					System.out.println("filter: " + dish.getName() );
					return Kind.MEAT.equals(dish.getKind());
				}).map(dish -> {
					System.out.println("map: " + dish.getName());
					return dish.getName();
				}).count();
				
				
		System.out.println("==================");
		
		// **STREAM**
		// Stream is "sequences of elements from SOURCE that help manipulate collections of data"
		// Stream: SOURCE - [INTERMEDIATE OPERATIONS - TERMINAL OPERATIONS] - TARGET
			
		// INTERMEDIATE OPERATIONS >> returned type: Stream(T)
		// TERMINAL OPERATIONS 	   >> returned type: Non-Stream . E.g Array, List, Set, Map, long
								 //>> count, collect(Collectors.toList(), toMap(), toSet(), ForEach, toArray
		
		// Steps: menu-case -> stream -> intermediate operation -> stream -> terminal operation -> non-stream type
		// Features:
		// 1. Traversable once only
		// 2. Stream & Collections
			// Same: Can store and manipulate with data
			// Diff: - Collection: focus on store data
			//		 - Stream    : focus on manipulate data,	
		// 3. intermediate operation will do nothing until a terminal operation invoked
		// 4. Internal iteration
		// 5. Express a query than ad hoc implementation
	}
	
}
