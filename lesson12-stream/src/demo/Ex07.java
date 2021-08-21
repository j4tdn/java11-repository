package demo;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import bean.Dish;
import bean.Dish.Kind;
import utils.DishUtils;

public class Ex07 {
	public static void main(String[] args) {
		// Stream is "sequences of elements from SOURCE that helps manipulate collection
		// of data"
		// Source : menu
		List<Dish> menu = DishUtils.getAll();

		// menu -> stream -> intermediate operation -> stream -> terminal operation ->
		// non-stream type(long,collection,array)
		 menu.stream()
		     .filter(dish -> { 
		    	 System.out.println("filter: " + dish.getName());
		    	return Kind.MEAT.equals(dish.getKind());
		     
		     }).map(dish -> {
		    	 System.out.println("map: " + dish.getName());
		    	 return dish.getName();
		     }).count();
		System.out.println("===================");
	}
}
//what is Stream?
//Stream is "sequences of elements from SOURCE that helps manipulate collection of data"
// stream: SOURCE - [INTERMEDIATE OPERATIONS - TERMINAL OPERATIONS] - TARGET
// INTERMEDIATE OPERATIONS >> returned type: Steam<T>
// TERMINAL OPERATIONS >> returned type: Non-Stream.E.g.array,List,Set,Map,Long,Integer;
// Steps:   menu - source -> stream -> intermediate operation -> stream -> terminal operation -> non-stream type(long,collection,array)
// Features:
// 1: Traversable once only
// 2: Stream & Collections
// Same: Can store and manipulate with data
// diff: collection: Focus on store data
//       stream    : Focus on manipulate data
// 3. Intermediate operations will do nothing until a terminal operation invoked
// 4. Internal iteration
// 5. Express a query than ad hoc implementation