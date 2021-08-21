package demo;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import bean.Dish;
import bean.Dish.Kind;
import utils.DishUtils;

public class Ex07 {
	public static void main(String[] args) {
		// Stream is a "sequence of elements from SOURCE THAT helps manipulate collection of data
		// Source menu
		
		List<Dish> nemu = DishUtils.getAll();
		
		// menu-source -> stream -> intermediate operation -> stream -> terminal operation -> non - stream type(long,...)
		 nemu.stream()
			.filter(dish -> {
				System.out.println("filter: " + dish.getName());
				return Kind.MEAT.equals(dish.getKind());
			})
			.map(dish -> {
				System.out.println("map: " + dish.getName());
				return dish.getName();
			}).count();
			
			System.out.println("======================");
			
			// what is Stream?
			// Stream is a "sequence of elements from SOURCE THAT helps manipulate collection of data
			// Stream: SOURCE - [INTERMADIATE OPERATETIONS] - TARGET
			
			//INTERMADIATE OPERATETIONS >> return type: Stream<T>
			//TERMINAL OPERATION        >> return type: Non-stream. ex:Array, List, Set, Map, Long, Integer
			//                          >> count, collect(collectors.toList(), toSet, toMap), forEach, toArray
			
			// menu-source -> stream -> intermediate operation -> stream -> terminal operation -> non - stream type(long, )
			// 1. Traversable once only
			// 2. Stream & Collections
			//Same:  Can store and manipulate data;
			// 3. intermediate operations will do nothing until a terminal operation  invoked
			// 4. Internal iteration
			// 5. Express a query than ad hoc implementation
			
	}
}
