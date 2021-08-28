package demo;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import bean.Dish;
import utils.CollectionUtils;
import utils.DishUtils;

public class Ex09 {
	public static void main(String[] args) {
		List<Integer> digits = Arrays.asList(1,2,1,3,2,3,4);
		
//		Set<Integer> uniqueNumber = new HashSet<>();
//		
//		Set<Integer> sdigits = digits.stream().filter(t -> t % 2 == 0 && !uniqueNumber.add(t))
//		 .collect(Collectors.toSet());
//		digits.stream().filter(t -> t % 2 == 0 && sdigits.add(t)).forEach(System.out::println);
//		
//		System.out.println("==========================================");
		List<Dish> dishs = DishUtils.getAll();
		
		System.out.println("============Case 1=============");
		Set<Double> test = new HashSet<>();
		Set<Dish> sdishs = dishs.stream().filter(d -> !test.add(d.getCalories())).collect(Collectors.toSet());
		dishs.stream().filter(d -> sdishs.add(d)).forEach(System.out::println);
		
		System.out.println("=======Case 2=============");
		dishs.stream().filter(d -> Collections.frequency(dishs, d) == 1)
		.forEach(System.out::println);
		
		System.out.println("========Case 3=============");
		
//		List<Dish> result = dishs.stream()
//		.collect(Collectors.groupingBy(Dish::getCalories))
//		.entrySet()
//		.stream()
//		.filter(entry -> entry.getValue().size() == 1)
//		.map(e -> e.getValue().get(0))
//		.collect(Collectors.toList());
		
		
		List<Dish> data = uniqueBy(dishs, Dish::getCalories);
		CollectionUtils.printf(data);
		
		System.out.println("====Case 4==============");
		System.out.println("===========distinctBy==============");
		
	}
	
	public static <T, R> List<T> distinctBy(List<T> list, Function<T, R> func){
		Set<R> storage = new HashSet<R>();
		
		return list.stream()
				.filter(item -> storage.add(func.apply(item)))
				.collect(Collectors.toList());
		
	}
	
	
	private static <T,R> List<T> uniqueBy(List<T> list, Function<T, R> func){
		Map<R, List<T>> map = list.stream().collect(Collectors.groupingBy(func));
		
		return map.entrySet()
				.stream()
				.filter(entry -> entry.getValue().size() == 1)
				.map(e -> e.getValue().get(0))
				.collect(Collectors.toList());
	}
	
}
