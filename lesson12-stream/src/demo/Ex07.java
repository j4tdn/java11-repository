package demo;

import java.util.List;
import java.util.stream.Stream;

import bean.Dish;
import bean.Dish.Kind;
import utils.DishUtils;

public class Ex07 {
	public static void main(String[] args) {
		// Stream is "sequences of elements from Source that helps manipulate collections of data"
		//Source : menu
		List<Dish> menu = DishUtils.getAll();
		
		//menu-source -> stream -> intermediate operation -> stream ->terminal operation -> non-stream type(long,)
		Stream<Dish> stream =  menu.stream();
		
		
		
//		Set<String> meatDishes = 
				menu.stream().filter(dish ->{
									System.out.println("filter: "+ dish.getName() );
									return Kind.MEAT.equals(dish.getKind());
								} )
								.map(dish -> {
									System.out.println("map: "+ dish.getName());
									return dish.getName();
								})
								.count();
		
//		meatDishes.forEach(System.out::println);
		System.out.println("===================");
		
		
		//what is Stream ?
		//Stream is "sequences of elements from Source that helps manipulate collections of data"
		//Stream: SOURCE - [INTERMEADIATE OPERATIONS - TERMINAL OPERATIONS] - TARGET
		//INTERMEADIATE OPERATIONS >> returned type: Stream<T>
		//TERMINAL OPERATIONS      >> returned type: Non-Stream. E.g Array, List, Set, Map, Long, Integer
		//step : menu-source -> stream -> intermediate operation -> stream ->terminal operation -> non-stream type(long, int)
		//Features:
		//1. Traversable once only
		//2. Stream & Collections
		//  Same: can store and manipulate with data
		//  Diff: Collection: Focus on store data
		//			Stream  : Focus on manipulate data,		
		//3. Intermediate operations will do nothing until a terminal operation invoked
		//4. Internal iteration	
		//5. Express a query than ad hoc implementation
	
	}
}