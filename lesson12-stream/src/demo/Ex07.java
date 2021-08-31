	package demo;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import bean.Dish;
import bean.Dish.Kind;
import utils.DishUtils;

public class Ex07 {
	public static void main(String[] args) {
		//Stream is "sequences of elements from SOURCE that helps manipulate collections of data"
		//Source: menu 
		List<Dish> menu = DishUtils.getAll();
		
		//menu >> stream ->	 goi intermediate operation -> stream -> terminal operation -> non-stream type (long, collection, arrays)
		String[] name =  menu.stream()
				.filter(dish -> {
					System.out.println("filter: " + dish.getName());
					return Kind.MEAT.equals(dish.getKind());
				})
				.map(dish ->{
					System.out.println("map: " + dish.getName());
					return dish.getName();
				}).toArray(String[] :: new);
								
			System.out.println("==========================");
		
			
		//What is stream? 
		//Stream is "sequences of elements from SOURCE that helps manipulate collections of data
		//Stream: SOURCE - [INTERMEDIATE OPERATIONS - TERMINAL OPERATIONS] - TARGET
		
			//INTERMEDIATE OPERATIONS >> return type: Stream<T>
			//TERMINAL OPERATIONS 	  >> return type: Non-Stream: Eg: Array, List, Set, Map, Integer, String
			//						  >> count, collector(Collectors.toList(), toMap, toSet,) forEach, toArray
		//Steps:menu >> stream ->	 goi intermediate operation -> stream -> terminal operation -> non-stream type
		//Features:
		//1. Traversable once only 
		//2. Stream & Collections
		//Same: Can store and manipulate with data	
		//Diff: Collections: focus on store data
		// 		Stream:      Focus on manipulate data	
		//3. Intermediate operations will not do anything until a terminal operations invoked
		//4. Internal iteration: duyet ben trong
		//5. Express a query than ad hoc inplementation 
	}
}
