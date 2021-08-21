package demo;

import java.util.ArrayList;
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
		// Stream is "sequences of elements from SOURCE that helps manipulate collection of data"
		// Source: menu
		List<Dish> menu = DishUtils.getAll();
		
		// menu -> stream -> intermediate operation -> stream -> terminal operation -> non-stream type
		menu.stream()
		    .filter(dish -> {
		    	System.out.println("filter: " + dish.getName());
		    	return Kind.MEAT.equals(dish.getKind());
		    })
			.map(dish -> {
				System.out.println("map: " + dish.getName());
		    	return dish.getName();
		    }).count();
		
		System.out.println("==================");
		
		// What is Stream?
		// Stream is "sequences of elements form SOURCE that helps manipulate of data"
		// Stream: SOURCE - [INTERMEDIATE OPERATIONS - TERMINAL OPERATIONS] - TARGET
		
		// INTERMEDIATE OPERATIONS >> returned type: Stream<T>
		// TERMINAL OPERATIONS     >> returned type: Non-Stream. E.g: Array, List, Set, Map, Long, Integer
		//						   >> count, collect(Collector.toList().toMap.toSet), forEach, toArray
		
		// Steps: menu-source -> stream -> intermediate operation -> stream -> terminal operation -> non-stream type
		// Features:
		// 1. Traversable once only
		// 2. Stream && Collections
		// Same: Can store and manipulate with data
		// Diff: Collections: Focus on store data
		//       Stream     : Focus on manipulate data
		// 3. Intermediate operation will do nothing until a terminal operation invoked
		// 4. Internal iteration
		// 5. Express a query than ad hoc implementation
		
		//meatDishes.forEach(System.out::println);
		 
//		List<Dish> meatDishes = new ArrayList<>();
//		for (Dish dish : menu) {
//			if (Kind.MEAT.equals(dish.getKind())) {
//				meatDishes.add(dish);
//			}
//		}
//		
//		meatDishes.forEach(System.out::println);
//		
//		System.out.println("============");
//		
//		List<Dish> result = new ArrayList<>();
//		for (Dish dish : meatDishes) {
//			if (dish.getCalories() > 470) {
//				result.add(dish);
//			}
//			
//		}
//		
//		result.forEach(System.out::println);
	}
}
