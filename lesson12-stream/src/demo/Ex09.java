package demo;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import bean.Dish;
import utils.CollectionUtils;
import utils.DishUtils;

/**
 * 
 *Select unique dish's calories from menu
 */
public class Ex09 {
	public static void main(String[] args) {
		List<Dish> menu = DishUtils.getAll();
		
		List<Dish> result = menu.stream()
					.filter(dish -> Collections.frequency(menu, dish) == 1)
					.collect(Collectors.toList());
		CollectionUtils.printf(result);
		
		System.out.println("=============uniqueBy===============");
		
		List<Dish> data =  uniqueBy(menu, Dish::getCalories);
		CollectionUtils.printf(data);
		
		System.out.println("==============distinct===========");
		
	List<Dish>	list =  distinctBy(menu, d->d.getCalories());
	CollectionUtils.printf(list);
	}
	
	public static <T, R> List<T> distinctBy(List<T> list, Function<T, R> func){
		Set<R> storage = new HashSet<>();
		return   list.stream()
			.filter(item -> storage.add(func.apply(item)))
			.collect(Collectors.toList());
	}
	
	public static <T,R> List<T> uniqueBy(List<T> list, Function<T,R> func){
		Map<R, List<T>> map = list.stream()
			    .collect(Collectors.groupingBy(func));
		
		return map.entrySet() //Set<Entry<Double, List<Dish>>>
				  .stream()	  //Stream<Entry<Double, List<Dish>>>
				  .filter(e -> e.getValue().size() == 1)
				  .map(e -> e.getValue().get(0))  //Stream<Dish>
				  .collect(Collectors.toList());
		
	}
}
