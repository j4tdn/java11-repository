package demo;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import bean.Dish;
import bean.Dish.Kind;
import utils.DishUtils;

public class Ex07 {
	public static void main(String[] args) {
		// Stream is "sequences of elements from SOURCE that helps manipulate collections of data"
		List<Dish> menu = DishUtils.getAll();
		
		 menu.stream()
				.filter(d -> {
					System.out.println( "filter : " + d.getName());
					return Kind.MEAT.equals(d.getKind());
				})
				.map(d -> {
					System.out.println("map : " + d.getName());
					return d.getName();
				})
				.count();
		 
		 System.out.println("===========================");
		 
		 // What is Stream ?
		 // Stream is "sequences of elements from SOURCE that helps manipulate collections of data"
		 // Stream : SOURCE - [INTERMEDIATE OPERATIONS - TERMINAL OPERATIONS] - TARGET
		 
		 // INTERMEDIATE OPERATIONS >> return type Stream<T>
		 // TERMINAL OPERATIONS >> return Non-Stream E, Array, List, Set, Map, ...

		// Steps: menu-source -> stream -> intermediate operation -> stream -> terminal operation -> non-stream type (long, collection, array)
			// Features:
			// 1. Traversable once only
			// 2. Stream & Collections
			// Same: Can store and manipulate with data
			// Diff: Collection: Focus on store data
			//       Stream    : Focus on manipulate data, 
			// 3. Intermediate operations will do nothing until a terminal operation invoked
			// 4. Internal iteration
			// 5. Express a query than ad hoc implementation
	}
}
